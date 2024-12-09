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
public class ThongBaoDTO {
	private Integer idThongBao;
	private Integer idNhanVien;
	private Integer idDanhMucThongBao;
	private String tieuDe;
	private String noiDung;
	private LocalDateTime ngayXoa;
}
