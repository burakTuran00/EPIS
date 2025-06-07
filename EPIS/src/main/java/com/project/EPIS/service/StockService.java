package com.project.EPIS.service;

import com.project.EPIS.core.utility.mapper.ModelMapperService;
import com.project.EPIS.dto.StockDto;
import com.project.EPIS.entity.Stock;
import com.project.EPIS.exception.EmptyException;
import com.project.EPIS.exception.NotFoundException;
import com.project.EPIS.repository.StockRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StockService {
    private final StockRepository stockRepository;
    private final ModelMapperService modelMapperService;

    public StockService(StockRepository stockRepository, ModelMapperService modelMapperService) {
        this.stockRepository = stockRepository;
        this.modelMapperService = modelMapperService;
    }

    public List<StockDto> getAll() {
        List<Stock> stocks = stockRepository.findAll();

        if(stocks == null || stocks.isEmpty()){
            throw new EmptyException("Stock not exist!");
        }

        List<StockDto> result = new ArrayList<>();

        for(Stock stock : stocks){
            result.add(modelMapperService.forResponse().map(stock, StockDto.class));
        }
        return result;
    }

    public StockDto getById(int id) {
        Stock stock = stockRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Not found Stock!"));

        return modelMapperService.forResponse().map(stock, StockDto.class);
    }

    public List<StockDto> getByPharmacyId(int pharmacyId) {
        List<Stock> stocks = stockRepository.findStocksByPharmacyId(pharmacyId)
                .orElseThrow(() -> new NotFoundException("Not found Stock!"));

        if(stocks == null || stocks.isEmpty()){
            throw new EmptyException("Stock not exist!");
        }

        List<StockDto> result = new ArrayList<>();

        for(Stock stock : stocks){
            result.add(modelMapperService.forResponse().map(stock, StockDto.class));
        }
        return result;
    }

    public List<StockDto> getByMedicationId(int medicationId) {
        List<Stock> stocks = stockRepository.findStocksByMedicationId(medicationId)
                .orElseThrow(() -> new NotFoundException("Not found Stock!"));

        if(stocks == null || stocks.isEmpty()){
            throw new EmptyException("Stock not exist!");
        }

        List<StockDto> result = new ArrayList<>();

        for(Stock stock : stocks){
            result.add(modelMapperService.forResponse().map(stock, StockDto.class));
        }
        return result;
    }
}
