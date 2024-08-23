package com.example.dexuongthuchanh.Repository;

import com.example.dexuongthuchanh.entity.DepartmentFacility;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface DepartmentFacilityRepository extends JpaRepository<DepartmentFacility, UUID> {
}
