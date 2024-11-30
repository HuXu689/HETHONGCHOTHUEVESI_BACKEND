package com.webservice.hethongchothuevesi.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.time.LocalDateTime;

@Entity
@Table(name = "DanhMucThongBao")
public class DanhMucThongBao {
    @Id
    @Column(name = "idDanhMucThongBao")
    private Integer idDanhMucThongBao;

    @Column(name = "tenLoaiThongBao")
    private String tenLoaiThongBao;

    @Column(name = "moTa")
    private String moTa;

    @Column(name = "ngayXoa")
    private LocalDateTime ngayXoa;

    public Integer getIdDanhMucThongBao() {
        return this.idDanhMucThongBao;
    }

    public void setIdDanhMucThongBao(Integer idDanhMucThongBao) {
        this.idDanhMucThongBao = idDanhMucThongBao;
    }

    public String getTenLoaiThongBao() {
        return this.tenLoaiThongBao;
    }

    public void setTenLoaiThongBao(String tenLoaiThongBao) {
        this.tenLoaiThongBao = tenLoaiThongBao;
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
