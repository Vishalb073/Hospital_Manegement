package com.example.hospital.management;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@RestController
public class PatientController {

    HashMap<Integer, Patient> hashMap = new HashMap<>();

    @PostMapping("/addPatient")
    public String addPatientInfo(@RequestParam("patientID")Integer patientID, @RequestParam("name")String name,
                               @RequestParam("mobNo")String mobNo, @RequestParam("age")Integer age){

        Patient newPatient = new Patient(patientID, name, mobNo, age);

        hashMap.put(patientID, newPatient);

        return "Patient added successfully";


    }

    @PostMapping("/addPatientViaRequestBody")
    public String addPatientInfo(@RequestBody Patient patient){
        int key = patient.getPatientID();

        hashMap.put(key, patient);

        return "Patient added via request body";
    }

    @GetMapping("/getPatientInfo")
    public Patient getPatientI(@RequestParam("patientID")Integer patientid){

        Patient ptint = hashMap.get(patientid);
        return ptint;
    }

    @GetMapping("/getAllPatients")
    public List<Patient> getAll(){
        List<Patient> list = new ArrayList<>();

        for(Patient p : hashMap.values()){
            list.add(p);
        }

        return list;
    }


    // get patient info by name

    @GetMapping("/getPatientInfoByName")
    public Patient getPatientByName(@RequestParam("name")String name1){

        for(Patient p : hashMap.values()){
            if(p.getName().equals(name1)){
                return p;
            }
        }

        return null;
    }




}
