package com.webservice.hethongchothuevesi.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "KhachHang")
public class KhachHang {
    @Id
    @Column(name = "idKhachHang")
    private Integer idKhachHang;

    @Column(name = "tenDangNhap")
    private String tenDangNhap;

    @Column(name = "anhDaiDien")
    private String anhDaiDien;

    @Column(name = "gioiTinh")
    private String gioiTinh;

    @Column(name = "ngaySinh")
    private LocalDate ngaySinh;

    @Column(name = "email")
    private String email;

    @Column(name = "soDienThoai")
    private String soDienThoai;

    @Column(name = "hoTen")
    private String hoTen;

    @Column(name = "soCCCD")
    private String soCccd;

    @Column(name = "diaChi")
    private String diaChi;

    @Column(name = "trangThai")
    private String trangThai;

    @Column(name = "trangThaiXoa")
    private Byte trangThaiXoa;
}
