package com.webservice.hethongchothuevesi.dto.dto;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class TepHopDongDTO {
	private Integer idTepHopDong;
	private Integer idHopDong;
	private String loaiTep;
	private String tepDinhKem;
}
