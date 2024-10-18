package com.webservice.hethongchothuevesi.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class NhanVienDTO {
    private Integer idNhanVien;
    private Integer idVaiTro;
    private String tenDangNhap;
    private String matKhau;
    private String anhDaiDien;
    private String hoTen;
    private String gioiTinh;
    private LocalDate ngaySinh;
    private String email;
    private String diaChi;
    private String soDienThoai;
    private LocalDate ngayBatDauLam;
    private String capBac;
    private LocalDate ngayLenCap;
    private BigDecimal luong;
    private String trangThai;
    private LocalDateTime ngayXoa;
}
