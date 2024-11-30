package com.webservice.hethongchothuevesi.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.time.LocalDateTime;

@Entity
@Table(name = "ThongBaoNguoiDung")
public class ThongBaoNguoiDung {
    @Id
    @Column(name = "idThongBaoNguoiNhan")
    private Integer idThongBaoNguoiNhan;

    @Column(name = "idThongBao")
    private Integer idThongBao;

    @Column(name = "idNguoiDung")
    private Integer idNguoiDung;

    @Column(name = "thoiGianDoc")
    private LocalDateTime thoiGianDoc;

    @Column(name = "ngayXoa")
    private LocalDateTime ngayXoa;

    public Integer getIdThongBaoNguoiNhan() {
        return this.idThongBaoNguoiNhan;
    }

    public void setIdThongBaoNguoiNhan(Integer idThongBaoNguoiNhan) {
        this.idThongBaoNguoiNhan = idThongBaoNguoiNhan;
    }

    public Integer getIdThongBao() {
        return this.idThongBao;
    }

    public void setIdThongBao(Integer idThongBao) {
        this.idThongBao = idThongBao;
    }

    public Integer getIdNguoiDung() {
        return this.idNguoiDung;
    }

    public void setIdNguoiDung(Integer idNguoiDung) {
        this.idNguoiDung = idNguoiDung;
    }

    public LocalDateTime getThoiGianDoc() {
        return this.thoiGianDoc;
    }

    public void setThoiGianDoc(LocalDateTime thoiGianDoc) {
        this.thoiGianDoc = thoiGianDoc;
    }

    public LocalDateTime getNgayXoa() {
        return this.ngayXoa;
    }

    public void setNgayXoa(LocalDateTime ngayXoa) {
        this.ngayXoa = ngayXoa;
    }
}
