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
public class HopDongDTO {
	private Integer idHopDong;
	private Integer idYeuCauDichVu;
	private String hoTenKhachHang;
	private String soDienThoai;
	private String anh;
	private String soCccd;
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
