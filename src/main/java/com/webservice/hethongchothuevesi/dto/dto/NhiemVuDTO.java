package com.webservice.hethongchothuevesi.dto.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;
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

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
	private LocalDate ngayBatDau;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
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

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm:ss")
	private LocalDateTime ngayXoa;
}
