package com.project.EPIS.service;

import com.project.EPIS.dto.PrescriptionDetailDto;
import com.project.EPIS.dto.PrescriptionDto;
import com.project.EPIS.dto.ePulseResponse.PrescriptionDetailWithMedicationDto;
import com.project.EPIS.dto.ePulseResponse.PrescriptionWithDetailDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EPulseService {
    private final PrescriptionService prescriptionService;
    private final PrescriptionDetailService prescriptionDetailService;
    private final MedicationService medicationService;

    public EPulseService(PrescriptionService prescriptionService, PrescriptionDetailService prescriptionDetailService, MedicationService medicationService) {
        this.prescriptionService = prescriptionService;
        this.prescriptionDetailService = prescriptionDetailService;
        this.medicationService = medicationService;
    }

    public List<PrescriptionDto> getMyPrescriptions(int patientId) {
        return prescriptionService.findByPatientId(patientId);
    }

    public PrescriptionDto getMyPrescription(int patientId, int prescriptionId) {
        return prescriptionService.getSpecificPrescription(patientId, prescriptionId);
    }

    public List<PrescriptionDetailDto> getDetailOfPrescription(int prescriptionId) {
        return prescriptionDetailService.getByPrescriptionId(prescriptionId);
    }

    public PrescriptionWithDetailDto getMedicationsOfPrescription(int patientId, int prescriptionId) {
        PrescriptionDto prescriptionDto = prescriptionService.getSpecificPrescription(patientId,prescriptionId);
        List<PrescriptionDetailWithMedicationDto> details = prescriptionDetailService.getPrescriptionWithDetail(prescriptionId);
        return new PrescriptionWithDetailDto(prescriptionDto, details);
    }
}
