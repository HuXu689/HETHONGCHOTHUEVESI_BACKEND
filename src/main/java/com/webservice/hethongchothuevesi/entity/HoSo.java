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
@Table(name = "HoSo")
public class HoSo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idHoSo")
    Integer idHoSo;

    @Column(name = "idVeSi")
    Integer idVeSi;

    @Column(name = "loaiHoSo")
    String loaiHoSo;

    @Column(name = "tepDinhKem")
    String tepDinhKem;

    @Column(name = "ngayXoa")
    LocalDateTime ngayXoa;
}
