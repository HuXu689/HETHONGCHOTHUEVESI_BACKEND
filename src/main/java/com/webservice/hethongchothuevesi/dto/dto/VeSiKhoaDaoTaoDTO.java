package com.webservice.hethongchothuevesi.dto.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class VeSiKhoaDaoTaoDTO {
	private Integer idVeSiKhoaDaoTao;
	private Integer idKhoaDaoTao;
	private Integer idVeSi;
	private LocalDate ngayHoanThanh;
	private Float diem;
	private String chungChi;
	private String trangThai;
	private LocalDateTime ngayXoa;
}
