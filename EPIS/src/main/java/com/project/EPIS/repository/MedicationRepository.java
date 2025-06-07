package com.project.EPIS.repository;

import com.project.EPIS.entity.Medication;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface MedicationRepository extends JpaRepository<Medication, Integer> {
    @Query(value = "SELECT * FROM medications WHERE group_id = :id", nativeQuery = true)
    Optional<List<Medication>> findMedicationsByGroupId(@Param("id") int id, Sort sort);

    Optional<List<Medication>> findMedicationsByNameLike(@Param("name") String name, Sort sort);
}
