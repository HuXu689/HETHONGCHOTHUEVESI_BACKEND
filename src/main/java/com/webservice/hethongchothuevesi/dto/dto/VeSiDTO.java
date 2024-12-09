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
public class VeSiDTO {
	private Integer idVeSi;
	private Integer idNguoiDung;
	private Integer kinhNghiem;
	private String thongTinDanhGiaChung;
	private LocalDate ngayBatDauLam;
	private String capBac;
	private LocalDate ngayLenCap;
	private BigDecimal luong;
	private String trangThai;
	private LocalDateTime ngayXoa;
}
