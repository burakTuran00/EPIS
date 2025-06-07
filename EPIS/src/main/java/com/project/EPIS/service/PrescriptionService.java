package com.project.EPIS.service;

import com.project.EPIS.core.utility.mapper.ModelMapperService;
import com.project.EPIS.dto.PrescriptionDto;
import com.project.EPIS.entity.Prescription;
import com.project.EPIS.exception.NotFoundException;
import com.project.EPIS.repository.PrescriptionRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PrescriptionService {
    private final PrescriptionRepository prescriptionRepository;
    private final ModelMapperService modelMapperService;

    public PrescriptionService(PrescriptionRepository prescriptionRepository, ModelMapperService modelMapperService) {
        this.prescriptionRepository = prescriptionRepository;
        this.modelMapperService = modelMapperService;
    }

    public List<PrescriptionDto> getAll() {
        List<Prescription> prescriptions = prescriptionRepository.findAll();

        if(prescriptions == null || prescriptions.isEmpty()){
            throw new NotFoundException("Doesn't exist any prescription!");
        }

        List<PrescriptionDto> result = new ArrayList<>();

        for(Prescription prescription : prescriptions){
            result.add(modelMapperService.forResponse().map(prescription, PrescriptionDto.class));
        }

        return result;
    }

    public PrescriptionDto getById(int id) {
        Prescription prescription = prescriptionRepository.findPrescriptionById(id)
                .orElseThrow(() -> new NotFoundException("Prescription don't exist!"));

        return modelMapperService.forResponse().map(prescription, PrescriptionDto.class);
    }

    public List<PrescriptionDto> findByPatientId(int patientId) {
        List<Prescription> prescriptions = prescriptionRepository.findPrescriptionsByPatientId(patientId)
                .orElseThrow(() -> new NotFoundException("No found prescription!"));

        if(prescriptions == null || prescriptions.isEmpty()){
            throw new NotFoundException("No found prescription!");
        }

        List<PrescriptionDto> result = new ArrayList<>();

        for(Prescription prescription : prescriptions){
            result.add(modelMapperService.forResponse().map(prescription, PrescriptionDto.class));
        }

        return result;
    }
}
