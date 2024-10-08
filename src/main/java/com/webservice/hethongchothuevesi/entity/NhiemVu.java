package com.webservice.hethongchothuevesi.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "NhiemVu")
public class NhiemVu {
    @Id
    @Column(name = "idNhiemVu")
    private Integer idNhiemVu;

    @Column(name = "idHopDong")
    private Integer idHopDong;

    @Column(name = "idVeSi")
    private Integer idVeSi;

    @Column(name = "ngayBatDau")
    private LocalDate ngayBatDau;

    @Column(name = "ngayKetThuc")
    private LocalDate ngayKetThuc;

    @Column(name = "capBac")
    private String capBac;

    @Column(name = "noiDung")
    private String noiDung;

    @Column(name = "soSaoDanhGia")
    private Integer soSaoDanhGia;

    @Column(name = "thongTinDanhGia")
    private String thongTinDanhGia;

    @Column(name = "trangThai")
    private String trangThai;

    @Column(name = "trangThaiXoa")
    private Byte trangThaiXoa;
}
