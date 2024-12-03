package com.webservice.hethongchothuevesi.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name = "VeSiKyNang")
public class VeSiKyNang {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idVeSiKyNang")
    Integer idVeSiKyNang;

    @Column(name = "idDanhMucKyNang")
    Integer idDanhMucKyNang;

    @Column(name = "idVeSi")
    Integer idVeSi;

    @Column(name = "capBac")
    String capBac;

    @Column(name = "danhGia")
    String danhGia;

    @Column(name = "ngayXoa")
    LocalDateTime ngayXoa;
}
