package com.webservice.hethongchothuevesi.dto.dto;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class HoaDonDTO {
	private Integer idHoaDon;
	private Integer idHopDong;
	private LocalDate ngayLap;
	private BigDecimal tongTien;
	private String phuongThucThanhToan;
	private String trangThai;
	private LocalDateTime ngayXoa;
}
