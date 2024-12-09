package com.webservice.hethongchothuevesi.dto.dto;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class NguoiDungVaiTroDTO {
	private Integer idNguoiDungVaiTro;
	private Integer idNguoiDung;
	private Integer idVaiTro;
}
