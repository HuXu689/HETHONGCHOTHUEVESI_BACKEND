package com.webservice.hethongchothuevesi.dto.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
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

	private String hoTenNguoiDung;
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

	// Tính soSao trung bình từ các trường đánh giá
	@JsonProperty("soSao")
	public Double getSoSao() {
		int sum = 0;
		int count = 0;

		if (danhGiaKyNangChuyenMon != null) {
			sum += danhGiaKyNangChuyenMon;
			count++;
		}
		if (danhGiaXuLyTinhHuong != null) {
			sum += danhGiaXuLyTinhHuong;
			count++;
		}
		if (danhGiaThaiDoDaoDuc != null) {
			sum += danhGiaThaiDoDaoDuc;
			count++;
		}
		if (danhGiaGiaoTiep != null) {
			sum += danhGiaGiaoTiep;
			count++;
		}
		if (danhGiaNgoaiHinh != null) {
			sum += danhGiaNgoaiHinh;
			count++;
		}

		return count > 0 ? (double) sum / count : null; // Trả về null nếu không có giá trị đánh giá
	}

	// Constructor mới kèm hoTenNguoiDung
	public NhiemVuDTO(
			Integer idNhiemVu,
			Integer idHopDong,
			Integer idVeSi,
			LocalDate ngayBatDau,
			LocalDate ngayKetThuc,
			String capBac,
			String noiDung,
			Integer danhGiaKyNangChuyenMon,
			Integer danhGiaXuLyTinhHuong,
			Integer danhGiaThaiDoDaoDuc,
			Integer danhGiaGiaoTiep,
			Integer danhGiaNgoaiHinh,
			String thongTinDanhGia,
			String trangThai,
			LocalDateTime ngayXoa,
			String hoTenNguoiDung) {
		this.idNhiemVu = idNhiemVu;
		this.idHopDong = idHopDong;
		this.idVeSi = idVeSi;
		this.ngayBatDau = ngayBatDau;
		this.ngayKetThuc = ngayKetThuc;
		this.capBac = capBac;
		this.noiDung = noiDung;
		this.danhGiaKyNangChuyenMon = danhGiaKyNangChuyenMon;
		this.danhGiaXuLyTinhHuong = danhGiaXuLyTinhHuong;
		this.danhGiaThaiDoDaoDuc = danhGiaThaiDoDaoDuc;
		this.danhGiaGiaoTiep = danhGiaGiaoTiep;
		this.danhGiaNgoaiHinh = danhGiaNgoaiHinh;
		this.thongTinDanhGia = thongTinDanhGia;
		this.trangThai = trangThai;
		this.ngayXoa = ngayXoa;
		this.hoTenNguoiDung = hoTenNguoiDung; // Gán hoTenNguoiDung
	}

	// Constructor không bao gồm hoTenNguoiDungNguoiDung
	public NhiemVuDTO(
			Integer idNhiemVu,
			Integer idHopDong,
			Integer idVeSi,
			LocalDate ngayBatDau,
			LocalDate ngayKetThuc,
			String capBac,
			String noiDung,
			Integer danhGiaKyNangChuyenMon,
			Integer danhGiaXuLyTinhHuong,
			Integer danhGiaThaiDoDaoDuc,
			Integer danhGiaGiaoTiep,
			Integer danhGiaNgoaiHinh,
			String thongTinDanhGia,
			String trangThai,
			LocalDateTime ngayXoa) {
		this.idNhiemVu = idNhiemVu;
		this.idHopDong = idHopDong;
		this.idVeSi = idVeSi;
		this.ngayBatDau = ngayBatDau;
		this.ngayKetThuc = ngayKetThuc;
		this.capBac = capBac;
		this.noiDung = noiDung;
		this.danhGiaKyNangChuyenMon = danhGiaKyNangChuyenMon;
		this.danhGiaXuLyTinhHuong = danhGiaXuLyTinhHuong;
		this.danhGiaThaiDoDaoDuc = danhGiaThaiDoDaoDuc;
		this.danhGiaGiaoTiep = danhGiaGiaoTiep;
		this.danhGiaNgoaiHinh = danhGiaNgoaiHinh;
		this.thongTinDanhGia = thongTinDanhGia;
		this.trangThai = trangThai;
		this.ngayXoa = ngayXoa;
		// Không bao gồm hoTenNguoiDungNguoiDung
	}
}
