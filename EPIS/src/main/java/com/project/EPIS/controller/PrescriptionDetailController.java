package com.project.EPIS.controller;

import com.project.EPIS.dto.PrescriptionDetailDto;
import com.project.EPIS.service.PrescriptionDetailService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/prescription_details")
public class PrescriptionDetailController {
    private final PrescriptionDetailService prescriptionDetailService;

    public PrescriptionDetailController(PrescriptionDetailService prescriptionDetailService) {
        this.prescriptionDetailService = prescriptionDetailService;
    }

    @GetMapping("/")
    public ResponseEntity<List<PrescriptionDetailDto>> getAll(){
        return ResponseEntity.ok(prescriptionDetailService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<PrescriptionDetailDto> getById(@PathVariable("id") int id){
        return ResponseEntity.ok(prescriptionDetailService.getById(id));
    }

    @GetMapping("/withPrescription/{prescriptionId}")
    public ResponseEntity<List<PrescriptionDetailDto>> getByPrescriptionId(@PathVariable("prescriptionId") int prescriptionId){
        return ResponseEntity.ok(prescriptionDetailService.getByPrescriptionId(prescriptionId));
    }
}
