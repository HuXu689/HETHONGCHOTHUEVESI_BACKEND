package com.webservice.hethongchothuevesi.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.time.LocalDateTime;

@Entity
@Table(name = "VeSiKyNang")
public class VeSiKyNang {
    @Id
    @Column(name = "idVeSiKyNang")
    private Integer idVeSiKyNang;

    @Column(name = "idDanhMucKyNang")
    private Integer idDanhMucKyNang;

    @Column(name = "idVeSi")
    private Integer idVeSi;

    @Column(name = "capBac")
    private String capBac;

    @Column(name = "danhGia")
    private String danhGia;

    @Column(name = "ngayXoa")
    private LocalDateTime ngayXoa;

    public Integer getIdVeSiKyNang() {
        return this.idVeSiKyNang;
    }

    public void setIdVeSiKyNang(Integer idVeSiKyNang) {
        this.idVeSiKyNang = idVeSiKyNang;
    }

    public Integer getIdDanhMucKyNang() {
        return this.idDanhMucKyNang;
    }

    public void setIdDanhMucKyNang(Integer idDanhMucKyNang) {
        this.idDanhMucKyNang = idDanhMucKyNang;
    }

    public Integer getIdVeSi() {
        return this.idVeSi;
    }

    public void setIdVeSi(Integer idVeSi) {
        this.idVeSi = idVeSi;
    }

    public String getCapBac() {
        return this.capBac;
    }

    public void setCapBac(String capBac) {
        this.capBac = capBac;
    }

    public String getDanhGia() {
        return this.danhGia;
    }

    public void setDanhGia(String danhGia) {
        this.danhGia = danhGia;
    }

    public LocalDateTime getNgayXoa() {
        return this.ngayXoa;
    }

    public void setNgayXoa(LocalDateTime ngayXoa) {
        this.ngayXoa = ngayXoa;
    }
}
