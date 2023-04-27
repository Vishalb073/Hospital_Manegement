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

    @GetMapping("/getInfoViaPathVariable/{patientID}")
    public Patient getPatientInfo(@PathVariable("patientID")Integer patientID){
        Patient patient = hashMap.get(patientID);
        return patient;
    }

    @GetMapping("/getInfoViaPath/{age}/{name}")
    public List<Patient> getPatientInfos(@PathVariable("age")Integer age, @PathVariable("name")String name){

        List<Patient> patients = new ArrayList<>();

        for(Patient p : hashMap.values()){
            if(p.getAge() > age && p.getName().equals(name)){
                patients.add(p);
            }
        }

        return patients;
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

    @PutMapping("/updatePatientName")
    public String update(@RequestParam("patientID")Integer patientID, @RequestParam("name")String name){

        if(hashMap.containsKey(patientID)){

            Patient patient = hashMap.get(patientID);

            patient.setName(name);

            return "Patient name updated";
        }
        return "patient details not found";
    }



    @PutMapping("/updatePatient")
    public String updatePatientName(@RequestBody Patient patient){

        int key = patient.getPatientID();

        if(hashMap.containsKey(key)){

            hashMap.put(key, patient);

            return "Patient name has been updated successfully";
        }
        return "patient details not found!";
    }

    @DeleteMapping("/deletePatient")
    public String deletePatient(@RequestParam("patientID")Integer patientID){

        hashMap.remove(patientID);

        return "Patient deleted Successfully";
    }




}
