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
public class DanhMucKyNangDTO {
	private Integer idDanhMucKyNang;
	private String tenKyNang;
	private String moTa;
	private LocalDateTime ngayXoa;
}
