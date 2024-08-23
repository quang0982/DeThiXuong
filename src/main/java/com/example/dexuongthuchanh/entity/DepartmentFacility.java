package com.example.dexuongthuchanh.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Entity
@Table(name = "department_facility")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DepartmentFacility {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    @Column(name = "id_facility")
     UUID idFacility;
    @Column(name = "id_department")
     UUID idDepartment;

    public DepartmentFacility(UUID facilityId, UUID departmentId) {
        this.idFacility=facilityId;
        this.idDepartment=departmentId;
    }
}
