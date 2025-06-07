package com.project.EPIS.controller;

import com.project.EPIS.dto.MedicationGroupDto;
import com.project.EPIS.service.MedicationGroupService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/medication_groups")
public class MedicationGroupController {
    private final MedicationGroupService medicationGroupService;

    public MedicationGroupController(MedicationGroupService medicationGroupService) {
        this.medicationGroupService = medicationGroupService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<MedicationGroupDto> getById(@PathVariable int id){
        return ResponseEntity.ok(medicationGroupService.getById(id));
    }
}
