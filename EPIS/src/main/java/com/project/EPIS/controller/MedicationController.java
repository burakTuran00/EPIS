package com.project.EPIS.controller;

import com.project.EPIS.dto.MedicationDto;
import com.project.EPIS.entity.Medication;
import com.project.EPIS.service.MedicationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/medications")
public class MedicationController {
    private final MedicationService medicationService;

    public MedicationController(MedicationService medicationService) {
        this.medicationService = medicationService;
    }

    @GetMapping("/")
    public ResponseEntity<List<MedicationDto>> getAll(){
        return ResponseEntity.ok(medicationService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<MedicationDto> getById(@PathVariable("id") int id){
        return ResponseEntity.ok(medicationService.getById(id));
    }

    @GetMapping("/groupBy/{id}")
    public ResponseEntity<List<MedicationDto>> getByGroupId(@PathVariable("id") int id){
        return ResponseEntity.ok(medicationService.getByGroupId(id));
    }

    @GetMapping("/getByName/{name}")
    public ResponseEntity<List<MedicationDto>> getByNameLike(@PathVariable("name") String name){
        return ResponseEntity.ok(medicationService.getByNameLike(name));
    }
}
