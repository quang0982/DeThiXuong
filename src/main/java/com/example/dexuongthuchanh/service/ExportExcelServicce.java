package com.example.dexuongthuchanh.service;

import com.example.dexuongthuchanh.Repository.*;
import com.example.dexuongthuchanh.entity.Staff;
import com.example.dexuongthuchanh.reponse.StaffReponse;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.UUID;

@Service
public class ExportExcelServicce {
    @Autowired
    DepartmentRepository departmentRepository;
    @Autowired
    FacilityRepository facilityRepository;
    @Autowired
    MajorRepository majorRepository;
    @Autowired
    StaffRepository staffRepository;
    @Autowired
    DepartmentFacilityRepository departmentFacilityRepository;
    @Autowired
    MajorFacilityRepository majorFacilityRepository;
    @Autowired
    StaffMajorFacilityRepository staffMajorFacilityRepository;

    public void ExportExcel(HttpServletResponse reponse) throws IOException {

        List<Staff> list=staffRepository.findAll();
        HSSFWorkbook workbook=new HSSFWorkbook();
        HSSFSheet sheet=workbook.createSheet("Infomation Staff");
        HSSFRow row=sheet.createRow(0);
        sheet.setColumnWidth(0, 2000); // Cột 0 (STT)
        sheet.setColumnWidth(1, 3000); // Cột 1 (Mã nhân viên)
        sheet.setColumnWidth(2, 5000); // Cột 2 (Họ và tên)
        sheet.setColumnWidth(3, 10000); // Cột 3 (Email FPT)
        sheet.setColumnWidth(4, 10000); // Cột 4 (Email FE)
        sheet.setColumnWidth(5, 15000);// Cột 5 (Bộ môn-chuyên ngành)
        row.createCell(0).setCellValue("STT");
        row.createCell(1).setCellValue("Mã nhân viên");
        row.createCell(2).setCellValue("Họ và tên");
        row.createCell(3).setCellValue("Email FPT");
        row.createCell(4).setCellValue("Email FE");
        row.createCell(5).setCellValue("Bộ môn-chuyên ngành");

        int dataRowindex=1;
        for (Staff staff:list){
            HSSFRow dataRow = sheet.createRow(dataRowindex);
            dataRow.createCell(0).setCellValue(dataRowindex);
            dataRow.createCell(1).setCellValue(staff.getStaffCode());
            dataRow.createCell(2).setCellValue(staff.getName());
            dataRow.createCell(3).setCellValue(staff.getEmailFpt());
            dataRow.createCell(4).setCellValue(staff.getEmailFe());
            List<StaffReponse> listSaffExists=staffRepository.listSaffExists(staff.getId());
            String bomon="";
            String chuyennganh="";
            String coso="";
            String bomonchuyennganh="";
            for (int i=0;i<listSaffExists.size();i++){
                bomon=listSaffExists.get(i).getdepartmentName();
                chuyennganh=listSaffExists.get(i).getmajorName();
                coso=listSaffExists.get(i).getfacilityName();
                bomonchuyennganh+=bomon+"-"+chuyennganh+"-"+coso;
                if(i<listSaffExists.size()-1){
                    bomonchuyennganh+=",";
                }
            }
            dataRow.createCell(5).setCellValue(bomonchuyennganh);
            dataRowindex++;
        }
        ServletOutputStream ops=reponse.getOutputStream();
        workbook.write(ops);
        workbook.close();
        ops.close();
    }
}
