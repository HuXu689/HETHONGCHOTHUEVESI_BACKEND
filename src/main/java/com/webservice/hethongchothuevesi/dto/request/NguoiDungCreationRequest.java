package com.webservice.hethongchothuevesi.dto.request;

import com.fasterxml.jackson.annotation.JsonFormat;
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
public class NguoiDungCreationRequest {
    @Size(min = 6, message = "TENDANGNHAP_INVALID")
    private String tenDangNhap;

    @Size(min = 8, message = "MATKHAU_INVALID")
    private String matKhau;

    private String anhDaiDien;
    private String gioiTinh;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    private LocalDate ngaySinh;
    private String email;
    private String soDienThoai;
    private String hoTen;
    private String soCccd;
    private String diaChi;
}
