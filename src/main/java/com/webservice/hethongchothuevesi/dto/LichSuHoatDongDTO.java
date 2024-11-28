package com.webservice.hethongchothuevesi.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
