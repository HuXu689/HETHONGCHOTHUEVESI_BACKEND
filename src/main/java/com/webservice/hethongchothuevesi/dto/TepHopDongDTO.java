package com.webservice.hethongchothuevesi.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TepHopDongDTO {
	private Integer idTepHopDong;
	private Integer idHopDong;
	private String loaiTep;
	private String tepDinhKem;
}
