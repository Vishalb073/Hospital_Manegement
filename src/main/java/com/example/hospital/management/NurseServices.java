package com.example.hospital.management;

import java.util.ArrayList;
import java.util.List;

public class NurseServices {

    NurseRepository nurseRepository = new NurseRepository();

    public String addNurse(Nurse nurse){


        nurseRepository.addNurse(nurse);

        return "Nurse Details Added Successfully";

    }

    public List<Nurse> getNurse(int age){

       List<Nurse> nurses =  nurseRepository.getNurse();

       List<Nurse> finalList = new ArrayList<>();

       for(Nurse nurse : nurses){

           if(nurse.getAge() > age){
               finalList.add(nurse);
           }
       }
       return finalList;
    }

    public List<Nurse> getNurseByQualification(String qualification){

        List<Nurse> nurses = nurseRepository.getNurse();

        List<Nurse> finalList = new ArrayList<>();

        for(Nurse nurse : nurses){
            if (nurse.getQualification().equals(qualification)) {
                finalList.add(nurse);
            }
        }
        return finalList;
    }
}
