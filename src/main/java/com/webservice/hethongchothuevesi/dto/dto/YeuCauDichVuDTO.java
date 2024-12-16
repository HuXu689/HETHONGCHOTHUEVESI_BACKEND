package com.webservice.hethongchothuevesi.dto.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class YeuCauDichVuDTO {
    private Integer idYeuCauDichVu;
    private Integer idNguoiDung;
    private Integer idDanhMucDichVu;
    private String tenDanhMucDichVu;
    private String hoTenKhachHang;
    private String soDienThoai;
    private String anh;
    private String soCccd;
    private String diaDiem;
    private Integer soLuongVeSi;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    private LocalDate ngayBatDau;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    private LocalDate ngayKetThuc;
    private BigDecimal giaTienDuKien;
    private String ghiChu;
    private String noiDungTraLoi;
    private String trangThai;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm:ss")
    private LocalDateTime ngayXoa;
}
