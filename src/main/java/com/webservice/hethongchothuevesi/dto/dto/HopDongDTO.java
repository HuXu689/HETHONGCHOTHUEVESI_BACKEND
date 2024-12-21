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
    private Integer idHopDong;
    private Integer idYeuCauDichVu;
    private String tenDichVu;
    private String hoTenKhachHang;
    private String soDienThoai;
    private String anh;
    private String soCccd;
    private String diaDiem;
    private Integer soLuongVeSi;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm:ss")
    private LocalDateTime thoiGianBatDau;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm:ss")
    private LocalDateTime thoiGianKetThuc;

    private BigDecimal tongChiPhi;
    private String ghiChu;
    private Integer soSaoDanhGia;
    private String thongTinDanhGia;
    private String trangThai;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm:ss")
    private LocalDateTime ngayXoa;
}
