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
@Table(name = "VaiTro")
public class VaiTro {
    @Id
    @Column(name = "idVaiTro")
    private Integer idVaiTro;

    @Column(name = "tenVaiTro")
    private String tenVaiTro;

    @Column(name = "capBac")
    private String capBac;

    @Column(name = "moTa")
    private String moTa;
}
