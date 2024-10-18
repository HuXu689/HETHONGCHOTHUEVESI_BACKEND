package com.webservice.hethongchothuevesi.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BaoCaoKhanNhiemVuDTO {
    private Integer idBaoCaoKhan;
    private Integer idNhiemVu;
    private Integer idNhanVien;
    private String noiDung;
    private String mucDoKhanCap;
    private String trangThai;
    private LocalDateTime ngayXoa;
}
