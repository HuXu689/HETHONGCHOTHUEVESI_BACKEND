package com.webservice.hethongchothuevesi.dto.dto;

import java.time.LocalDateTime;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class LichSuHoatDongDTO {
	private Integer idLichSuHoatDong;
	private Integer idNguoiDung;
	private Integer idDoiTuong;
	private String loaiDoiTuong;
	private LocalDateTime thoiGianThucHien;
	private String hoatDong;
	private String thongTinHoatDong;
}
