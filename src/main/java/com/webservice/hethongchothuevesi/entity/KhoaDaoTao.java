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
@Table(name = "KhoaDaoTao")
public class KhoaDaoTao {
    @Id
    @Column(name = "idKhoaDaoTao")
    private Integer idKhoaDaoTao;

    @Column(name = "idDanhMucKhoaDaoTao")
    private Integer idDanhMucKhoaDaoTao;

    @Column(name = "tenKhoaDaoTao")
    private String tenKhoaDaoTao;

    @Column(name = "diaDiem")
    private String diaDiem;

    @Column(name = "ngayBatDau")
    private LocalDate ngayBatDau;

    @Column(name = "ngayKetThuc")
    private LocalDate ngayKetThuc;

    @Column(name = "moTa")
    private String moTa;

    @Column(name = "trangThai")
    private String trangThai;

    @Column(name = "trangThaiXoa")
    private Byte trangThaiXoa;
}
