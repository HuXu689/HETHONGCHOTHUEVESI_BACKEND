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
public class YeuCauHoTroDTO {
	private Integer idYeuCauHoTro;
	private Integer idNhanVien;
	private Integer idNguoiDung;
	private String loaiYeuCau;
	private String noiDungYeuCau;
	private String tepDinhKem;
	private String noiDungPhanHoi;
	private String trangThai;
	private LocalDateTime ngayXoa;
}
