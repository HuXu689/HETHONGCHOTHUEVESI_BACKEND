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
public class VeSiKyNangDTO {
	private Integer idVeSiKyNang;
	private Integer idDanhMucKyNang;
	private Integer idVeSi;
	private String capBac;
	private String danhGia;
	private LocalDateTime ngayXoa;
}
