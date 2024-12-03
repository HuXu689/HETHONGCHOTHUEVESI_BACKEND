package com.webservice.hethongchothuevesi.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name = "HopDong")
public class HopDong {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idHopDong")
    Integer idHopDong;

    @Column(name = "idYeuCauDichVu")
    Integer idYeuCauDichVu;

    @Column(name = "hoTenKhachHang")
    String hoTenKhachHang;

    @Column(name = "soDienThoai")
    String soDienThoai;

    @Column(name = "anh")
    String anh;

    @Column(name = "soCCCD")
    String soCccd;

    @Column(name = "diaDiem")
    String diaDiem;

    @Column(name = "soLuongVeSi")
    Integer soLuongVeSi;

    @Column(name = "thoiGianBatDau")
    LocalDateTime thoiGianBatDau;

    @Column(name = "thoiGianKetThuc")
    LocalDateTime thoiGianKetThuc;

    @Column(name = "tongChiPhi")
    BigDecimal tongChiPhi;

    @Column(name = "ghiChu")
    String ghiChu;

    @Column(name = "soSaoDanhGia")
    Integer soSaoDanhGia;

    @Column(name = "thongTinDanhGia")
    String thongTinDanhGia;

    @Column(name = "trangThai")
    String trangThai;

    @Column(name = "ngayXoa")
    LocalDateTime ngayXoa;
}
