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
    Integer idYeuCauDichVu;
    Integer idNguoiDung;
    Integer idDanhMucDichVu;
    String tenDanhMucDichVu;
    String hoTenKhachHang;
    String soDienThoai;
    String idAnh;
    String anh;
    String soCccd;
    String diaDiem;
    Integer soLuongVeSi;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    LocalDate ngayBatDau;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    LocalDate ngayKetThuc;

    BigDecimal giaTienDuKien;
    String ghiChu;
    String noiDungTraLoi;
    String trangThai;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm:ss")
    LocalDateTime ngayXoa;
}
