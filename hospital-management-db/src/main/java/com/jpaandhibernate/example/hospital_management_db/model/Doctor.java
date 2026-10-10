package com.jpaandhibernate.example.hospital_management_db.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity  //it represent that this class is entity or model class that create directly in the database//
@Table(name="Doctor")  // it will create a table inside database with name given
@Data //adds getters and setters
@AllArgsConstructor //parameterized constructor
@NoArgsConstructor // default constructor
public class Doctor{

    @Id // It is the primary key of the table - It will be unique adnd it is not null
    @Column(name="id")
    private int id;
    @Column(name = "doctar_name",nullable = false)
    private String name;
    @Column(name = "email",nullable = false,unique = true)
    private String email;
    @Column(name = "specification",nullable = false)
    private  String specification;
    @Column(name = "dob",nullable = false)
    private String dob;

}
