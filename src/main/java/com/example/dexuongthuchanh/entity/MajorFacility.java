package com.example.dexuongthuchanh.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Entity
@Table(name = "major_facility")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MajorFacility {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    UUID id;
    @Column(name = "id_department_facility")
    private UUID idDepartmentFacility;

    @Column(name = "id_major")
    private UUID idMajor;


    public MajorFacility(UUID idDepartmentFacility, UUID majorId) {
        this.idDepartmentFacility=idDepartmentFacility;
        this.idMajor=majorId;
    }
}
