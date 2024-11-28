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
public class DanhMucKhoaDaoTaoDTO {
	private Integer idDanhMucKhoaDaoTao;
	private String tenKhoaDaoTao;
	private String moTa;
	private LocalDateTime ngayXoa;
}
