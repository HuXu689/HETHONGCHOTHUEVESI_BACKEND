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
public class BaoCaoKhanNhiemVuDTO {
	private Integer idBaoCaoKhan;
	private Integer idNhiemVu;
	private Integer idNhanVien;
	private String noiDung;
	private String mucDoKhanCap;
	private String trangThai;
	private LocalDateTime ngayXoa;
}
