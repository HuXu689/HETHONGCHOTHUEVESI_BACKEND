package com.webservice.hethongchothuevesi.dto.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;
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

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
	private LocalDate ngaySinh;

	private String email;
	private String soDienThoai;
	private String soCccd;
	private String diaChi;
	private String trangThai;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm:ss")
	private LocalDateTime ngayXoa;
}
