package com.example.dexuongthuchanh.Repository;

import com.example.dexuongthuchanh.entity.StaffMajorFacility;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface StaffMajorFacilityRepository extends JpaRepository<StaffMajorFacility, UUID> {
}
