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
public class KhoaDaoTaoDTO {
	private Integer idKhoaDaoTao;
	private Integer idDanhMucKhoaDaoTao;
	private String tenKhoaDaoTao;
	private String diaDiem;
	private LocalDate ngayBatDau;
	private LocalDate ngayKetThuc;
	private String moTa;
	private String trangThai;
	private LocalDateTime ngayXoa;
}
