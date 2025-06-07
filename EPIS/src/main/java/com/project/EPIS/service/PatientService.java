package com.project.EPIS.service;

import com.project.EPIS.core.utility.mapper.ModelMapperService;
import com.project.EPIS.dto.PatientDto;
import com.project.EPIS.entity.Patient;
import com.project.EPIS.exception.NotFoundException;
import com.project.EPIS.repository.PatientRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PatientService {

    private final PatientRepository patientRepository;
    private final ModelMapperService modelMapperService;

    public PatientService(PatientRepository patientRepository, ModelMapperService modelMapperService) {
        this.patientRepository = patientRepository;
        this.modelMapperService = modelMapperService;
    }

    public List<PatientDto> getAll() {
        List<Patient> patients = patientRepository.findAll();

        if(patients == null || patients.isEmpty()){
            throw new NotFoundException("Patient is not found!");
        }

        List<PatientDto> result = new ArrayList<>();

        for(Patient patient : patients){
            result.add(modelMapperService.forResponse().map(patient, PatientDto.class));
        }

        return result;
    }

    public PatientDto getById(int id) {
        Patient patient = patientRepository.findPatientById(id)
                .orElseThrow(() -> new NotFoundException("Patient is not found!"));

        return modelMapperService.forResponse().map(patient, PatientDto.class);
    }
}
