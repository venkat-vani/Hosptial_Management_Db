
package com.jpaandhibernate.example.hospital_management_db.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "ward")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Ward {

    @Id
    @Column(name = "ward_id")
    private int wardId;

    @Column(name = "ward_name", nullable = false)
    private String wardName;

    @Column(name = "ward_type", nullable = false)
    private String wardType;

    @Column(name = "floor_number", nullable = false)
    private int floorNumber;

    @Column(name = "total_beds", nullable = false)
    private int totalBeds;

    @Column(name = "occupied_beds", nullable = false)
    private int occupiedBeds;

    @Column(name = "ward_status", nullable = false)
    private String wardStatus;
}
