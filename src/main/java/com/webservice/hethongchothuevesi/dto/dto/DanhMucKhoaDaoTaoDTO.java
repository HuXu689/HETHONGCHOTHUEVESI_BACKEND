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
public class DanhMucKhoaDaoTaoDTO {
	private Integer idDanhMucKhoaDaoTao;
	private String tenKhoaDaoTao;
	private String moTa;
	private LocalDateTime ngayXoa;
}
