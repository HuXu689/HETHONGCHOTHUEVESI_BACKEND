package com.webservice.hethongchothuevesi.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name = "NguoiDung")
public class NguoiDung {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idNguoiDung")
    Integer idNguoiDung;

    @Size(min = 6, message = "TENDANGNHAP_INVALID")
    @Column(name = "tenDangNhap", nullable = false)
    String tenDangNhap;

    @Size(min = 8, message = "MATKHAU_INVALID")
    @Column(name = "matKhau", nullable = false)
    String matKhau;

    @Column(name = "anhDaiDien")
    String anhDaiDien;

    @Column(name = "hoTen")
    String hoTen;

    @Column(name = "gioiTinh")
    String gioiTinh;

    @Column(name = "ngaySinh")
    LocalDate ngaySinh;

    @Column(name = "email")
    String email;

    @Column(name = "soDienThoai")
    String soDienThoai;

    @Column(name = "soCCCD")
    String soCccd;

    @Column(name = "diaChi")
    String diaChi;

    @Column(name = "trangThai")
    String trangThai;

    @Column(name = "ngayXoa")
    LocalDateTime ngayXoa;

    @Column(name = "role")
    String role;
}
