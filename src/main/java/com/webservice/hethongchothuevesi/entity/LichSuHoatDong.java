package com.webservice.hethongchothuevesi.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.time.LocalDateTime;

@Entity
@Table(name = "LichSuHoatDong")
public class LichSuHoatDong {
    @Id
    @Column(name = "idLichSuHoatDong")
    private Integer idLichSuHoatDong;

    @Column(name = "idNguoiDung")
    private Integer idNguoiDung;

    @Column(name = "idDoiTuong")
    private Integer idDoiTuong;

    @Column(name = "loaiDoiTuong")
    private String loaiDoiTuong;

    @Column(name = "thoiGianThucHien")
    private LocalDateTime thoiGianThucHien;

    @Column(name = "hoatDong")
    private String hoatDong;

    @Column(name = "thongTinHoatDong")
    private String thongTinHoatDong;

    public Integer getIdLichSuHoatDong() {
        return this.idLichSuHoatDong;
    }

    public void setIdLichSuHoatDong(Integer idLichSuHoatDong) {
        this.idLichSuHoatDong = idLichSuHoatDong;
    }

    public Integer getIdNguoiDung() {
        return this.idNguoiDung;
    }

    public void setIdNguoiDung(Integer idNguoiDung) {
        this.idNguoiDung = idNguoiDung;
    }

    public Integer getIdDoiTuong() {
        return this.idDoiTuong;
    }

    public void setIdDoiTuong(Integer idDoiTuong) {
        this.idDoiTuong = idDoiTuong;
    }

    public String getLoaiDoiTuong() {
        return this.loaiDoiTuong;
    }

    public void setLoaiDoiTuong(String loaiDoiTuong) {
        this.loaiDoiTuong = loaiDoiTuong;
    }

    public LocalDateTime getThoiGianThucHien() {
        return this.thoiGianThucHien;
    }

    public void setThoiGianThucHien(LocalDateTime thoiGianThucHien) {
        this.thoiGianThucHien = thoiGianThucHien;
    }

    public String getHoatDong() {
        return this.hoatDong;
    }

    public void setHoatDong(String hoatDong) {
        this.hoatDong = hoatDong;
    }

    public String getThongTinHoatDong() {
        return this.thongTinHoatDong;
    }

    public void setThongTinHoatDong(String thongTinHoatDong) {
        this.thongTinHoatDong = thongTinHoatDong;
    }
}
