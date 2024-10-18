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
public class YeuCauDichVuDTO {
    private Integer idYeuCauDichVu;
    private Integer idKhachHang;
    private Integer idDanhMucDichVu;
    private String diaDiem;
    private Integer soLuongVeSi;
    private LocalDate ngayBatDau;
    private LocalDate ngayKetThuc;
    private BigDecimal giaTienDuKien;
    private String ghiChu;
    private String noiDungTraLoi;
    private String trangThai;
    private LocalDateTime ngayXoa;
}
