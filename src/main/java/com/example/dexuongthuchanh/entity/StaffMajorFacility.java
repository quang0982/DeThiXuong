package com.example.dexuongthuchanh.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Entity
@Table(name = "staff_major_facility")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class StaffMajorFacility {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    UUID id;


    @Column(name = "id_major_facility")
    private UUID idMajorFacility;

    @Column(name = "id_staff")
    private UUID idStaff;


    public StaffMajorFacility(UUID idMajorFacility, UUID idStaff) {
        this.idMajorFacility=idMajorFacility;
        this.idStaff=idStaff;
    }
}
