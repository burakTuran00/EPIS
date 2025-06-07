package com.project.EPIS.service;

import com.project.EPIS.dto.PharmacyDto;
import com.project.EPIS.dto.ePulse.request.FindPharmacyRequestDto;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EPharmacyService {
    private final PharmacyService pharmacyService;

    public EPharmacyService(PharmacyService pharmacyService) {
        this.pharmacyService = pharmacyService;
    }

    public List<PharmacyDto> findPharmacy(FindPharmacyRequestDto requestDto) {
        return pharmacyService.findAvailablePharmacies(requestDto);
    }
}
