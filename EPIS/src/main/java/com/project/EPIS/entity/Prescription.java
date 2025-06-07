package com.project.EPIS.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "prescription")
public class Prescription {
    //region Properties
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @ManyToOne
    @JoinColumn(name = "patient_id")
    @JsonIgnore
    private Patient patient;

    @Column(name = "isValid")
    private boolean isValid;

    @Column(name = "expire_date")
    private Date expireDate;

    @OneToMany(mappedBy = "prescription")
    @JsonManagedReference
    private List<PrescriptionDetail> prescriptionDetails;
    // endregion Properties

    // region Constructor
    public Prescription() {
    }

    public Prescription(int id, Patient patient, boolean isValid, Date expireDate, List<PrescriptionDetail> prescriptionDetails) {
        this.id = id;
        this.patient = patient;
        this.isValid = isValid;
        this.expireDate = expireDate;
        this.prescriptionDetails = prescriptionDetails;
    }
    // endregion Constructor

    // region Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
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

    public List<PrescriptionDetail> getPrescriptionDetails() {
        return prescriptionDetails;
    }

    public void setPrescriptionDetails(List<PrescriptionDetail> prescriptionDetails) {
        this.prescriptionDetails = prescriptionDetails;
    }
    // endregion Getters and Setters
}
