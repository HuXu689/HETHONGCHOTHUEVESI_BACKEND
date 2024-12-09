package com.webservice.hethongchothuevesi.dto.dto;

import java.time.LocalDateTime;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class HoSoDTO {
	private Integer idHoSo;
	private Integer idVeSi;
	private String loaiHoSo;
	private String tepDinhKem;
	private LocalDateTime ngayXoa;
}
