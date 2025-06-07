package com.project.EPIS.service;

import com.project.EPIS.core.utility.mapper.IModelMapperService;
import com.project.EPIS.core.utility.mapper.ModelMapperService;
import com.project.EPIS.dto.MedicationDto;
import com.project.EPIS.dto.PharmacyDto;
import com.project.EPIS.dto.ePulse.request.FindPharmacyRequestDto;
import com.project.EPIS.entity.Medication;
import com.project.EPIS.entity.MedicationGroup;
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

    public List<PharmacyDto> findPharmacy(FindPharmacyRequestDto requestDto) {
        List<Pharmacy> pharmacies = pharmacyService.findByCity(requestDto.getCity());
        List<Medication> medications = medicationService.getAllWithEntity();

        List<PharmacyDto> result = new ArrayList<>();

        for (Pharmacy pharmacy : pharmacies) {
            List<Integer> tempList = new ArrayList<>(requestDto.getMedicationIds());
            List<Stock> tempStock = pharmacy.getStocks();

            for (Stock stock : tempStock) {
                Medication tempMedication = stock.getMedication();
                MedicationGroup tempGroup = tempMedication.getMedicationGroup();

                if (tempList.contains(tempMedication.getId()) && stock.getQuantity() > 0) {
                    tempList.remove(Integer.valueOf(tempMedication.getId()));
                }
            }

            if (tempList.isEmpty()) {
                result.add(modelMapperService.forResponse().map(pharmacy, PharmacyDto.class));
            }
        }

        return result;
    }
}
