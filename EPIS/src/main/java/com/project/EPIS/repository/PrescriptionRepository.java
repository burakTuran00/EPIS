package com.project.EPIS.repository;

import com.project.EPIS.entity.Prescription;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface PrescriptionRepository extends JpaRepository<Prescription, Integer> {
    Optional<Prescription> findPrescriptionById(int Id);
    Optional<List<Prescription>> findPrescriptionsByPatientId(int patient_id);
}
