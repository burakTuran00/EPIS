package com.project.EPIS.service;

import com.project.EPIS.core.utility.mapper.ModelMapperService;
import com.project.EPIS.dto.PrescriptionDetailDto;
import com.project.EPIS.entity.PrescriptionDetail;
import com.project.EPIS.exception.EmptyException;
import com.project.EPIS.exception.NotFoundException;
import com.project.EPIS.repository.PrescriptionDetailRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PrescriptionDetailService {
    private final PrescriptionDetailRepository prescriptionDetailRepository;
    private final ModelMapperService modelMapperService;


    public PrescriptionDetailService(PrescriptionDetailRepository prescriptionDetailRepository,
                                     ModelMapperService modelMapperService) {
        this.prescriptionDetailRepository = prescriptionDetailRepository;
        this.modelMapperService = modelMapperService;
    }

    public List<PrescriptionDetailDto> getAll() {
        List<PrescriptionDetail> prescriptionDetails = prescriptionDetailRepository.findAll();

        if(prescriptionDetails == null ||prescriptionDetails.isEmpty()){
            throw new EmptyException("Empty Prescription List!");
        }

        List<PrescriptionDetailDto> result = new ArrayList<>();

        for(PrescriptionDetail pDetail : prescriptionDetails){
            result.add(modelMapperService.forResponse().map(pDetail, PrescriptionDetailDto.class));
        }

        return result;
    }

    public PrescriptionDetailDto getById(int id)
    {
        PrescriptionDetail prescriptionDetail =
                prescriptionDetailRepository
                        .findById(id)
                        .orElseThrow(() -> new NotFoundException("Not fount detail of prescription!"));

        return modelMapperService.forResponse().map(prescriptionDetail,PrescriptionDetailDto.class);
    }

    public List<PrescriptionDetailDto> getByPrescriptionId(int prescriptionId) {
        List<PrescriptionDetail> prescriptionDetails = prescriptionDetailRepository
                .findAllByPrescriptionId(prescriptionId)
                .orElseThrow(() -> new NotFoundException("Not found detail of prescription!"));

        if(prescriptionDetails == null ||prescriptionDetails.isEmpty()){
            throw new EmptyException("Empty Prescription List!");
        }

        List<PrescriptionDetailDto> result = new ArrayList<>();

        for(PrescriptionDetail pDetail : prescriptionDetails){
            result.add(modelMapperService.forResponse().map(pDetail, PrescriptionDetailDto.class));
        }

        return result;
    }
}
