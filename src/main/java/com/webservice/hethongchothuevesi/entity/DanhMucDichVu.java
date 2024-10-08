package com.webservice.hethongchothuevesi.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "DanhMucDichVu")
public class DanhMucDichVu {
    @Id
    @Column(name = "idDanhMucDichVu")
    private Integer idDanhMucDichVu;

    @Column(name = "tenDichVu")
    private String tenDichVu;

    @Column(name = "moTa")
    private String moTa;

    @Column(name = "giaDuKien")
    private BigDecimal giaDuKien;

    @Column(name = "trangThaiXoa")
    private Byte trangThaiXoa;
}
