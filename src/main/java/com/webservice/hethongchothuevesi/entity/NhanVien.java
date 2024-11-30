package com.webservice.hethongchothuevesi.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "NhanVien")
public class NhanVien {
    @Id
    @Column(name = "idNhanVien")
    private Integer idNhanVien;

    @Column(name = "idNguoiDung")
    private Integer idNguoiDung;

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

    @Column(name = "ngayXoa")
    private LocalDateTime ngayXoa;

    public Integer getIdNhanVien() {
        return this.idNhanVien;
    }

    public void setIdNhanVien(Integer idNhanVien) {
        this.idNhanVien = idNhanVien;
    }

    public Integer getIdNguoiDung() {
        return this.idNguoiDung;
    }

    public void setIdNguoiDung(Integer idNguoiDung) {
        this.idNguoiDung = idNguoiDung;
    }

    public LocalDate getNgayBatDauLam() {
        return this.ngayBatDauLam;
    }

    public void setNgayBatDauLam(LocalDate ngayBatDauLam) {
        this.ngayBatDauLam = ngayBatDauLam;
    }

    public String getCapBac() {
        return this.capBac;
    }

    public void setCapBac(String capBac) {
        this.capBac = capBac;
    }

    public LocalDate getNgayLenCap() {
        return this.ngayLenCap;
    }

    public void setNgayLenCap(LocalDate ngayLenCap) {
        this.ngayLenCap = ngayLenCap;
    }

    public BigDecimal getLuong() {
        return this.luong;
    }

    public void setLuong(BigDecimal luong) {
        this.luong = luong;
    }

    public String getTrangThai() {
        return this.trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }

    public LocalDateTime getNgayXoa() {
        return this.ngayXoa;
    }

    public void setNgayXoa(LocalDateTime ngayXoa) {
        this.ngayXoa = ngayXoa;
    }
}
