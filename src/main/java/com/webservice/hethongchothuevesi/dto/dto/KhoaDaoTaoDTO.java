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
public class KhoaDaoTaoDTO {
	private Integer idKhoaDaoTao;
	private Integer idDanhMucKhoaDaoTao;
	private String tenKhoaDaoTao;
	private String diaDiem;
	private LocalDate ngayBatDau;
	private LocalDate ngayKetThuc;
	private String moTa;
	private String trangThai;
	private LocalDateTime ngayXoa;
}
