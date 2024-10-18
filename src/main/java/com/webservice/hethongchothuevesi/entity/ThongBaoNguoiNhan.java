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
@Table(name = "ThongBao_NguoiNhan")
public class ThongBaoNguoiNhan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idThongBaoNguoiNhan")
    private Integer idThongBaoNguoiNhan;

    @Column(name = "idThongBao")
    private Integer idThongBao;

    @Column(name = "idNguoiNhan")
    private Integer idNguoiNhan;

    @Column(name = "vaiTroNguoiNhan")
    private String vaiTroNguoiNhan;

    @Column(name = "thoiGianDoc")
    private LocalDateTime thoiGianDoc;

    @Column(name = "ngayXoa")
    private LocalDateTime ngayXoa;
}
