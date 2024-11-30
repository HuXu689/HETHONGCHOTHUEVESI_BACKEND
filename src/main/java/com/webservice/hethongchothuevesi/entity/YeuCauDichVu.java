package com.webservice.hethongchothuevesi.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "YeuCauDichVu")
public class YeuCauDichVu {
    @Id
    @Column(name = "idYeuCauDichVu")
    private Integer idYeuCauDichVu;

    @Column(name = "idNguoiDung")
    private Integer idNguoiDung;

    @Column(name = "idDanhMucDichVu")
    private Integer idDanhMucDichVu;

    @Column(name = "hoTenKhachHang")
    private String hoTenKhachHang;

    @Column(name = "soDienThoai")
    private String soDienThoai;

    @Column(name = "anh")
    private String anh;

    @Column(name = "soCCCD")
    private String soCccd;

    @Column(name = "diaDiem")
    private String diaDiem;

    @Column(name = "soLuongVeSi")
    private Integer soLuongVeSi;

    @Column(name = "ngayBatDau")
    private LocalDate ngayBatDau;

    @Column(name = "ngayKetThuc")
    private LocalDate ngayKetThuc;

    @Column(name = "giaTienDuKien")
    private BigDecimal giaTienDuKien;

    @Column(name = "ghiChu")
    private String ghiChu;

    @Column(name = "noiDungTraLoi")
    private String noiDungTraLoi;

    @Column(name = "trangThai")
    private String trangThai;

    @Column(name = "ngayXoa")
    private LocalDateTime ngayXoa;

    public Integer getIdYeuCauDichVu() {
        return this.idYeuCauDichVu;
    }

    public void setIdYeuCauDichVu(Integer idYeuCauDichVu) {
        this.idYeuCauDichVu = idYeuCauDichVu;
    }

    public Integer getIdNguoiDung() {
        return this.idNguoiDung;
    }

    public void setIdNguoiDung(Integer idNguoiDung) {
        this.idNguoiDung = idNguoiDung;
    }

    public Integer getIdDanhMucDichVu() {
        return this.idDanhMucDichVu;
    }

    public void setIdDanhMucDichVu(Integer idDanhMucDichVu) {
        this.idDanhMucDichVu = idDanhMucDichVu;
    }

    public String getHoTenKhachHang() {
        return this.hoTenKhachHang;
    }

    public void setHoTenKhachHang(String hoTenKhachHang) {
        this.hoTenKhachHang = hoTenKhachHang;
    }

    public String getSoDienThoai() {
        return this.soDienThoai;
    }

    public void setSoDienThoai(String soDienThoai) {
        this.soDienThoai = soDienThoai;
    }

    public String getAnh() {
        return this.anh;
    }

    public void setAnh(String anh) {
        this.anh = anh;
    }

    public String getSoCccd() {
        return this.soCccd;
    }

    public void setSoCccd(String soCccd) {
        this.soCccd = soCccd;
    }

    public String getDiaDiem() {
        return this.diaDiem;
    }

    public void setDiaDiem(String diaDiem) {
        this.diaDiem = diaDiem;
    }

    public Integer getSoLuongVeSi() {
        return this.soLuongVeSi;
    }

    public void setSoLuongVeSi(Integer soLuongVeSi) {
        this.soLuongVeSi = soLuongVeSi;
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

    public BigDecimal getGiaTienDuKien() {
        return this.giaTienDuKien;
    }

    public void setGiaTienDuKien(BigDecimal giaTienDuKien) {
        this.giaTienDuKien = giaTienDuKien;
    }

    public String getGhiChu() {
        return this.ghiChu;
    }

    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }

    public String getNoiDungTraLoi() {
        return this.noiDungTraLoi;
    }

    public void setNoiDungTraLoi(String noiDungTraLoi) {
        this.noiDungTraLoi = noiDungTraLoi;
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
