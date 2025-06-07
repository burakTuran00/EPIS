package com.project.EPIS.controller;

import com.project.EPIS.dto.PrescriptionDto;
import com.project.EPIS.entity.Prescription;
import com.project.EPIS.service.PrescriptionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/prescriptions")
public class PrescriptionController {
    private final PrescriptionService prescriptionService;

    public PrescriptionController(PrescriptionService prescriptionService) {
        this.prescriptionService = prescriptionService;
    }

    @GetMapping("/")
    public ResponseEntity<List<PrescriptionDto>> getAll(){
        return ResponseEntity.ok(prescriptionService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<PrescriptionDto> getById(@PathVariable int id){
        return ResponseEntity.ok(prescriptionService.getById(id));
    }

    @GetMapping("/withPatient/{patientId}")
    public ResponseEntity<List<PrescriptionDto>> findByPatientId(@PathVariable int patientId){
        return ResponseEntity.ok(prescriptionService.findByPatientId(patientId));
    }

    @GetMapping("{prescriptionId}/withPatient/{patientId}")
    public ResponseEntity<PrescriptionDto> getSpecificPrescription(@PathVariable("patientId") int patientId,
                                                                   @PathVariable("prescriptionId") int prescriptionId){
        return ResponseEntity.ok(prescriptionService.getSpecificPrescription(patientId, prescriptionId));
    }
}
