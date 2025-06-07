package com.project.EPIS.dto;

import com.project.EPIS.entity.Medication;
import com.project.EPIS.entity.Pharmacy;


public class StockDto {
    private int id;
    private int medicationId;
    private int quantity;
    private int pharmacyId;

    public StockDto() {
    }

    public StockDto(int id, int medicationId, int quantity, int pharmacyId) {
        this.id = id;
        this.medicationId = medicationId;
        this.quantity = quantity;
        this.pharmacyId = pharmacyId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getMedicationId() {
        return medicationId;
    }

    public void setMedicationId(int medicationId) {
        this.medicationId = medicationId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getPharmacyId() {
        return pharmacyId;
    }

    public void setPharmacyId(int pharmacyId) {
        this.pharmacyId = pharmacyId;
    }
}
