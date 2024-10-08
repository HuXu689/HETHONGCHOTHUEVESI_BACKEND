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
@Table(name = "BaoCaoKhanNhiemVu")
public class BaoCaoKhanNhiemVu {
    @Id
    @Column(name = "idBaoCaoKhan")
    private Integer idBaoCaoKhan;

    @Column(name = "idNhiemVu")
    private Integer idNhiemVu;

    @Column(name = "idNhanVien")
    private Integer idNhanVien;

    @Column(name = "noiDung")
    private String noiDung;

    @Column(name = "mucDoKhanCap")
    private String mucDoKhanCap;

    @Column(name = "trangThai")
    private String trangThai;

    @Column(name = "trangThaiXoa")
    private Byte trangThaiXoa;
}
