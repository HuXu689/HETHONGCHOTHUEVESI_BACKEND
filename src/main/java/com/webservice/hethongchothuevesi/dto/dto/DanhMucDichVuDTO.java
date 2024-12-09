package com.webservice.hethongchothuevesi.dto.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class DanhMucDichVuDTO {
	private Integer idDanhMucDichVu;
	private String tenDichVu;
	private String moTa;
	private BigDecimal giaDuKien;
	private LocalDateTime ngayXoa;
}
