package com.project.EPIS.controller;

import com.project.EPIS.dto.PharmacyDto;
import com.project.EPIS.service.PharmacyService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/pharmacies")
public class PharmacyController {
    private final PharmacyService pharmacyService;

    public PharmacyController(PharmacyService pharmacyService) {
        this.pharmacyService = pharmacyService;
    }

    @GetMapping("/")
    public ResponseEntity<List<PharmacyDto>> getAll(){
        return ResponseEntity.ok(pharmacyService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<PharmacyDto> getById(@PathVariable("id") int id){
        return ResponseEntity.ok(pharmacyService.getById(id));
    }
}
