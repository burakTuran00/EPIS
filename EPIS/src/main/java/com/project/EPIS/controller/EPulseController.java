package com.project.EPIS.controller;

import com.project.EPIS.dto.PrescriptionDetailDto;
import com.project.EPIS.dto.PrescriptionDto;
import com.project.EPIS.dto.ePulseResponse.PrescriptionWithDetailDto;
import com.project.EPIS.service.EPulseService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/ePulseProvider")
public class EPulseController {
    private final EPulseService ePulseService;

    public EPulseController(EPulseService ePulseService) {
        this.ePulseService = ePulseService;
    }

    /// To get all prescriptions of the patient.
    @GetMapping("/getMyPrescriptions/{patientId}")
    public ResponseEntity<List<PrescriptionDto>> getMyPrescriptions(@PathVariable("patientId") int patientId){
        return ResponseEntity.ok(ePulseService.getMyPrescriptions(patientId));
    }

    /// To get a specific prescription of the patient.
    @GetMapping("/{patientId}/getMyPrescription/{prescriptionId}")
    public ResponseEntity<PrescriptionDto> getMyPrescription(@PathVariable("patientId") int patientId,
                                                             @PathVariable("prescriptionId") int prescriptionId)
    {
        return ResponseEntity.ok(ePulseService.getMyPrescription(patientId, prescriptionId));
    }

    /// To get details of the prescription.
    @GetMapping("/detail/{prescriptionId}")
    public ResponseEntity<List<PrescriptionDetailDto>> getDetailOfPrescription(@PathVariable("prescriptionId") int prescriptionId) {
        return ResponseEntity.ok(ePulseService.getDetailOfPrescription(prescriptionId));
    }

    /// to get medications of the prescription.
    @GetMapping("/{patientId}/detail/{prescriptionId}")
    public ResponseEntity<PrescriptionWithDetailDto> getMedicationsOfPrescription(@PathVariable("patientId") int patientId,
                                                                                  @PathVariable("prescriptionId")int prescriptionId){
        return ResponseEntity.ok(ePulseService.getMedicationsOfPrescription(patientId, prescriptionId));
    }
}
