package com.project.EPIS.service;

import com.project.EPIS.core.utility.mapper.ModelMapperService;
import com.project.EPIS.dto.MedicationDto;
import com.project.EPIS.entity.Medication;
import com.project.EPIS.exception.EmptyException;
import com.project.EPIS.exception.NotFoundException;
import com.project.EPIS.repository.MedicationRepository;
import org.aspectj.weaver.ast.Not;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MedicationService {
    private final MedicationRepository medicationRepository;
    private final ModelMapperService modelMapperService;

    public MedicationService(MedicationRepository medicationRepository, ModelMapperService modelMapperService) {
        this.medicationRepository = medicationRepository;
        this.modelMapperService = modelMapperService;
    }


    public List<MedicationDto> getAll() {
        List<Medication> medications = medicationRepository.findAll(Sort.by("id").ascending());

        if(medications == null || medications.isEmpty()){
            throw new EmptyException("No medication!");
        }

        List<MedicationDto> result = new ArrayList<>();

        for(Medication medication :medications){
            result.add(modelMapperService.forResponse().map(medication, MedicationDto.class));
        }

        return result;
    }

    public MedicationDto getById(int id) {
        Medication medication = medicationRepository.findById(id)
                .orElseThrow(()-> new NotFoundException("Medication didn't find!"));

        return modelMapperService.forResponse().map(medication, MedicationDto.class);
    }

    public List<MedicationDto> getByGroupId(int id) {
        List<Medication> medications = medicationRepository.
                findMedicationsByGroupId(id , Sort.by("id").ascending())
                .orElseThrow(() -> new NotFoundException("Not Found!"));

        if(medications == null || medications.isEmpty()){
            throw new EmptyException("No medication!");
        }

        List<MedicationDto> result = new ArrayList<>();

        for(Medication medication :medications){
            result.add(modelMapperService.forResponse().map(medication, MedicationDto.class));
        }

        return result;
    }


    public List<MedicationDto> getByNameLike(String name) {
        List<Medication> medications = medicationRepository
                .findMedicationsByNameLike("%" + name + "%", Sort.by("id").ascending())
                .orElseThrow(() -> new NotFoundException("Not found medications!"));

        List<MedicationDto> result = new ArrayList<>();

        for(Medication medication :medications){
            result.add(modelMapperService.forResponse().map(medication, MedicationDto.class));
        }

        return result;
    }
}
