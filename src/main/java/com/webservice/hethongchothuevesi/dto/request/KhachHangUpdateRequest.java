package com.webservice.hethongchothuevesi.dto.request;

import jakarta.validation.constraints.Size;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class KhachHangUpdateRequest {
    @Size(min = 8, message = "MATKHAU_INVALID")
    String matKhau;
    String anhDaiDien;
    String gioiTinh;
    LocalDate ngaySinh;
    String email;
    String soDienThoai;
    String hoTen;
    String soCccd;
    String diaChi;
}
