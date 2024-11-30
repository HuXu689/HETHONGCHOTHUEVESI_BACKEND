package com.webservice.hethongchothuevesi.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "VeSiKhoaDaoTao")
public class VeSiKhoaDaoTao {
    @Id
    @Column(name = "idVeSiKhoaDaoTao")
    private Integer idVeSiKhoaDaoTao;

    @Column(name = "idKhoaDaoTao")
    private Integer idKhoaDaoTao;

    @Column(name = "idVeSi")
    private Integer idVeSi;

    @Column(name = "ngayHoanThanh")
    private LocalDate ngayHoanThanh;

    @Column(name = "diem")
    private Float diem;

    @Column(name = "chungChi")
    private String chungChi;

    @Column(name = "trangThai")
    private String trangThai;

    @Column(name = "ngayXoa")
    private LocalDateTime ngayXoa;

    public Integer getIdVeSiKhoaDaoTao() {
        return this.idVeSiKhoaDaoTao;
    }

    public void setIdVeSiKhoaDaoTao(Integer idVeSiKhoaDaoTao) {
        this.idVeSiKhoaDaoTao = idVeSiKhoaDaoTao;
    }

    public Integer getIdKhoaDaoTao() {
        return this.idKhoaDaoTao;
    }

    public void setIdKhoaDaoTao(Integer idKhoaDaoTao) {
        this.idKhoaDaoTao = idKhoaDaoTao;
    }

    public Integer getIdVeSi() {
        return this.idVeSi;
    }

    public void setIdVeSi(Integer idVeSi) {
        this.idVeSi = idVeSi;
    }

    public LocalDate getNgayHoanThanh() {
        return this.ngayHoanThanh;
    }

    public void setNgayHoanThanh(LocalDate ngayHoanThanh) {
        this.ngayHoanThanh = ngayHoanThanh;
    }

    public Float getDiem() {
        return this.diem;
    }

    public void setDiem(Float diem) {
        this.diem = diem;
    }

    public String getChungChi() {
        return this.chungChi;
    }

    public void setChungChi(String chungChi) {
        this.chungChi = chungChi;
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
