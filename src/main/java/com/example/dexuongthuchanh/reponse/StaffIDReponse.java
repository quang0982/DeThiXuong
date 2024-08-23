package com.example.dexuongthuchanh.reponse;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.UUID;
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class StaffIDReponse {
    @Id
    public UUID id;
    public String name;

    public UUID majorId;

    public String majorName;

    public UUID facilityId;

    public String facilityName;

    public UUID departmentId;

    public String departmentName;

}
