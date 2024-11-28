package com.webservice.hethongchothuevesi.dto.request;

import java.time.LocalDate;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class KhachHangUpdateRequest {
	String anhDaiDien;
	String gioiTinh;
	LocalDate ngaySinh;
	String email;
	String soDienThoai;
	String hoTen;
	String soCccd;
	String diaChi;
}
