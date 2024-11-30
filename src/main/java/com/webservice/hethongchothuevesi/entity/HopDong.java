package com.webservice.hethongchothuevesi.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "HopDong")
public class HopDong {
    @Id
    @Column(name = "idHopDong")
    private Integer idHopDong;

    @Column(name = "idYeuCauDichVu")
    private Integer idYeuCauDichVu;

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

    @Column(name = "thoiGianBatDau")
    private LocalDateTime thoiGianBatDau;

    @Column(name = "thoiGianKetThuc")
    private LocalDateTime thoiGianKetThuc;

    @Column(name = "tongChiPhi")
    private BigDecimal tongChiPhi;

    @Column(name = "ghiChu")
    private String ghiChu;

    @Column(name = "soSaoDanhGia")
    private Integer soSaoDanhGia;

    @Column(name = "thongTinDanhGia")
    private String thongTinDanhGia;

    @Column(name = "trangThai")
    private String trangThai;

    @Column(name = "ngayXoa")
    private LocalDateTime ngayXoa;

    public Integer getIdHopDong() {
        return this.idHopDong;
    }

    public void setIdHopDong(Integer idHopDong) {
        this.idHopDong = idHopDong;
    }

    public Integer getIdYeuCauDichVu() {
        return this.idYeuCauDichVu;
    }

    public void setIdYeuCauDichVu(Integer idYeuCauDichVu) {
        this.idYeuCauDichVu = idYeuCauDichVu;
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

    public LocalDateTime getThoiGianBatDau() {
        return this.thoiGianBatDau;
    }

    public void setThoiGianBatDau(LocalDateTime thoiGianBatDau) {
        this.thoiGianBatDau = thoiGianBatDau;
    }

    public LocalDateTime getThoiGianKetThuc() {
        return this.thoiGianKetThuc;
    }

    public void setThoiGianKetThuc(LocalDateTime thoiGianKetThuc) {
        this.thoiGianKetThuc = thoiGianKetThuc;
    }

    public BigDecimal getTongChiPhi() {
        return this.tongChiPhi;
    }

    public void setTongChiPhi(BigDecimal tongChiPhi) {
        this.tongChiPhi = tongChiPhi;
    }

    public String getGhiChu() {
        return this.ghiChu;
    }

    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
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
