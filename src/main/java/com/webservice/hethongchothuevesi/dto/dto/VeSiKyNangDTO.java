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
public class VeSiKyNangDTO {
	private Integer idVeSiKyNang;
	private Integer idDanhMucKyNang;
	private Integer idVeSi;
	private String capBac;
	private String danhGia;
	private LocalDateTime ngayXoa;
}
