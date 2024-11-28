package com.webservice.hethongchothuevesi.dto;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class HoaDonDTO {
	private Integer idHoaDon;
	private Integer idHopDong;
	private LocalDate ngayLap;
	private BigDecimal tongTien;
	private String phuongThucThanhToan;
	private String trangThai;
	private LocalDateTime ngayXoa;
}
