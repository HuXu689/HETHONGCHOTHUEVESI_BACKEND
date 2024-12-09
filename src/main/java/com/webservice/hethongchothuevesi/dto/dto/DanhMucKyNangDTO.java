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
public class DanhMucKyNangDTO {
	private Integer idDanhMucKyNang;
	private String tenKyNang;
	private String moTa;
	private LocalDateTime ngayXoa;
}
