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
public class NguoiDungDTO {
	private Integer idNguoiDung;
	private String tenDangNhap;
	private String matKhau;
	private String anhDaiDien;
	private String hoTen;
	private String gioiTinh;
	private LocalDate ngaySinh;
	private String email;
	private String soDienThoai;
	private String soCccd;
	private String diaChi;
	private String trangThai;
	private LocalDateTime ngayXoa;
}
