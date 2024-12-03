package com.webservice.hethongchothuevesi.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name = "HoaDon")
public class HoaDon {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idHoaDon")
    Integer idHoaDon;

    @Column(name = "idHopDong")
    Integer idHopDong;

    @Column(name = "ngayLap")
    LocalDate ngayLap;

    @Column(name = "tongTien")
    BigDecimal tongTien;

    @Column(name = "phuongThucThanhToan")
    String phuongThucThanhToan;

    @Column(name = "trangThai")
    String trangThai;

    @Column(name = "ngayXoa")
    LocalDateTime ngayXoa;
}
