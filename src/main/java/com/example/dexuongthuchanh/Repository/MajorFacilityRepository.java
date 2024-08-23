package com.example.dexuongthuchanh.Repository;

import com.example.dexuongthuchanh.entity.MajorFacility;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface MajorFacilityRepository extends JpaRepository<MajorFacility, UUID> {
}
