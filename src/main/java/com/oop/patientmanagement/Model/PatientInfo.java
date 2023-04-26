package com.oop.patientmanagement.Model;

public class PatientInfo {
    private String name;
    private int age;
    private String citizenID;
    private String gender;

    public PatientInfo(String name, int age, String citizenID, String gender) {
        this.name = name;
        this.age = age;
        this.citizenID = citizenID;
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getCitizenID() {
        return citizenID;
    }

    public void setCitizenID(String citizenID) {
        this.citizenID = citizenID;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
