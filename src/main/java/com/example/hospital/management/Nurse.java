package com.example.hospital.management;

public class Nurse {

    private int nurseID;
    // adding nurse

    private String name;

    private String qualification;

    private int age;

    public Nurse(int nurseID, String name, String qualification, int age) {
        this.nurseID = nurseID;
        this.name = name;
        this.qualification = qualification;
        this.age = age;
    }

    public int getNurseID() {
        return nurseID;
    }

    public void setNurseID(int nurseID) {
        this.nurseID = nurseID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getQualification() {
        return qualification;
    }

    public void setQualification(String qualification) {
        this.qualification = qualification;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
