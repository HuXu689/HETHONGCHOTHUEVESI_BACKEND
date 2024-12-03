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
@Table(name = "ThongBaoNguoiDung")
public class ThongBaoNguoiDung {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idThongBaoNguoiDung")
    Integer idThongBaoNguoiDung;

    @Column(name = "idThongBao")
    Integer idThongBao;

    @Column(name = "idNguoiDung")
    Integer idNguoiDung;

    @Column(name = "thoiGianDoc")
    LocalDateTime thoiGianDoc;

    @Column(name = "ngayXoa")
    LocalDateTime ngayXoa;
}
