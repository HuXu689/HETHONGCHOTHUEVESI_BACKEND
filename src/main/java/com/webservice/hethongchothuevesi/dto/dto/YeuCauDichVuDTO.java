package com.webservice.hethongchothuevesi.dto.dto;

import java.math.BigDecimal;
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
public class YeuCauDichVuDTO {
	private Integer idYeuCauDichVu;
	private Integer idNguoiDung;
	private Integer idDanhMucDichVu;
	private String hoTenKhachHang;
	private String soDienThoai;
	private String anh;
	private String soCccd;
	private String diaDiem;
	private Integer soLuongVeSi;
	private LocalDate ngayBatDau;
	private LocalDate ngayKetThuc;
	private BigDecimal giaTienDuKien;
	private String ghiChu;
	private String noiDungTraLoi;
	private String trangThai;
	private LocalDateTime ngayXoa;
}
