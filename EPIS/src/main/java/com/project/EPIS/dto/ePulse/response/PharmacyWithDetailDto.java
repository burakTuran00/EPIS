package com.project.EPIS.dto.ePulse.response;

import com.project.EPIS.dto.MedicationDto;
import com.project.EPIS.dto.PharmacyDto;

import java.util.List;

public class PharmacyWithDetailDto {
    private PharmacyDto pharmacyDto;
    private List<MedicationDto> medicationDtos;

    public PharmacyWithDetailDto() {
    }

    public PharmacyWithDetailDto(PharmacyDto pharmacyDto, List<MedicationDto> medicationDtos) {
        this.pharmacyDto = pharmacyDto;
        this.medicationDtos = medicationDtos;
    }

    public PharmacyDto getPharmacyDto() {
        return pharmacyDto;
    }

    public void setPharmacyDto(PharmacyDto pharmacyDto) {
        this.pharmacyDto = pharmacyDto;
    }

    public List<MedicationDto> getMedicationDtos() {
        return medicationDtos;
    }

    public void setMedicationDtos(List<MedicationDto> medicationDtos) {
        this.medicationDtos = medicationDtos;
    }
}
