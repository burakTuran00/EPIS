package com.project.EPIS.service;

import com.project.EPIS.core.utility.mapper.ModelMapperService;
import com.project.EPIS.dto.MedicationGroupDto;
import com.project.EPIS.entity.MedicationGroup;
import com.project.EPIS.exception.NotFoundException;
import com.project.EPIS.repository.MedicationGroupRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MedicationGroupService {
    private final MedicationGroupRepository medicationGroupRepository;
    private final ModelMapperService modelMapperService;

    public MedicationGroupService(MedicationGroupRepository medicationGroupRepository, ModelMapperService modelMapperService) {
        this.medicationGroupRepository = medicationGroupRepository;
        this.modelMapperService = modelMapperService;
    }

    public MedicationGroupDto getById(int id) {
        MedicationGroup medicationGroups = medicationGroupRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("not found!"));

        return modelMapperService.forResponse().map(medicationGroups, MedicationGroupDto.class);
    }
}
