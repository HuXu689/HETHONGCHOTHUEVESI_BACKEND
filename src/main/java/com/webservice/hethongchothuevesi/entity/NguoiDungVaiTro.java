package com.webservice.hethongchothuevesi.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name = "NguoiDungVaiTro")
public class NguoiDungVaiTro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idNguoiDungVaiTro")
    Integer idNguoiDungVaiTro;

    @Column(name = "idNguoiDung")
    Integer idNguoiDung;

    @Column(name = "idVaiTro")
    Integer idVaiTro;
}
