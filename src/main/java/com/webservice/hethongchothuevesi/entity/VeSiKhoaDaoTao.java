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
@Table(name = "VeSiKhoaDaoTao")
public class VeSiKhoaDaoTao {
    @Id
    @Column(name = "idVeSiKhoaDaoTao")
    private Integer idVeSiKhoaDaoTao;

    @Column(name = "idKhoaDaoTao")
    private Integer idKhoaDaoTao;

    @Column(name = "idVeSi")
    private Integer idVeSi;

    @Column(name = "ngayHoanThanh")
    private LocalDate ngayHoanThanh;

    @Column(name = "diem")
    private Float diem;

    @Column(name = "chungChi")
    private String chungChi;

    @Column(name = "trangThai")
    private String trangThai;

    @Column(name = "trangThaiXoa")
    private Byte trangThaiXoa;
}
