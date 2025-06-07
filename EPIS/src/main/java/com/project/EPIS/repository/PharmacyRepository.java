package com.project.EPIS.repository;

import com.project.EPIS.entity.Pharmacy;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface PharmacyRepository extends JpaRepository<Pharmacy, Integer> {

    Optional<List<Pharmacy>> findPharmaciesByCity(String city);
}
