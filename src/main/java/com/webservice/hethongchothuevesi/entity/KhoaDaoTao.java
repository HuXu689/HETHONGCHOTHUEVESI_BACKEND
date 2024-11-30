package com.webservice.hethongchothuevesi.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "KhoaDaoTao")
public class KhoaDaoTao {
    @Id
    @Column(name = "idKhoaDaoTao")
    private Integer idKhoaDaoTao;

    @Column(name = "idDanhMucKhoaDaoTao")
    private Integer idDanhMucKhoaDaoTao;

    @Column(name = "tenKhoaDaoTao")
    private String tenKhoaDaoTao;

    @Column(name = "diaDiem")
    private String diaDiem;

    @Column(name = "ngayBatDau")
    private LocalDate ngayBatDau;

    @Column(name = "ngayKetThuc")
    private LocalDate ngayKetThuc;

    @Column(name = "moTa")
    private String moTa;

    @Column(name = "trangThai")
    private String trangThai;

    @Column(name = "ngayXoa")
    private LocalDateTime ngayXoa;

    public Integer getIdKhoaDaoTao() {
        return this.idKhoaDaoTao;
    }

    public void setIdKhoaDaoTao(Integer idKhoaDaoTao) {
        this.idKhoaDaoTao = idKhoaDaoTao;
    }

    public Integer getIdDanhMucKhoaDaoTao() {
        return this.idDanhMucKhoaDaoTao;
    }

    public void setIdDanhMucKhoaDaoTao(Integer idDanhMucKhoaDaoTao) {
        this.idDanhMucKhoaDaoTao = idDanhMucKhoaDaoTao;
    }

    public String getTenKhoaDaoTao() {
        return this.tenKhoaDaoTao;
    }

    public void setTenKhoaDaoTao(String tenKhoaDaoTao) {
        this.tenKhoaDaoTao = tenKhoaDaoTao;
    }

    public String getDiaDiem() {
        return this.diaDiem;
    }

    public void setDiaDiem(String diaDiem) {
        this.diaDiem = diaDiem;
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

    public String getMoTa() {
        return this.moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
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
