package com.webservice.hethongchothuevesi.dto.dto;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class VaiTroDTO {
	private Integer idVaiTro;
	private String tenVaiTro;
	private String capBac;
	private String moTa;
}
