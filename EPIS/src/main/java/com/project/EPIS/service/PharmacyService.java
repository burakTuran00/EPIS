package com.project.EPIS.service;

import com.project.EPIS.core.utility.mapper.ModelMapperService;
import com.project.EPIS.dto.PharmacyDto;
import com.project.EPIS.entity.Pharmacy;
import com.project.EPIS.exception.EmptyException;
import com.project.EPIS.exception.NotFoundException;
import com.project.EPIS.repository.PharmacyRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PharmacyService {
    private final PharmacyRepository pharmacyRepository;
    private final ModelMapperService modelMapperService;

    public PharmacyService(PharmacyRepository pharmacyRepository, ModelMapperService modelMapperService) {
        this.pharmacyRepository = pharmacyRepository;
        this.modelMapperService = modelMapperService;
    }

    public List<PharmacyDto> getAll() {
        List<Pharmacy> pharmacies = pharmacyRepository.findAll();

        if(pharmacies == null || pharmacies.isEmpty()){
            throw new EmptyException("Empty");
        }

        List<PharmacyDto> result = new ArrayList<>();

        for(Pharmacy pharmacy :pharmacies){
            result.add(modelMapperService.forResponse().map(pharmacy, PharmacyDto.class));
        }

        return result;
    }

    public PharmacyDto getById(int id) {
        Pharmacy pharmacy = pharmacyRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Not Found Pharmacy"));

        return modelMapperService.forResponse().map(pharmacy, PharmacyDto.class);
    }

    public List<Pharmacy> findByCity(String city){
        return   pharmacyRepository
                .findPharmaciesByCity(city)
                .orElseThrow(() -> new EmptyException("Not found Available Pharmacy!"));
    }

    public List<PharmacyDto> getByCityLike(String city) {
        List<Pharmacy> pharmacies = pharmacyRepository.findPharmaciesByCityLike("%"+city+"%")
                .orElseThrow(() -> new NotFoundException("Not found pharmacy!"));
        List<PharmacyDto> result = new ArrayList<>();

        for(Pharmacy pharmacy: pharmacies){
            result.add(modelMapperService.forResponse().map(pharmacy, PharmacyDto.class));
        }

        return result;
    }
}
