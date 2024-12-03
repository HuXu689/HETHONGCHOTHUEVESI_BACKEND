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
@Table(name = "ThongBao")
public class ThongBao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idThongBao")
    Integer idThongBao;

    @Column(name = "idNhanVien")
    Integer idNhanVien;

    @Column(name = "idDanhMucThongBao")
    Integer idDanhMucThongBao;

    @Column(name = "tieuDe")
    String tieuDe;

    @Column(name = "noiDung")
    String noiDung;

    @Column(name = "ngayXoa")
    LocalDateTime ngayXoa;
}
