package com.jpaandhibernate.example.hospital_management_db.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Patient")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Patient {
    @Id // It is the primary key of the table - It will be unique adnd it is not null
    @Column(name="id")
    private int id;
    @Column(name = "Patient_name",nullable = false)
    private String name;
    @Column(name = "email",nullable = false,unique = true)
    private String email;
    @Column(name = "disease",nullable = false)
    private  String disease;
    @Column(name = "dob",nullable = false)
    private String dob;

    @Column(name = "mobile")
    private String mobile;

}
