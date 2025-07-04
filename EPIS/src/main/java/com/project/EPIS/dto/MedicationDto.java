package com.project.EPIS.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Objects;

@Data
public class MedicationDto {
    //region Property
    private int id;
    private String name;
    private String dosage;
    private String form;
    private String description;
    private Double price;
    private boolean prescriptionRequired;
    private int medicationGroupId;
    //endregion Property

    //region Constructor

    public MedicationDto() {
    }

    public MedicationDto(int id, String name, String dosage, String form, String description, Double price, boolean prescriptionRequired, int medicationGroupId) {
        this.id = id;
        this.name = name;
        this.dosage = dosage;
        this.form = form;
        this.description = description;
        this.price = price;
        this.prescriptionRequired = prescriptionRequired;
        this.medicationGroupId = medicationGroupId;
    }
    //endregion Constructor

    //region Getters and Setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDosage() {
        return dosage;
    }

    public void setDosage(String dosage) {
        this.dosage = dosage;
    }

    public String getForm() {
        return form;
    }

    public void setForm(String form) {
        this.form = form;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public boolean isPrescriptionRequired() {
        return prescriptionRequired;
    }

    public void setPrescriptionRequired(boolean prescriptionRequired) {
        this.prescriptionRequired = prescriptionRequired;
    }

    public int getMedicationGroupId() {
        return medicationGroupId;
    }

    public void setMedicationGroupId(int medicationGroupId) {
        this.medicationGroupId = medicationGroupId;
    }

    //endregion Getters and Setters

}
