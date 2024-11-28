package com.webservice.hethongchothuevesi.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class KhachHangDTO {
	private Integer idKhachHang;
	private String tenDangNhap;
	private String anhDaiDien;
	private String gioiTinh;
	private LocalDate ngaySinh;
	private String email;
	private String soDienThoai;
	private String hoTen;
	private String soCccd;
	private String diaChi;
	private String trangThai;
	private LocalDateTime ngayXoa;
}
