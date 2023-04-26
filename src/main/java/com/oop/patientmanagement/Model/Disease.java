package com.oop.patientmanagement.Model;

public class Disease {
    private String diseaseName;
    private String description;
    private String medicine;

    public Disease(String diseaseName, String description, String medicine) {
        this.diseaseName = diseaseName;
        this.description = description;
        this.medicine = medicine;
    }

    public String getDiseaseName() {
        return diseaseName;
    }

    public void setDiseaseName(String diseaseName) {
        this.diseaseName = diseaseName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getMedicine() {
        return medicine;
    }

    public void setMedicine(String medicine) {
        this.medicine = medicine;
    }
}
