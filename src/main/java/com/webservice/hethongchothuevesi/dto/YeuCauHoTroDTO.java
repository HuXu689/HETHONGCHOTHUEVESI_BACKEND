package com.webservice.hethongchothuevesi.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class YeuCauHoTroDTO {
	private Integer idYeuCauHoTro;
	private Integer idNhanVien;
	private Integer idNguoiYeuCau;
	private String vaiTroNguoiYeuCau;
	private String loaiYeuCau;
	private String noiDungYeuCau;
	private String tepDinhKem;
	private String noiDungPhanHoi;
	private String trangThai;
	private LocalDateTime ngayXoa;
}
