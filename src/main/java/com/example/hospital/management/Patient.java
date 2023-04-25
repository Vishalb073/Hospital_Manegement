package com.example.hospital.management;

public class Patient {

    private int patientID;

    private String name;

    private String mobNo;

    private int age;

    public Patient(int patienID, String name, String mobNo, int age) {
        this.patientID = patienID;
        this.name = name;
        this.mobNo = mobNo;
        this.age = age;
    }

    public int getPatientID() {
        return patientID;
    }

    public void setPatienID(int patienID) {
        this.patientID = patienID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMobNo() {
        return mobNo;
    }

    public void setMobNo(String mobNo) {
        this.mobNo = mobNo;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
