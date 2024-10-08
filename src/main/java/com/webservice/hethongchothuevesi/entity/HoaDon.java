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
@Table(name = "HoaDon")
public class HoaDon {
    @Id
    @Column(name = "idHoaDon")
    private Integer idHoaDon;

    @Column(name = "idHopDong")
    private Integer idHopDong;

    @Column(name = "ngayLap")
    private LocalDate ngayLap;

    @Column(name = "tongTien")
    private BigDecimal tongTien;

    @Column(name = "phuongThucThanhToan")
    private String phuongThucThanhToan;

    @Column(name = "trangThai")
    private String trangThai;

    @Column(name = "trangThaiXoa")
    private Byte trangThaiXoa;
}
