package com.example.dexuongthuchanh.reponse;

import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface StaffReponse {
    public UUID getid();
    public String getname();
    public UUID getmajorId();
    public String getmajorName();
    public UUID getfacilityId();
    public String getfacilityName();
    public UUID getdepartmentId();
    public String getdepartmentName();
    public UUID getdepartmentFacilityId();
    public UUID getstaffmajorFacilityId();
    public UUID getmajorFacilityId();
}
