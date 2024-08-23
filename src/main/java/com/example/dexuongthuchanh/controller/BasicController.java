package com.example.dexuongthuchanh.controller;

import com.example.dexuongthuchanh.Repository.*;
import com.example.dexuongthuchanh.entity.*;
import com.example.dexuongthuchanh.reponse.StaffIDReponse;
import com.example.dexuongthuchanh.reponse.StaffReponse;
import com.example.dexuongthuchanh.service.ExportExcelServicce;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Controller
public class BasicController {
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
    @Autowired
    ExportExcelServicce exportExcelServicce;

    public List<Major> listMajor() {
        return majorRepository.findAll();
    }

    Integer nbpage = 0;
    UUID idStaff;
    @GetMapping("index")
    public String getStaff(Model model) {
        model.addAttribute("page", staffRepository.findAll());
        return "index";
    }

    //Thêm nhân viên
    @GetMapping("addStaft")
    public String viewAddStaff(Model model) {
        model.addAttribute("Staff", new Staff());
        return "form";
    }

    @PostMapping("addStaft")
    public String addStaff(
            @Valid
            @ModelAttribute("Staff") Staff staff,
            BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "form";
        } else {
            if (staffRepository.isDuplicateStaffCode(staff.getStaffCode())) {
                model.addAttribute("errorMa", "Mã nhân viên đã trùng");
                return "form";
            } else if (staffRepository.isDuplicateEmailFpt(staff.getEmailFpt())) {
                model.addAttribute("errorMailFPT", "Email FPT đã trùng");
                return "form";
            } else if (staffRepository.isDuplicateEmailFe(staff.getEmailFe())) {
                model.addAttribute("errorMailFE", "Email FE đã trùng");
                return "form";
            } else {
                staffRepository.save(staff);
                return "redirect:/index";
            }
        }
    }

    //Sửa nhân viên
    @GetMapping("/updateStaff/{id}")
    public String viewUpdateStaff(Model model, @PathVariable UUID id) {
        model.addAttribute("Staff", staffRepository.findById(id));
        return "form";
    }

    @PostMapping("/updateStaff/{id}")
    public String updateStaff(
            @Valid
            @ModelAttribute("Staff") Staff staff,
            BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "form";
        } else {
            staffRepository.save(staff);
            return "redirect:/index";
        }
    }
    //Hiển thị thông tin nhân viên
    @GetMapping("/detailStaff/{id}")
    public String detailStaff(Model model, @PathVariable UUID id) {
        List<StaffReponse> ListSaffDontExists = staffRepository.listSaffDontExists(id);
        List<Facility> ListFacilityDontExists=new ArrayList<>();
        List<Major> ListMajorDontExists=new ArrayList<>();
        List<Department> ListDepartmentDontExists=new ArrayList<>();
        for (StaffReponse staffReponse : ListSaffDontExists) {
        ListFacilityDontExists.add(new Facility(staffReponse.getfacilityId(),staffReponse.getdepartmentName()));
        ListMajorDontExists.add(new Major(staffReponse.getmajorId(),staffReponse.getmajorName()));
        ListDepartmentDontExists.add(new Department(staffReponse.getdepartmentId(),staffReponse.getdepartmentName()));
        }
        model.addAttribute("Facility",ListFacilityDontExists);
        model.addAttribute("Major",ListMajorDontExists);
        model.addAttribute("Department",ListDepartmentDontExists);
        model.addAttribute("Staff", staffRepository.findById(id));
        model.addAttribute("staffResponse", staffRepository.listSaffExists(id));
        idStaff=id;
        return "detail";
    }

    @PostMapping("saveStaffMojor/{id}")
    public String saveMojor(@PathVariable("id") UUID id,
                            @ModelAttribute("StaffIDReponse")StaffIDReponse idFull, Model model) {
        try {
            UUID idDepartmentFacility=departmentFacilityRepository.save(new DepartmentFacility(
                    idFull.facilityId,idFull.departmentId
            )).getId();
            UUID idMajorFacility=majorFacilityRepository.save(new MajorFacility(
                    idDepartmentFacility,idFull.majorId
            )).getId();
            staffMajorFacilityRepository.save(new StaffMajorFacility(
                    idMajorFacility,id
            ));
        }catch (Exception e){
            e.printStackTrace();
        }
        idStaff=id;
        return "redirect:/detailStaff/"+id;
    }
    @GetMapping("delete/{id}")
    public String delete(@PathVariable("id") UUID staffmajorFacilityId){
         staffMajorFacilityRepository.deleteById(staffmajorFacilityId);
        return "redirect:/detailStaff/"+idStaff;
    }
    @GetMapping("excel")
    public void generateExcelExport(HttpServletResponse response)throws Exception{
        response.setContentType("application/octet-stream");
        String headerKey="Content-Disposition";
        String headerValue="attachment;filename=template.xls";
        response.setHeader(headerKey,headerValue);
        exportExcelServicce.ExportExcel(response);
    }
}
