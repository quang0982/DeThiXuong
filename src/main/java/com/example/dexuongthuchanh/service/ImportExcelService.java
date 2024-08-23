package com.example.dexuongthuchanh.service;

import com.example.dexuongthuchanh.Repository.StaffRepository;
import com.example.dexuongthuchanh.entity.DepartmentFacility;
import com.example.dexuongthuchanh.entity.MajorFacility;
import com.example.dexuongthuchanh.entity.Staff;
import com.example.dexuongthuchanh.entity.StaffMajorFacility;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.util.*;

@Service
public class ImportExcelService {
    @Autowired
    StaffRepository  staffRepository;
    public  boolean isValidExcelFile(MultipartFile file){
     return Objects.equals(file.getContentType(),"application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
    }
    public List<Staff> Read(InputStream inputStream) {
        List<Staff> staffs = new ArrayList<>();
//        List<StaffMajorFacility> staffMajorFacilities = new ArrayList<>();
//        List<DepartmentFacility> departmentFacilities=new ArrayList<>();
//        List<MajorFacility> majorFacilities=new ArrayList<>();
        try {
            HSSFWorkbook workbook = new HSSFWorkbook(inputStream);
            HSSFSheet sheet = workbook.getSheet("Infomation Staff");
            int rowIndex = 0;
            for (Row row : sheet) {
                if (rowIndex == 0) {
                    rowIndex++;
                    continue;
                }
                Iterator<Cell> cellIterator = row.iterator();
                int cellIndex = 0;
                String staffcode="";
                String name="";
                String emailFpt="";
                String emailFe="";
                while (cellIterator.hasNext()) {
                    Cell cell = cellIterator.next();
                    switch (cellIndex) {
                        case 1 -> staffcode=cell.getStringCellValue();
                        case 2 -> name=cell.getStringCellValue();
                        case 3 -> emailFpt=cell.getStringCellValue();
                        case 4 -> emailFe=cell.getStringCellValue();
                        default -> {
                        }
                    }
                    cellIndex++;
                }
                staffs.add(new Staff(staffcode,name,emailFpt,emailFe));
            }
        } catch (IOException e) {
            e.getStackTrace();
        }
        return staffs;
    }
    public void saveStaffsToDatabase(MultipartFile file){
        if(isValidExcelFile(file)){
            try {
                List<Staff> staff = Read(file.getInputStream());
                this.staffRepository.saveAll(staff);
            } catch (IOException e) {
                throw new IllegalArgumentException("The file is not a valid excel file");
            }
        }
    }
}
