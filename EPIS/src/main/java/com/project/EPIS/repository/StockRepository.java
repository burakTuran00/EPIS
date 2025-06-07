package com.project.EPIS.repository;

import com.project.EPIS.entity.Stock;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface StockRepository extends JpaRepository<Stock, Integer> {
    Optional<List<Stock>> findStocksByPharmacyId(int id);
    Optional<List<Stock>> findStocksByMedicationId(int id);
}
