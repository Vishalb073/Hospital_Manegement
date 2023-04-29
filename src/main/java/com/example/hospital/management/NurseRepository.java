package com.example.hospital.management;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class NurseRepository {

    HashMap<Integer, Nurse> NurseHash = new HashMap<>();

    public String addNurse(Nurse nurse){

        int key = nurse.getNurseID();

        NurseHash.put(key, nurse);

        return "Nurse Details added successfully";
    }

    public List<Nurse> getNurse(){

       return NurseHash.values().stream().toList();
    }


}
