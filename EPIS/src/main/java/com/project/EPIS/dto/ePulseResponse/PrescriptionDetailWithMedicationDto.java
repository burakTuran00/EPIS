package com.project.EPIS.dto.ePulseResponse;

import com.project.EPIS.dto.MedicationDto;

public class PrescriptionDetailWithMedicationDto {
    private MedicationDto medicationDto;

    public PrescriptionDetailWithMedicationDto() {
    }

    public PrescriptionDetailWithMedicationDto( MedicationDto medicationDto) {
        this.medicationDto = medicationDto;
    }

    public MedicationDto getMedicationDto() {
        return medicationDto;
    }

    public void setMedicationDto(MedicationDto medicationDto) {
        this.medicationDto = medicationDto;
    }
}
