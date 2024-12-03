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
@Table(name = "VeSiKhoaDaoTao")
public class VeSiKhoaDaoTao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idVeSiKhoaDaoTao")
    Integer idVeSiKhoaDaoTao;

    @Column(name = "idKhoaDaoTao")
    Integer idKhoaDaoTao;

    @Column(name = "idVeSi")
    Integer idVeSi;

    @Column(name = "ngayHoanThanh")
    LocalDate ngayHoanThanh;

    @Column(name = "diem")
    Float diem;

    @Column(name = "chungChi")
    String chungChi;

    @Column(name = "trangThai")
    String trangThai;

    @Column(name = "ngayXoa")
    LocalDateTime ngayXoa;
}
