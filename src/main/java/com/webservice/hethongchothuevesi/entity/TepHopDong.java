package com.webservice.hethongchothuevesi.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "TepHopDong")
public class TepHopDong {
    @Id
    @Column(name = "idTepHopDong")
    private Integer idTepHopDong;

    @Column(name = "idHopDong")
    private Integer idHopDong;

    @Column(name = "loaiTep")
    private String loaiTep;

    @Column(name = "tepDinhKem")
    private String tepDinhKem;

    public Integer getIdTepHopDong() {
        return this.idTepHopDong;
    }

    public void setIdTepHopDong(Integer idTepHopDong) {
        this.idTepHopDong = idTepHopDong;
    }

    public Integer getIdHopDong() {
        return this.idHopDong;
    }

    public void setIdHopDong(Integer idHopDong) {
        this.idHopDong = idHopDong;
    }

    public String getLoaiTep() {
        return this.loaiTep;
    }

    public void setLoaiTep(String loaiTep) {
        this.loaiTep = loaiTep;
    }

    public String getTepDinhKem() {
        return this.tepDinhKem;
    }

    public void setTepDinhKem(String tepDinhKem) {
        this.tepDinhKem = tepDinhKem;
    }
}
