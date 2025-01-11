package com.webservice.hethongchothuevesi.dto.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class NguoiDungDTO {
    Integer idNguoiDung;
    String tenDangNhap;
    String matKhau;
    String idAnhDaiDien;
    String anhDaiDien;
    String hoTen;
    String gioiTinh;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    LocalDate ngaySinh;

    String email;
    String soDienThoai;
    String soCccd;
    String diaChi;
    String trangThai;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm:ss")
    LocalDateTime ngayXoa;
}
