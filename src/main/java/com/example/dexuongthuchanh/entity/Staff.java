package com.example.dexuongthuchanh.entity;


import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "staff")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Staff {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @NotNull(message = "Mã nhân viên không được để trống")
    @NotBlank(message = "Mã nhân viên không được để trống")
    @Size(max = 15, message = "Mã nhân viên phải nhỏ hơn 15 ký tự")
    @Column(name = "staff_code")
    private String staffCode;
    @NotNull(message = "Tên nhân viên không được để trống")
    @NotBlank(message = "Tên nhân viên không được để trống")
    @Column(name = "name ")
    private String name;
    @NotNull(message = "Email FPT không được để trống")
    @NotBlank(message = "Email FPT không được để trống")
    @Size(max = 100, message = "Email phải nhỏ hơn 100 ký tự")
    @Email(message = "Email không hợp lệ")
    @Pattern(regexp = "^[a-zA-Z0-9._%+-]+@fpt.edu.vn$", message = "Email FPT phải kết thúc với @fpt.edu.vn")
    @Column(name = "account_fpt")
    private String emailFpt;

    @NotNull(message = "Email FE không được để trống")
    @NotBlank(message = "Email FE không được để trống")
    @Size(max = 100, message = "Email phải nhỏ hơn 100 ký tự")
    @Email(message = "Email không hợp lệ")
    @Pattern(regexp = "^[a-zA-Z0-9._%+-]+@fe.edu.vn$", message = "Email FE phải kết thúc với @fe.edu.vn")
    @Column(name = "account_fe")
    private String emailFe;

    @Column(name = "status")
    private Boolean status;

}
