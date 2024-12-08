package com.webservice.hethongchothuevesi.dto.request;

import java.time.LocalDate;

import com.webservice.hethongchothuevesi.validator.DobConstraint;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class NguoiDungUpdateRequest {
	String anhDaiDien;
	String gioiTinh;

	@DobConstraint(min = 18)
	LocalDate ngaySinh;

	String email;
	String soDienThoai;
	String hoTen;
	String soCccd;
	String diaChi;
}
