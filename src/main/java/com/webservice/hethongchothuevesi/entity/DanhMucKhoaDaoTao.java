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
@Table(name = "DanhMucKhoaDaoTao")
public class DanhMucKhoaDaoTao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idDanhMucKhoaDaoTao")
    Integer idDanhMucKhoaDaoTao;

    @Column(name = "tenKhoaDaoTao")
    String tenKhoaDaoTao;

    @Column(name = "moTa")
    String moTa;

    @Column(name = "ngayXoa")
    LocalDateTime ngayXoa;
}
