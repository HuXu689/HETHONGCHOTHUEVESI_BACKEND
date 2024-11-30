package com.webservice.hethongchothuevesi.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.time.LocalDateTime;

@Entity
@Table(name = "HoSo")
public class HoSo {
    @Id
    @Column(name = "idHoSo")
    private Integer idHoSo;

    @Column(name = "idVeSi")
    private Integer idVeSi;

    @Column(name = "loaiHoSo")
    private String loaiHoSo;

    @Column(name = "tepDinhKem")
    private String tepDinhKem;

    @Column(name = "ngayXoa")
    private LocalDateTime ngayXoa;

    public Integer getIdHoSo() {
        return this.idHoSo;
    }

    public void setIdHoSo(Integer idHoSo) {
        this.idHoSo = idHoSo;
    }

    public Integer getIdVeSi() {
        return this.idVeSi;
    }

    public void setIdVeSi(Integer idVeSi) {
        this.idVeSi = idVeSi;
    }

    public String getLoaiHoSo() {
        return this.loaiHoSo;
    }

    public void setLoaiHoSo(String loaiHoSo) {
        this.loaiHoSo = loaiHoSo;
    }

    public String getTepDinhKem() {
        return this.tepDinhKem;
    }

    public void setTepDinhKem(String tepDinhKem) {
        this.tepDinhKem = tepDinhKem;
    }

    public LocalDateTime getNgayXoa() {
        return this.ngayXoa;
    }

    public void setNgayXoa(LocalDateTime ngayXoa) {
        this.ngayXoa = ngayXoa;
    }
}
