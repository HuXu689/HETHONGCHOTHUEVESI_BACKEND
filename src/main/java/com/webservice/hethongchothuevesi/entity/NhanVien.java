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
@Table(name = "NhanVien")
public class NhanVien {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idNhanVien")
    Integer idNhanVien;

    @Column(name = "idNguoiDung")
    Integer idNguoiDung;

    @Column(name = "ngayBatDauLam")
    LocalDate ngayBatDauLam;

    @Column(name = "capBac")
    String capBac;

    @Column(name = "ngayLenCap")
    LocalDate ngayLenCap;

    @Column(name = "luong")
    BigDecimal luong;

    @Column(name = "trangThai")
    String trangThai;

    @Column(name = "ngayXoa")
    LocalDateTime ngayXoa;
}
