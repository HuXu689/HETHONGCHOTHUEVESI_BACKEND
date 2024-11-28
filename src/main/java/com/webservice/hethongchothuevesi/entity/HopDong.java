package com.webservice.hethongchothuevesi.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "HopDong")
public class HopDong {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idHopDong")
	private Integer idHopDong;

	@Column(name = "idYeuCauDichVu")
	private Integer idYeuCauDichVu;

	@Column(name = "diaDiem")
	private String diaDiem;

	@Column(name = "soLuongVeSi")
	private Integer soLuongVeSi;

	@Column(name = "thoiGianBatDau")
	private LocalDateTime thoiGianBatDau;

	@Column(name = "thoiGianKetThuc")
	private LocalDateTime thoiGianKetThuc;

	@Column(name = "tongChiPhi")
	private BigDecimal tongChiPhi;

	@Column(name = "ghiChu")
	private String ghiChu;

	@Column(name = "soSaoDanhGia")
	private Integer soSaoDanhGia;

	@Column(name = "thongTinDanhGia")
	private String thongTinDanhGia;

	@Column(name = "trangThai")
	private String trangThai;

	@Column(name = "ngayXoa")
	private LocalDateTime ngayXoa;
}
