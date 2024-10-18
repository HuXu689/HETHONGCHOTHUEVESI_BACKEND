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
public class KhachHangCreationRequest {
    private String tenDangNhap;
    private String matKhau;
    private String anhDaiDien;
    private String gioiTinh;
    private LocalDate ngaySinh;
    private String email;
    private String soDienThoai;
    private String hoTen;
    private String soCccd;
    private String diaChi;
}
