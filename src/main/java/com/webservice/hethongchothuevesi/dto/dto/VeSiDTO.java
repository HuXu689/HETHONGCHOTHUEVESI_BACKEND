package com.webservice.hethongchothuevesi.dto.dto;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class VeSiDTO {
	Integer idVeSi;
	Integer idNguoiDung;
	Integer kinhNghiem;
	String thongTinDanhGiaChung;
	String emailVeSi;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
	LocalDate ngaySinhVeSi;

	String gioiTinhVeSi;
	String sdtVeSi;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
	LocalDate ngayBatDauLam;

	String capBac;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
	LocalDate ngayLenCap;

	BigDecimal luong;
	String trangThai;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm:ss")
	LocalDateTime ngayXoa;
}
