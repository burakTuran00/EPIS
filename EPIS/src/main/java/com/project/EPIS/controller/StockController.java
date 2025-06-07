package com.project.EPIS.controller;

import com.project.EPIS.dto.StockDto;
import com.project.EPIS.service.StockService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/stocks")
public class StockController {
    private final StockService stockService;

    public StockController(StockService stockService) {
        this.stockService = stockService;
    }

    @GetMapping("/")
    public ResponseEntity<List<StockDto>> getAll(){
        return ResponseEntity.ok(stockService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<StockDto> getById(@PathVariable("id") int id){
        return ResponseEntity.ok(stockService.getById(id));
    }

    @GetMapping("/withPharmacy/{pharmacyId}")
    public ResponseEntity<List<StockDto>> getByPharmacyId(@PathVariable("pharmacyId") int pharmacyId){
        return ResponseEntity.ok(stockService.getByPharmacyId(pharmacyId));
    }

    @GetMapping("/withMedication/{medicationId}")
    public ResponseEntity<List<StockDto>> getByMedicationId(@PathVariable("medicationId") int medicationId){
        return ResponseEntity.ok(stockService.getByMedicationId(medicationId));
    }
}
