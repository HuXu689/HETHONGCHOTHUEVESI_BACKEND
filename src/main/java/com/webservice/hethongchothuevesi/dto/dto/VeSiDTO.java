package com.webservice.hethongchothuevesi.dto.dto;

import java.math.BigDecimal;
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
public class VeSiDTO {
	Integer idVeSi;
	Integer idNguoiDung;
	String hoTen;
	Integer kinhNghiem;
	String thongTinDanhGiaChung;
	String emailVeSi;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
	LocalDate ngaySinhVeSi;

	String gioiTinhVeSi;
	String sdtVeSi;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
	LocalDate ngayBatDauLam;

	String capBac;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
	LocalDate ngayLenCap;

	BigDecimal luong;
	String trangThai;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm:ss")
	LocalDateTime ngayXoa;

	// Các trường trung bình đánh giá (đã thêm ở bước trước)
	Double soSao; // Trung bình tổng quát
	Double trungBinhKyNangChuyenMon;
	Double trungBinhXuLyTinhHuong;
	Double trungBinhThaiDoDaoDuc;
	Double trungBinhGiaoTiep;
	Double trungBinhNgoaiHinh;

	// Constructor phù hợp với các phương thức JPQL hiện tại (không có giá trị trung bình)
	public VeSiDTO(
			Integer idVeSi,
			Integer idNguoiDung,
			String hoTen,
			Integer kinhNghiem,
			String thongTinDanhGiaChung,
			String emailVeSi,
			LocalDate ngaySinhVeSi,
			String gioiTinhVeSi,
			String sdtVeSi,
			LocalDate ngayBatDauLam,
			String capBac,
			LocalDate ngayLenCap,
			BigDecimal luong,
			String trangThai,
			LocalDateTime ngayXoa) {
		this.idVeSi = idVeSi;
		this.idNguoiDung = idNguoiDung;
		this.hoTen = hoTen;
		this.kinhNghiem = kinhNghiem;
		this.thongTinDanhGiaChung = thongTinDanhGiaChung;
		this.emailVeSi = emailVeSi;
		this.ngaySinhVeSi = ngaySinhVeSi;
		this.gioiTinhVeSi = gioiTinhVeSi;
		this.sdtVeSi = sdtVeSi;
		this.ngayBatDauLam = ngayBatDauLam;
		this.capBac = capBac;
		this.ngayLenCap = ngayLenCap;
		this.luong = luong;
		this.trangThai = trangThai;
		this.ngayXoa = ngayXoa;
	}

	// Constructor phù hợp với phương thức JPQL có thêm các giá trị trung bình đánh giá
	public VeSiDTO(
			Integer idVeSi,
			Integer idNguoiDung,
			String hoTen,
			Integer kinhNghiem,
			String thongTinDanhGiaChung,
			String emailVeSi,
			LocalDate ngaySinhVeSi,
			String gioiTinhVeSi,
			String sdtVeSi,
			LocalDate ngayBatDauLam,
			String capBac,
			LocalDate ngayLenCap,
			BigDecimal luong,
			String trangThai,
			LocalDateTime ngayXoa,
			Double trungBinhKyNangChuyenMon,
			Double trungBinhXuLyTinhHuong,
			Double trungBinhThaiDoDaoDuc,
			Double trungBinhGiaoTiep,
			Double trungBinhNgoaiHinh) {
		this(
				idVeSi,
				idNguoiDung,
				hoTen,
				kinhNghiem,
				thongTinDanhGiaChung,
				emailVeSi,
				ngaySinhVeSi,
				gioiTinhVeSi,
				sdtVeSi,
				ngayBatDauLam,
				capBac,
				ngayLenCap,
				luong,
				trangThai,
				ngayXoa);
		this.trungBinhKyNangChuyenMon = trungBinhKyNangChuyenMon;
		this.trungBinhXuLyTinhHuong = trungBinhXuLyTinhHuong;
		this.trungBinhThaiDoDaoDuc = trungBinhThaiDoDaoDuc;
		this.trungBinhGiaoTiep = trungBinhGiaoTiep;
		this.trungBinhNgoaiHinh = trungBinhNgoaiHinh;
		this.soSao = calculateSoSao();
	}

	/**
	 * Tính giá trị trung bình tổng quát soSao dựa trên các giá trị trung bình đánh giá cụ thể
	 */
	private Double calculateSoSao() {
		int count = 0;
		double sum = 0.0;

		if (trungBinhKyNangChuyenMon != null) {
			sum += trungBinhKyNangChuyenMon;
			count++;
		}
		if (trungBinhXuLyTinhHuong != null) {
			sum += trungBinhXuLyTinhHuong;
			count++;
		}
		if (trungBinhThaiDoDaoDuc != null) {
			sum += trungBinhThaiDoDaoDuc;
			count++;
		}
		if (trungBinhGiaoTiep != null) {
			sum += trungBinhGiaoTiep;
			count++;
		}
		if (trungBinhNgoaiHinh != null) {
			sum += trungBinhNgoaiHinh;
			count++;
		}

		return count > 0 ? sum / count : null;
	}
}
