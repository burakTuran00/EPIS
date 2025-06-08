package com.project.EPIS.dto.ePulse.response;

import java.util.List;

public class PharmacyResponseDto {
    private List<PharmacyWithDetailDto> pharmacyWithDetailDtos;

    public PharmacyResponseDto() {
    }

    public PharmacyResponseDto(List<PharmacyWithDetailDto> pharmacyWithDetailDtos) {
        this.pharmacyWithDetailDtos = pharmacyWithDetailDtos;
    }

    public List<PharmacyWithDetailDto> getPharmacyWithDetailDtos() {
        return pharmacyWithDetailDtos;
    }

    public void setPharmacyWithDetailDtos(List<PharmacyWithDetailDto> pharmacyWithDetailDtos) {
        this.pharmacyWithDetailDtos = pharmacyWithDetailDtos;
    }
}
