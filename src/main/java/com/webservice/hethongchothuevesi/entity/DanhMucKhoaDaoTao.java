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
@Table(name = "DanhMucKhoaDaoTao")
public class DanhMucKhoaDaoTao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idDanhMucKhoaDaoTao")
    private Integer idDanhMucKhoaDaoTao;

    @Column(name = "tenKhoaDaoTao")
    private String tenKhoaDaoTao;

    @Column(name = "moTa")
    private String moTa;

    @Column(name = "ngayXoa")
    private LocalDateTime ngayXoa;
}
