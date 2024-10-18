package com.webservice.hethongchothuevesi.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "VeSiKyNang")
public class VeSiKyNang {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idVeSiKyNang")
    private Integer idVeSiKyNang;

    @Column(name = "idDanhMucKyNang")
    private Integer idDanhMucKyNang;

    @Column(name = "idVeSi")
    private Integer idVeSi;

    @Column(name = "capBac")
    private String capBac;

    @Column(name = "danhGia")
    private String danhGia;

    @Column(name = "ngayXoa")
    private LocalDateTime ngayXoa;
}
