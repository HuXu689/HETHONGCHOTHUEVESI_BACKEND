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
@Table(name = "HoSo")
public class HoSo {
    @Id
    @Column(name = "idHoSo")
    private Integer idHoSo;

    @Column(name = "idVeSi")
    private Integer idVeSi;

    @Column(name = "loaiHoSo")
    private String loaiHoSo;

    @Column(name = "tepDinhKem")
    private String tepDinhKem;

    @Column(name = "trangThaiXoa")
    private Byte trangThaiXoa;
}
