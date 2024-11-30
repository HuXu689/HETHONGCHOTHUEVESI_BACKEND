package com.webservice.hethongchothuevesi.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.time.LocalDateTime;

@Entity
@Table(name = "DanhMucKhoaDaoTao")
public class DanhMucKhoaDaoTao {
    @Id
    @Column(name = "idDanhMucKhoaDaoTao")
    private Integer idDanhMucKhoaDaoTao;

    @Column(name = "tenKhoaDaoTao")
    private String tenKhoaDaoTao;

    @Column(name = "moTa")
    private String moTa;

    @Column(name = "ngayXoa")
    private LocalDateTime ngayXoa;

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
