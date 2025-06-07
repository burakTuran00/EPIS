package com.project.EPIS.controller;

import com.project.EPIS.dto.PharmacyDto;
import com.project.EPIS.dto.ePulse.request.FindPharmacyRequestDto;
import com.project.EPIS.service.EPharmacyService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/ePharmacyProvider")
public class EPharmacyController {
    private final EPharmacyService ePharmacyService;

    public EPharmacyController(EPharmacyService ePharmacyService) {
        this.ePharmacyService = ePharmacyService;
    }

    @PostMapping("/findPharmacy")
    public ResponseEntity<List<PharmacyDto>> findPharmacy(@RequestBody FindPharmacyRequestDto requestDto) {
        return ResponseEntity.ok(ePharmacyService.findPharmacy(requestDto));
    }
}
