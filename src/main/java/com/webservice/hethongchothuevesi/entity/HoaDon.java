package com.webservice.hethongchothuevesi.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "HoaDon")
public class HoaDon {
    @Id
    @Column(name = "idHoaDon")
    private Integer idHoaDon;

    @Column(name = "idHopDong")
    private Integer idHopDong;

    @Column(name = "ngayLap")
    private LocalDate ngayLap;

    @Column(name = "tongTien")
    private BigDecimal tongTien;

    @Column(name = "phuongThucThanhToan")
    private String phuongThucThanhToan;

    @Column(name = "trangThai")
    private String trangThai;

    @Column(name = "ngayXoa")
    private LocalDateTime ngayXoa;

    public Integer getIdHoaDon() {
        return this.idHoaDon;
    }

    public void setIdHoaDon(Integer idHoaDon) {
        this.idHoaDon = idHoaDon;
    }

    public Integer getIdHopDong() {
        return this.idHopDong;
    }

    public void setIdHopDong(Integer idHopDong) {
        this.idHopDong = idHopDong;
    }

    public LocalDate getNgayLap() {
        return this.ngayLap;
    }

    public void setNgayLap(LocalDate ngayLap) {
        this.ngayLap = ngayLap;
    }

    public BigDecimal getTongTien() {
        return this.tongTien;
    }

    public void setTongTien(BigDecimal tongTien) {
        this.tongTien = tongTien;
    }

    public String getPhuongThucThanhToan() {
        return this.phuongThucThanhToan;
    }

    public void setPhuongThucThanhToan(String phuongThucThanhToan) {
        this.phuongThucThanhToan = phuongThucThanhToan;
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
