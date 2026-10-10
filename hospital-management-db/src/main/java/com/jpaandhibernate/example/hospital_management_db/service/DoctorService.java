package com.jpaandhibernate.example.hospital_management_db.service;
import java.util.*;


import com.jpaandhibernate.example.hospital_management_db.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.jpaandhibernate.example.hospital_management_db.model.Doctor;
import com.jpaandhibernate.example.hospital_management_db.repository.DoctorRepository;

import javax.print.Doc;

@Service //it contains the business logic//
public class DoctorService {
@Autowired
    DoctorRepository doctorRepository;

    public String saveDoctor(Doctor doctor){
        doctorRepository.save(doctor);//if u  dont implemented the method wil give error
        return "Doctor Saved Successfully";
    }
    public List<Doctor> findAllDoctors() {
        return doctorRepository.findAll();
    }
    public Doctor findDoctorById(int id){
        Optional<Doctor> doctorOptional = doctorRepository.findById(id);
        if(doctorOptional.isPresent()){
            return doctorOptional.get();
        }
        else{
            return null;
        }
        }
        public String countDoctors(){
        long totalCount = doctorRepository.count();
        return "Total doctors present are: " +totalCount;
        }
        public String deleteDoctorById(int id){
        Doctor existingDoctor = findDoctorById(id);
        if(existingDoctor!= null){
            doctorRepository.deleteById(id);
            return "Doctor with id: "+id+ " got deleted successfully!";
        }
        else{
            return "Doctor with id: "+id+ " is not present, hence cannot delete!";

        }
        }


}
