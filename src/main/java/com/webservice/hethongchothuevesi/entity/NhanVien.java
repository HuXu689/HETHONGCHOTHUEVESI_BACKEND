package com.webservice.hethongchothuevesi.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "NhanVien")
public class NhanVien {
    @Id
    @Column(name = "idNhanVien")
    private Integer idNhanVien;

    @Column(name = "idVaiTro")
    private Integer idVaiTro;

    @Column(name = "tenDangNhap")
    private String tenDangNhap;

    @Column(name = "matKhau")
    private String matKhau;

    @Column(name = "anhDaiDien")
    private String anhDaiDien;

    @Column(name = "hoTen")
    private String hoTen;

    @Column(name = "gioiTinh")
    private String gioiTinh;

    @Column(name = "ngaySinh")
    private LocalDate ngaySinh;

    @Column(name = "email")
    private String email;

    @Column(name = "diaChi")
    private String diaChi;

    @Column(name = "soDienThoai")
    private String soDienThoai;

    @Column(name = "ngayBatDauLam")
    private LocalDate ngayBatDauLam;

    @Column(name = "capBac")
    private String capBac;

    @Column(name = "ngayLenCap")
    private LocalDate ngayLenCap;

    @Column(name = "luong")
    private BigDecimal luong;

    @Column(name = "trangThai")
    private String trangThai;

    @Column(name = "trangThaiXoa")
    private Byte trangThaiXoa;
}
