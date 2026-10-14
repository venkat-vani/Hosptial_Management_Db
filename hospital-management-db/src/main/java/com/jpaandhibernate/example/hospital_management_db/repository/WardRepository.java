package com.jpaandhibernate.example.hospital_management_db.repository;
import com.jpaandhibernate.example.hospital_management_db.model.Doctor;
import com.jpaandhibernate.example.hospital_management_db.model.Ward;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository //its optional not mandatory , this performs the database operation and it is the data layer//
public interface WardRepository extends JpaRepository<Ward,Integer> {


}

