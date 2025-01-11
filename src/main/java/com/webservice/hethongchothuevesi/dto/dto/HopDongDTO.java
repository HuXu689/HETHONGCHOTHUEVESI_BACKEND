package com.webservice.hethongchothuevesi.dto.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class HopDongDTO {
    Integer idHopDong;
    Integer idYeuCauDichVu;
    String tenDichVu;
    String hoTenKhachHang;
    String soDienThoai;
    String idAnh;
    String anh;
    String soCccd;
    String diaDiem;
    Integer soLuongVeSi;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm:ss")
    LocalDateTime thoiGianBatDau;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm:ss")
    LocalDateTime thoiGianKetThuc;

    BigDecimal tongChiPhi;
    String ghiChu;
    Integer soSaoDanhGia;
    String thongTinDanhGia;
    String trangThai;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm:ss")
    LocalDateTime ngayXoa;
}
