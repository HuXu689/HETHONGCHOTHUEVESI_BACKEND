package com.webservice.hethongchothuevesi.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.time.LocalDateTime;

@Entity
@Table(name = "ThongBao")
public class ThongBao {
    @Id
    @Column(name = "idThongBao")
    private Integer idThongBao;

    @Column(name = "idNhanVien")
    private Integer idNhanVien;

    @Column(name = "idDanhMucThongBao")
    private Integer idDanhMucThongBao;

    @Column(name = "tieuDe")
    private String tieuDe;

    @Column(name = "noiDung")
    private String noiDung;

    @Column(name = "ngayXoa")
    private LocalDateTime ngayXoa;

    public Integer getIdThongBao() {
        return this.idThongBao;
    }

    public void setIdThongBao(Integer idThongBao) {
        this.idThongBao = idThongBao;
    }

    public Integer getIdNhanVien() {
        return this.idNhanVien;
    }

    public void setIdNhanVien(Integer idNhanVien) {
        this.idNhanVien = idNhanVien;
    }

    public Integer getIdDanhMucThongBao() {
        return this.idDanhMucThongBao;
    }

    public void setIdDanhMucThongBao(Integer idDanhMucThongBao) {
        this.idDanhMucThongBao = idDanhMucThongBao;
    }

    public String getTieuDe() {
        return this.tieuDe;
    }

    public void setTieuDe(String tieuDe) {
        this.tieuDe = tieuDe;
    }

    public String getNoiDung() {
        return this.noiDung;
    }

    public void setNoiDung(String noiDung) {
        this.noiDung = noiDung;
    }

    public LocalDateTime getNgayXoa() {
        return this.ngayXoa;
    }

    public void setNgayXoa(LocalDateTime ngayXoa) {
        this.ngayXoa = ngayXoa;
    }
}
