package com.webservice.hethongchothuevesi.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.time.LocalDateTime;

@Entity
@Table(name = "DanhMucKyNang")
public class DanhMucKyNang {
    @Id
    @Column(name = "idDanhMucKyNang")
    private Integer idDanhMucKyNang;

    @Column(name = "tenKyNang")
    private String tenKyNang;

    @Column(name = "moTa")
    private String moTa;

    @Column(name = "ngayXoa")
    private LocalDateTime ngayXoa;

    public Integer getIdDanhMucKyNang() {
        return this.idDanhMucKyNang;
    }

    public void setIdDanhMucKyNang(Integer idDanhMucKyNang) {
        this.idDanhMucKyNang = idDanhMucKyNang;
    }

    public String getTenKyNang() {
        return this.tenKyNang;
    }

    public void setTenKyNang(String tenKyNang) {
        this.tenKyNang = tenKyNang;
    }

    public String getMoTa() {
        return this.moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    public LocalDateTime getNgayXoa() {
        return this.ngayXoa;
    }

    public void setNgayXoa(LocalDateTime ngayXoa) {
        this.ngayXoa = ngayXoa;
    }
}
