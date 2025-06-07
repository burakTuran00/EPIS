package com.project.EPIS.entity;

import jakarta.persistence.*;

import java.util.List;


@Entity
@Table(name = "medication_groups")
public class MedicationGroup {
    //region Properties
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @OneToMany(mappedBy = "medicationGroup")
    private List<Medication> medications;
    // endregion Properties

    // region Constructor
    public MedicationGroup() {
    }

    public MedicationGroup(int id, String name, String description, List<Medication> medications) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.medications = medications;
    }
    // endregion Constructor

    // region Getters and Setters
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Medication> getMedications() {
        return medications;
    }

    public void setMedications(List<Medication> medications) {
        this.medications = medications;
    }
    // endregion Getters and Setters
}
