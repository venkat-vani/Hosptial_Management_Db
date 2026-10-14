
package com.jpaandhibernate.example.hospital_management_db.controller;

import com.jpaandhibernate.example.hospital_management_db.model.Patient;
import com.jpaandhibernate.example.hospital_management_db.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/patient/apis")
public class PatientController {

    @Autowired
    PatientService patientService;

    // Save a patient
    @PostMapping("/save")
    public String savePatient(@RequestBody Patient patient) {
        return patientService.savePatient(patient);
    }

    // Find all patients
    @GetMapping("/findAll")
    public List<Patient> findAllPatients() {
        return patientService.findAllPatients();
    }

    // Find patient by ID
    @GetMapping("/findById/{id}")
    public Patient findPatientById(@PathVariable int id) {
        return patientService.findPatientById(id);
    }

    // Count total patients
    @GetMapping("/count")
    public String countPatients() {
        return patientService.countPatients();
    }

    // Delete patient by ID
    @DeleteMapping("/deleteById/{id}")
    public String deletePatientById(@PathVariable int id) {
        return patientService.deletePatientById(id);
    }

    // PUT: Update patient
    @PutMapping("/updateById/{patientId}")
    public String updatePatientUsingPut(
            @PathVariable int patientId,
            @RequestBody Patient patient) {
        return patientService.updatePatientUsingPut(patientId, patient);
    }

    // PATCH: Update patient email and mobile
    @PatchMapping("/updateById/{patientId}")
    public String updatePatientUsingPatch(
            @PathVariable int patientId,
            @RequestParam(required = false) String newEmail,
            @RequestParam(required = false) String newMobile) {
        return patientService.updatePatientUsingPatch(
                patientId, newEmail, newMobile);
    }
}
