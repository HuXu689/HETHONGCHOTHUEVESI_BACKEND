package com.webservice.hethongchothuevesi.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "YeuCauDichVu")
public class YeuCauDichVu {
    @Id
    @Column(name = "idYeuCauDichVu")
    private Integer idYeuCauDichVu;

    @Column(name = "idKhachHang")
    private Integer idKhachHang;

    @Column(name = "idDanhMucDichVu")
    private Integer idDanhMucDichVu;

    @Column(name = "diaDiem")
    private String diaDiem;

    @Column(name = "soLuongVeSi")
    private Integer soLuongVeSi;

    @Column(name = "ngayBatDau")
    private LocalDate ngayBatDau;

    @Column(name = "ngayKetThuc")
    private LocalDate ngayKetThuc;

    @Column(name = "giaTienDuKien")
    private BigDecimal giaTienDuKien;

    @Column(name = "ghiChu")
    private String ghiChu;

    @Column(name = "noiDungTraLoi")
    private String noiDungTraLoi;

    @Column(name = "trangThai")
    private String trangThai;

    @Column(name = "trangThaiXoa")
    private Byte trangThaiXoa;
}
