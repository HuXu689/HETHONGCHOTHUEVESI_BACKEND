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
public class DanhMucThongBaoDTO {
	private Integer idDanhMucThongBao;
	private String tenLoaiThongBao;
	private String moTa;
	private LocalDateTime ngayXoa;
}
