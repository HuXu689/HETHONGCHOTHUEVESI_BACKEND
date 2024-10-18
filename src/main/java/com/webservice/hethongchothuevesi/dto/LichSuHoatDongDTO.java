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
public class LichSuHoatDongDTO {
    private Integer idLichSuHoatDong;
    private Integer idDoiTuong;
    private String loaiDoiTuong;
    private LocalDateTime thoiGianThucHien;
    private String nguoiThucHien;
    private String hoatDong;
    private String thongTinHoatDong;
}
