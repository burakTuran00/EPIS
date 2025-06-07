package com.project.EPIS.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "stocks")
public class Stock {

    //region Properties
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @OneToOne
    @JoinColumn(name = "medication_id")
    private Medication medication;

    @Column(name = "quantity")
    private int quantity;

    @ManyToOne
    @JoinColumn(name = "pharmacy_id")
    private Pharmacy pharmacy;
    //endregion Properties

    //region Constructor
    public Stock() {
    }

    public Stock(int id, Medication medication, int quantity, Pharmacy pharmacy) {
        this.id = id;
        this.medication = medication;
        this.quantity = quantity;
        this.pharmacy = pharmacy;
    }
    //endregion Constructor

    //region Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Medication getMedication() {
        return medication;
    }

    public void setMedication(Medication medication) {
        this.medication = medication;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Pharmacy getPharmacy() {
        return pharmacy;
    }

    public void setPharmacy(Pharmacy pharmacy) {
        this.pharmacy = pharmacy;
    }
    //endregion Getters and Setters
}
