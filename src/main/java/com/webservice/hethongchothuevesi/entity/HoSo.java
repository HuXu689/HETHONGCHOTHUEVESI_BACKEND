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
@Table(name = "HoSo")
public class HoSo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idHoSo")
    private Integer idHoSo;

    @Column(name = "idVeSi")
    private Integer idVeSi;

    @Column(name = "loaiHoSo")
    private String loaiHoSo;

    @Column(name = "tepDinhKem")
    private String tepDinhKem;

    @Column(name = "ngayXoa")
    private LocalDateTime ngayXoa;
}
