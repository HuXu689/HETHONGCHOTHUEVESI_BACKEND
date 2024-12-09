package com.webservice.hethongchothuevesi.dto.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class NhiemVuDTO {
	private Integer idNhiemVu;
	private Integer idHopDong;
	private Integer idVeSi;
	private LocalDate ngayBatDau;
	private LocalDate ngayKetThuc;
	private String capBac;
	private String noiDung;
	private Integer danhGiaKyNangChuyenMon;
	private Integer danhGiaXuLyTinhHuong;
	private Integer danhGiaThaiDoDaoDuc;
	private Integer danhGiaGiaoTiep;
	private Integer danhGiaNgoaiHinh;
	private String thongTinDanhGia;
	private String trangThai;
	private LocalDateTime ngayXoa;
}
