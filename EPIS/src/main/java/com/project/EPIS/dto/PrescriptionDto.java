package com.project.EPIS.dto;

import java.util.Date;

public class PrescriptionDto {

    //region Property
    private int id;
    private int patientId;
    private boolean isValid;
    private Date expireDate;
    //endregion Property

    //region Constructor

    public PrescriptionDto() {
    }

    public PrescriptionDto(int id, int patientId, boolean isValid, Date expireDate) {
        this.id = id;
        this.patientId = patientId;
        this.isValid = isValid;
        this.expireDate = expireDate;
    }
//endregion Constructor

    //region Getters and Setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPatientId() {
        return patientId;
    }

    public void setPatientId(int patientId) {
        this.patientId = patientId;
    }

    public boolean isValid() {
        return isValid;
    }

    public void setValid(boolean valid) {
        isValid = valid;
    }

    public Date getExpireDate() {
        return expireDate;
    }

    public void setExpireDate(Date expireDate) {
        this.expireDate = expireDate;
    }

    //endregion Getters and Setters
}
