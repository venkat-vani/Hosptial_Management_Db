
package com.jpaandhibernate.example.hospital_management_db.service;

import com.jpaandhibernate.example.hospital_management_db.model.Patient;
import com.jpaandhibernate.example.hospital_management_db.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PatientService {

    @Autowired
    PatientRepository patientRepository;

    // Save a patient
    public String savePatient(Patient patient) {
        patientRepository.save(patient);
        return "Patient Saved Successfully";
    }

    // Find all patients
    public List<Patient> findAllPatients() {
        return patientRepository.findAll();
    }

    // Find patient by ID
    public Patient findPatientById(int id) {
        Optional<Patient> patientOptional =
                patientRepository.findById(id);

        if (patientOptional.isPresent()) {
            return patientOptional.get();
        } else {
            return null;
        }
    }

    // Count total patients
    public String countPatients() {
        long totalCount = patientRepository.count();
        return "Total patients present are: " + totalCount;
    }

    // Delete patient by ID
    public String deletePatientById(int id) {
        Patient existingPatient = findPatientById(id);

        if (existingPatient != null) {
            patientRepository.deleteById(id);
            return "Patient with id: " + id
                    + " got deleted successfully!";
        } else {
            return "Patient with id: " + id
                    + " is not present, hence cannot delete!";
        }
    }

    // PUT: Update the complete patient object
    public String updatePatientUsingPut(
            int patientId, Patient newPatientRequest) {

        Patient existingPatient = findPatientById(patientId);

        if (existingPatient != null) {

            // Update the existing patient
            // Keep the ID from the URL
            existingPatient.setId(patientId);

            existingPatient.setEmail(newPatientRequest.getEmail());
            existingPatient.setMobile(newPatientRequest.getMobile());

            patientRepository.save(existingPatient);

            return "Patient with id: " + patientId
                    + " got updated successfully!";

        } else {
            return "Patient with id: " + patientId
                    + " is not present, hence cannot update!";
        }
    }

    // PATCH: Update specific patient fields
    public String updatePatientUsingPatch(
            int patientId, String newEmail, String newMobile) {

        Patient existingPatient = findPatientById(patientId);

        if (existingPatient != null) {

            // Update only the fields provided
            if (newEmail != null && !newEmail.isBlank()) {
                existingPatient.setEmail(newEmail);
            }

            if (newMobile != null && !newMobile.isBlank()) {
                existingPatient.setMobile(newMobile);
            }

            patientRepository.save(existingPatient);

            return "Patient with id: " + patientId
                    + " got updated successfully!";

        } else {
            return "Patient with id: " + patientId
                    + " is not present, hence cannot update!";
        }
    }
}
