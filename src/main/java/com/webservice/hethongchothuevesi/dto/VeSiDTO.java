package com.webservice.hethongchothuevesi.dto;

import java.math.BigDecimal;
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
public class VeSiDTO {
	private Integer idVeSi;
	private String tenDangNhap;
	private String matKhau;
	private String anhDaiDien;
	private String hoTen;
	private String gioiTinh;
	private LocalDate ngaySinh;
	private String diaChi;
	private String soDienThoai;
	private String email;
	private Integer kinhNghiem;
	private String thongTinDanhGiaChung;
	private LocalDate ngayBatDauLam;
	private String capBac;
	private LocalDate ngayLenCap;
	private BigDecimal luong;
	private String trangThai;
	private LocalDateTime ngayXoa;
}
