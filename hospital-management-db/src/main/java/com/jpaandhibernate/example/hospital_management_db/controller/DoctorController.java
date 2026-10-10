package com.jpaandhibernate.example.hospital_management_db.controller;
import com.jpaandhibernate.example.hospital_management_db.model.Doctor;
import com.jpaandhibernate.example.hospital_management_db.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


//request -> API(Controller) -> service -> repository -> service(response) -> API(response) -> user
//Spring boot application - take the input in the form of JSON
//debugging taking the flow of the application (understand the line by line what is happenning and all )
//@Requestbody it is take the input from the UI or postman and it is only used for only co

@RestController
@RequestMapping("/doctor/apis")
public class DoctorController {
    @Autowired
    DoctorService doctorService;
    @PostMapping("/Save")
    public String addDoctor(@RequestBody Doctor doctor){ //if you take the whole object from the clas you can use the request body//
        String response = doctorService.saveDoctor(doctor);
        return response;
    }
    @GetMapping("/findAll")
    public List<Doctor> findAllDoctors() {
        return doctorService.findAllDoctors();
    }
        @GetMapping("/findById/{id}")
                public Doctor findDoctorById(@PathVariable int id){
            Doctor doctor = doctorService.findDoctorById(id);
            return doctor;

        }
        @GetMapping("/count")
        public String countDoctors(){
        String response = doctorService.countDoctors();
        return response;
        }
        @DeleteMapping ("/deleteById/{id}")
        public String deleteDoctorById(@PathVariable int id){
        String response = doctorService.deleteDoctorById(id);
        return response;
        }

}
