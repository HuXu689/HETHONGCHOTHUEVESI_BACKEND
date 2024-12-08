package com.webservice.hethongchothuevesi.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name = "NhiemVu")
public class NhiemVu {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idNhiemVu")
    Integer idNhiemVu;

    @Column(name = "idHopDong")
    Integer idHopDong;

    @Column(name = "idVeSi")
    Integer idVeSi;

    @Column(name = "ngayBatDau")
    LocalDate ngayBatDau;

    @Column(name = "ngayKetThuc")
    LocalDate ngayKetThuc;

    @Column(name = "capBac")
    String capBac;

    @Column(name = "noiDung")
    String noiDung;

    @Column(name = "danhGiaKyNangChuyenMon")
    Integer danhGiaKyNangChuyenMon;

    @Column(name = "danhGiaXuLyTinhHuong")
    Integer danhGiaXuLyTinhHuong;

    @Column(name = "danhGiaThaiDoDaoDuc")
    Integer danhGiaThaiDoDaoDuc;

    @Column(name = "danhGiaGiaoTiep")
    Integer danhGiaGiaoTiep;

    @Column(name = "danhGiaNgoaiHinh")
    Integer danhGiaNgoaiHinh;

    @Column(name = "thongTinDanhGia")
    String thongTinDanhGia;

    @Column(name = "trangThai")
    String trangThai;

    @Column(name = "ngayXoa")
    LocalDateTime ngayXoa;
}
