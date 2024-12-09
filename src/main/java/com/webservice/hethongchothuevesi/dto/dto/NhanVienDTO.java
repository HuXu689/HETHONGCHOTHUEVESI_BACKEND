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
public class NhanVienDTO {
	private Integer idNhanVien;
	private Integer idNguoiDung;
	private LocalDate ngayBatDauLam;
	private String capBac;
	private LocalDate ngayLenCap;
	private BigDecimal luong;
	private String trangThai;
	private LocalDateTime ngayXoa;
}
