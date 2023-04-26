package com.oop.patientmanagement.Model;

import java.util.ArrayList;
import java.util.Date;

public class Patient {
    private PatientInfo patient;
    private ArrayList<Disease> diseasesList = new ArrayList<>();
    private String date;

    public Patient(PatientInfo patient, ArrayList<Disease> diseasesList, String date) {
        this.patient = patient;
        this.diseasesList = diseasesList;
        this.date = date;
    }

    public PatientInfo getPatient() {
        return patient;
    }

    public void setPatient(PatientInfo patientInfor) {
        this.patient = patientInfor;
    }

    public ArrayList<Disease> getDiseasesList() {
        return diseasesList;
    }

    public void setDiseasesList(ArrayList<Disease> diseasesList) {
        this.diseasesList = diseasesList;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
