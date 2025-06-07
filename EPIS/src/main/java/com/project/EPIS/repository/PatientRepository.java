package com.project.EPIS.repository;

import com.project.EPIS.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PatientRepository extends JpaRepository<Patient, Integer> {
    Optional<Patient> findPatientById(int id);
}
