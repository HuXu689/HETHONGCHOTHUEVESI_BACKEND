package com.webservice.hethongchothuevesi.dto.response;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class NguoiDungResponse {
	Integer idNguoiDung;
	String tenDangNhap;
	String anhDaiDien;
	String gioiTinh;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
	LocalDate ngaySinh;

	String email;
	String soDienThoai;
	String hoTen;
	String soCccd;
	String diaChi;
	String trangThai;
	String role;
}
