package com.example.hospital.management;

import org.springframework.web.bind.annotation.*;

import javax.print.Doc;
import java.util.HashMap;

@RestController
public class DoctorController {

    HashMap<Integer, Doctor> doctorDB = new HashMap<>();

    @PostMapping("/addDoctor")
    public String addDoctor(@RequestBody Doctor doctor){

        int doctorid = doctor.getDoctorID();

        doctorDB.put(doctorid, doctor);

        return "Doctor details added successfully!";
    }

    @GetMapping("/getDoctor")
    public Doctor getDoctor(@RequestParam("doctorID")Integer doctorID){

        Doctor db = doctorDB.get(doctorID);

        return db;
    }

    @PutMapping("/update")
    public String updateDoctorName(@RequestParam("doctorID")Integer patientID, @RequestParam("name")String name){

        if(doctorDB.containsKey(patientID)){

            Doctor db = doctorDB.get(patientID);

            db.setName(name);

            return "Doctor name has been set";

        }

        return "Doctor does not exist";
    }
}
