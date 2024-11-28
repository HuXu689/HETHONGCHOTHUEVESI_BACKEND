package com.webservice.hethongchothuevesi.dto;

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
public class NhiemVuDTO {
	private Integer idNhiemVu;
	private Integer idHopDong;
	private Integer idVeSi;
	private LocalDate ngayBatDau;
	private LocalDate ngayKetThuc;
	private String capBac;
	private String noiDung;
	private Integer soSaoDanhGia;
	private String thongTinDanhGia;
	private String trangThai;
	private LocalDateTime ngayXoa;
}
