package com.project.EPIS.service;

import com.project.EPIS.core.utility.mapper.ModelMapperService;
import com.project.EPIS.dto.MedicationDto;
import com.project.EPIS.dto.PharmacyDto;
import com.project.EPIS.dto.ePulse.request.FindPharmacyRequestDto;
import com.project.EPIS.dto.ePulse.response.PharmacyResponseDto;
import com.project.EPIS.dto.ePulse.response.PharmacyWithDetailDto;
import com.project.EPIS.entity.Medication;
import com.project.EPIS.entity.Pharmacy;
import com.project.EPIS.entity.Stock;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EPharmacyService {
    private final PharmacyService pharmacyService;
    private final MedicationService medicationService;
    private final ModelMapperService modelMapperService;

    public EPharmacyService(PharmacyService pharmacyService, MedicationService medicationService, ModelMapperService modelMapperService) {
        this.pharmacyService = pharmacyService;
        this.medicationService = medicationService;
        this.modelMapperService = modelMapperService;
    }

    public PharmacyResponseDto findPharmacy(FindPharmacyRequestDto requestDto)
    {
        List<Pharmacy> pharmacies = pharmacyService.findByCity(requestDto.getCity());

        List<PharmacyWithDetailDto> pharmacyWithDetailDtos = new ArrayList<>();
        PharmacyResponseDto result = new PharmacyResponseDto();

        for (Pharmacy pharmacy : pharmacies)
        {
            List<Integer> medicationIdList = new ArrayList<>(requestDto.getMedicationIds());
            List<Stock> tempStock = pharmacy.getStocks();
            PharmacyWithDetailDto tempResult = new PharmacyWithDetailDto();

            List<MedicationDto> medicationDtos = new ArrayList<>();

            for (Stock stock : tempStock)
            {
                Medication tempMedication = stock.getMedication();

                if (medicationIdList.contains(tempMedication.getId()) && stock.getQuantity() > 0)
                {
                    medicationDtos.add(modelMapperService.forResponse().map(tempMedication, MedicationDto.class));
                    medicationIdList.remove(Integer.valueOf(tempMedication.getId()));
                }
            }

            if(!medicationIdList.isEmpty())
            {
                for(Integer medicationId : new ArrayList<>(medicationIdList))
                {
                    if(medicationIdList.isEmpty()) {
                        break;
                    }

                    MedicationDto originalMedication  = modelMapperService.forResponse().map(medicationService.getById(medicationId), MedicationDto.class);
                    List<MedicationDto> equivalentMedications = medicationService.getByGroupId(originalMedication .getMedicationGroupId());

                    for(Stock stock : tempStock)
                    {
                        if(medicationIdList.isEmpty()) {
                            break;
                        }

                        MedicationDto tempStockMedication = modelMapperService.forResponse().map(stock.getMedication(), MedicationDto.class);

                        if(equivalentMedications.stream().count() > 0)
                        {
                            for(MedicationDto eq : equivalentMedications)
                            {
                                if(eq.equals(tempStockMedication) && stock.getQuantity() > 0)
                                {
                                    medicationDtos.add(tempStockMedication);
                                    medicationIdList.remove(medicationId);
                                    break;
                                }
                            }
                        }
                    }
                }
            }

            if (medicationIdList.isEmpty()) {
                tempResult.setPharmacyDto(modelMapperService.forResponse().map(pharmacy, PharmacyDto.class));
                tempResult.setMedicationDtos(medicationDtos);

                pharmacyWithDetailDtos.add(tempResult);
            }
        }

        result.setPharmacyWithDetailDtos(pharmacyWithDetailDtos);

        return result;
    }
}