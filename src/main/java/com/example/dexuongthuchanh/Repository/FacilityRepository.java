package com.example.dexuongthuchanh.Repository;

import com.example.dexuongthuchanh.entity.Facility;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface FacilityRepository extends JpaRepository<Facility, UUID> {
}
