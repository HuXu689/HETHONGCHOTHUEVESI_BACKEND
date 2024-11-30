package com.webservice.hethongchothuevesi.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.time.LocalDateTime;

@Entity
@Table(name = "YeuCauHoTro")
public class YeuCauHoTro {
    @Id
    @Column(name = "idYeuCauHoTro")
    private Integer idYeuCauHoTro;

    @Column(name = "idNhanVien")
    private Integer idNhanVien;

    @Column(name = "idNguoiDung")
    private Integer idNguoiDung;

    @Column(name = "loaiYeuCau")
    private String loaiYeuCau;

    @Column(name = "noiDungYeuCau")
    private String noiDungYeuCau;

    @Column(name = "tepDinhKem")
    private String tepDinhKem;

    @Column(name = "noiDungPhanHoi")
    private String noiDungPhanHoi;

    @Column(name = "trangThai")
    private String trangThai;

    @Column(name = "ngayXoa")
    private LocalDateTime ngayXoa;

    public Integer getIdYeuCauHoTro() {
        return this.idYeuCauHoTro;
    }

    public void setIdYeuCauHoTro(Integer idYeuCauHoTro) {
        this.idYeuCauHoTro = idYeuCauHoTro;
    }

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

    public String getLoaiYeuCau() {
        return this.loaiYeuCau;
    }

    public void setLoaiYeuCau(String loaiYeuCau) {
        this.loaiYeuCau = loaiYeuCau;
    }

    public String getNoiDungYeuCau() {
        return this.noiDungYeuCau;
    }

    public void setNoiDungYeuCau(String noiDungYeuCau) {
        this.noiDungYeuCau = noiDungYeuCau;
    }

    public String getTepDinhKem() {
        return this.tepDinhKem;
    }

    public void setTepDinhKem(String tepDinhKem) {
        this.tepDinhKem = tepDinhKem;
    }

    public String getNoiDungPhanHoi() {
        return this.noiDungPhanHoi;
    }

    public void setNoiDungPhanHoi(String noiDungPhanHoi) {
        this.noiDungPhanHoi = noiDungPhanHoi;
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
