package com.webservice.hethongchothuevesi.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class HopDongDTO {
	private Integer idHopDong;
	private Integer idYeuCauDichVu;
	private String diaDiem;
	private Integer soLuongVeSi;
	private LocalDateTime thoiGianBatDau;
	private LocalDateTime thoiGianKetThuc;
	private BigDecimal tongChiPhi;
	private String ghiChu;
	private Integer soSaoDanhGia;
	private String thongTinDanhGia;
	private String trangThai;
	private LocalDateTime ngayXoa;
}
