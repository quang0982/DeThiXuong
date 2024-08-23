package com.example.dexuongthuchanh.Repository;

import com.example.dexuongthuchanh.entity.Staff;
import com.example.dexuongthuchanh.reponse.StaffReponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface StaffRepository extends JpaRepository<Staff, UUID> {
    default boolean isDuplicateStaffCode(String staffCode) {
        return findAll().stream().anyMatch(staff -> staff.getStaffCode().equals(staffCode));
    }

    default boolean isDuplicateEmailFpt(String email) {
        return findAll().stream().anyMatch(staff -> staff.getEmailFpt().equals(email));
    }

    default boolean isDuplicateEmailFe(String email) {
        return findAll().stream().anyMatch(staff -> staff.getEmailFe().equals(email));
    }

    @Query(value = """
            select s.id as id,
                                       s.name as name,
                                              m.id as majorId,
                                              m.name as majorName,
                                       	   f.id as facilityId,
                                       	   f.name as facilityName,
                                       	   d.id as departmentId,
                                       	   d.name as departmentName,
                                       	   df.id as departmentFacilityId,
                                       	   mf.id as majorFacilityId,
                                       	   smf.id as staffmajorFacilityId
                                       from
                                       staff s join staff_major_facility smf on s.id=smf.id_staff
                                       join major_facility mf on mf.id=smf.id_major_facility
                                       join major m on m.id=mf.id_major
                                       join department_facility df on df.id=mf.id_department_facility
                                       join facility f on f.id=df.id_facility
                                       join department d on d.id=df.id_department
                                       where s.id =:id
            """, nativeQuery = true)
    List<StaffReponse> listSaffExists(@Param("id") UUID id);


    @Query(value = """
            SELECT
                            m.id AS majorId,
                            m.name AS majorName,
                            f.id AS facilityId,
                            f.name AS facilityName,
                            d.id AS departmentId,
                            d.name AS departmentName,
                            df.id as departmentFacilityId,
                        	mf.id as majorFacilityId,
                        	smf.id as staffmajorFacilityId
                        FROM
                       staff s join staff_major_facility smf on s.id=smf.id_staff
                                                   join major_facility mf on mf.id=smf.id_major_facility
                                                   join major m on m.id=mf.id_major
                                                   join department_facility df on df.id=mf.id_department_facility
                                                   join facility f on f.id=df.id_facility
                                                   join department d on d.id=df.id_department
                        WHERE
                            NOT EXISTS (
                                SELECT 1
                                FROM staff_major_facility smf
                                WHERE smf.id_staff =:id
                                AND smf.id_major_facility = mf.id
                            );
            """, nativeQuery = true)
    List<StaffReponse> listSaffDontExists(@Param("id") UUID id);
}
