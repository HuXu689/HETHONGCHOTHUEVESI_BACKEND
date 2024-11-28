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
public class HoSoDTO {
	private Integer idHoSo;
	private Integer idVeSi;
	private String loaiHoSo;
	private String tepDinhKem;
	private LocalDateTime ngayXoa;
}
