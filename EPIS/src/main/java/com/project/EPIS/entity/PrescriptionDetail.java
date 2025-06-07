package com.project.EPIS.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

@Entity
@Table(name = "prescription_details")
public class PrescriptionDetail {

    //region Properties
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @ManyToOne
    @JoinColumn(name = "prescription_id")
    @JsonBackReference
    private Prescription prescription;

    @OneToOne
    @JoinColumn(name = "medication_id")
    @JsonBackReference
    private Medication medication;
    //endregion Properties

    // region Constructor
    public PrescriptionDetail() {
    }

    public PrescriptionDetail(int id, Prescription prescription, Medication medication) {
        this.id = id;
        this.prescription = prescription;
        this.medication = medication;
    }
    // endregion Constructor

    // region Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Prescription getPrescription() {
        return prescription;
    }

    public void setPrescription(Prescription prescription) {
        this.prescription = prescription;
    }

    public Medication getMedication() {
        return medication;
    }

    public void setMedication(Medication medication) {
        this.medication = medication;
    }
    // endregion Getters and Setters
}
