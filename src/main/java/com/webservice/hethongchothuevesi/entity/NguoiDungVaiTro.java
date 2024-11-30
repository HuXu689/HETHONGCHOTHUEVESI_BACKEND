package com.webservice.hethongchothuevesi.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
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
    @Column(name = "idNguoiDungVaiTro")
    Integer idNguoiDungVaiTro;

    @Column(name = "idNguoiDung")
    Integer idNguoiDung;

    @Column(name = "idVaiTro")
    Integer idVaiTro;
}
