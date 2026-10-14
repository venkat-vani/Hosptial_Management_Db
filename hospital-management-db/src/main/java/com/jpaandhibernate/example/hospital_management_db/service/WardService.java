package com.jpaandhibernate.example.hospital_management_db.service;


import com.jpaandhibernate.example.hospital_management_db.model.Ward;
import com.jpaandhibernate.example.hospital_management_db.repository.WardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;


@Service
public class WardService {
    @Autowired
    WardRepository wardRepository;
    public String saveWard(Ward ward) {
        wardRepository.save(ward);
        return "Ward Saved Successfully";
    }
    // Find all wards
    public List<Ward> findAllWards() {
        return wardRepository.findAll();
    }
    // Find ward by ID
    public Ward findWardById(int id) {
        Optional<Ward> wardOptional = wardRepository.findById(id);

        if (wardOptional.isPresent()) {
            return wardOptional.get();
        } else {
            return null;
        }
    }
    // Count total wards
    public String countWards() {
        long totalCount = wardRepository.count();
        return "Total wards present are: " + totalCount;
    }

    // Delete ward by ID
    public String deleteWardById(int id) {
        Ward existingWard = findWardById(id);

        if (existingWard != null) {
            wardRepository.deleteById(id);
            return "Ward with id: " + id
                    + " got deleted successfully!";
        } else {
            return "Ward with id: " + id
                    + " is not present, hence cannot delete!";
        }
    }
    // PUT: Update the complete ward object
    public String updateWardUsingPut(int wardId, Ward newWardRequest) {

        Ward existingWard = findWardById(wardId);

        if (existingWard != null) {

            // Keep the ID from the URL
            existingWard.setWardId(wardId);

            existingWard.setWardName(newWardRequest.getWardName());
            existingWard.setWardType(newWardRequest.getWardType());
            existingWard.setFloorNumber(newWardRequest.getFloorNumber());
            existingWard.setTotalBeds(newWardRequest.getTotalBeds());
            existingWard.setOccupiedBeds(newWardRequest.getOccupiedBeds());
            existingWard.setWardStatus(newWardRequest.getWardStatus());

            wardRepository.save(existingWard);

            return "Ward with id: " + wardId
                    + " got updated successfully!";
        } else {
            return "Ward with id: " + wardId
                    + " is not present, hence cannot update!";
        }
    }

    // PATCH: Update selected ward fields
    public String updateWardUsingPatch(
            int wardId, String newWardStatus) {

        Ward existingWard = findWardById(wardId);

        if (existingWard != null) {

            existingWard.setWardStatus(newWardStatus);

            wardRepository.save(existingWard);

            return "Ward with id: " + wardId
                    + " got updated successfully!";
        } else {
            return "Ward with id: " + wardId
                    + " is not present, hence cannot update!";
        }
    }

}
