package com.example.hospital.management;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Nurse")
public class NurseController {

    NurseServices nurseServices = new NurseServices();

    @PostMapping("/add")
    public String addNurse(@RequestBody Nurse nurse){

        nurseServices.addNurse(nurse);

        return "Nurse details added successfully";

    }

    @GetMapping("/getNurseByAge")
    public List<Nurse> getNurseViaAge(@RequestParam("age")Integer age){

        List<Nurse> list = nurseServices.getNurse(age);

        return list;

    }

    @GetMapping("/getByQualification")
    public List<Nurse> getByQualification(@RequestParam("qualification")String qualification){

        List<Nurse> list = nurseServices.getNurseByQualification(qualification);

        return list;

    }

}
