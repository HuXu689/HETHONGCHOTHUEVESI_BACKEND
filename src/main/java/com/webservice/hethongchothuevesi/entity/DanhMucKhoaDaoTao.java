package com.webservice.hethongchothuevesi.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "DanhMucKhoaDaoTao")
public class DanhMucKhoaDaoTao {
    @Id
    @Column(name = "idDanhMucKhoaDaoTao")
    private Integer idDanhMucKhoaDaoTao;

    @Column(name = "tenKhoaDaoTao")
    private String tenKhoaDaoTao;

    @Column(name = "moTa")
    private String moTa;

    @Column(name = "trangThaiXoa")
    private Byte trangThaiXoa;
}
