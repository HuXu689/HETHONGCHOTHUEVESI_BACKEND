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
    String tenDangNhap;

    @Size(min = 8, message = "MATKHAU_INVALID")
    String matKhau;

    String idAnhDaiDien;
    String anhDaiDien;
    String gioiTinh;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    LocalDate ngaySinh;

    String email;
    String soDienThoai;
    String hoTen;
    String soCccd;
    String diaChi;
}
