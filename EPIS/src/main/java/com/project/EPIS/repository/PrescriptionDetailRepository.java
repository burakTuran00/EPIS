package com.project.EPIS.repository;

import com.project.EPIS.entity.PrescriptionDetail;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface PrescriptionDetailRepository extends JpaRepository<PrescriptionDetail, Integer> {
    Optional<List<PrescriptionDetail>> findAllByPrescriptionId(int prescriptionId);
}
