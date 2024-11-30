package com.webservice.hethongchothuevesi.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "NhiemVu")
public class NhiemVu {
    @Id
    @Column(name = "idNhiemVu")
    private Integer idNhiemVu;

    @Column(name = "idHopDong")
    private Integer idHopDong;

    @Column(name = "idVeSi")
    private Integer idVeSi;

    @Column(name = "ngayBatDau")
    private LocalDate ngayBatDau;

    @Column(name = "ngayKetThuc")
    private LocalDate ngayKetThuc;

    @Column(name = "capBac")
    private String capBac;

    @Column(name = "noiDung")
    private String noiDung;

    @Column(name = "soSaoDanhGia")
    private Integer soSaoDanhGia;

    @Column(name = "thongTinDanhGia")
    private String thongTinDanhGia;

    @Column(name = "trangThai")
    private String trangThai;

    @Column(name = "ngayXoa")
    private LocalDateTime ngayXoa;

    public Integer getIdNhiemVu() {
        return this.idNhiemVu;
    }

    public void setIdNhiemVu(Integer idNhiemVu) {
        this.idNhiemVu = idNhiemVu;
    }

    public Integer getIdHopDong() {
        return this.idHopDong;
    }

    public void setIdHopDong(Integer idHopDong) {
        this.idHopDong = idHopDong;
    }

    public Integer getIdVeSi() {
        return this.idVeSi;
    }

    public void setIdVeSi(Integer idVeSi) {
        this.idVeSi = idVeSi;
    }

    public LocalDate getNgayBatDau() {
        return this.ngayBatDau;
    }

    public void setNgayBatDau(LocalDate ngayBatDau) {
        this.ngayBatDau = ngayBatDau;
    }

    public LocalDate getNgayKetThuc() {
        return this.ngayKetThuc;
    }

    public void setNgayKetThuc(LocalDate ngayKetThuc) {
        this.ngayKetThuc = ngayKetThuc;
    }

    public String getCapBac() {
        return this.capBac;
    }

    public void setCapBac(String capBac) {
        this.capBac = capBac;
    }

    public String getNoiDung() {
        return this.noiDung;
    }

    public void setNoiDung(String noiDung) {
        this.noiDung = noiDung;
    }

    public Integer getSoSaoDanhGia() {
        return this.soSaoDanhGia;
    }

    public void setSoSaoDanhGia(Integer soSaoDanhGia) {
        this.soSaoDanhGia = soSaoDanhGia;
    }

    public String getThongTinDanhGia() {
        return this.thongTinDanhGia;
    }

    public void setThongTinDanhGia(String thongTinDanhGia) {
        this.thongTinDanhGia = thongTinDanhGia;
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
