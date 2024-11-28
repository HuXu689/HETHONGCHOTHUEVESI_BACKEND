package com.webservice.hethongchothuevesi.entity;

import java.time.LocalDate;
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
@Table(name = "NhiemVu")
public class NhiemVu {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idNhiemVu")
	private Integer idNhiemVu;

	@Column(name = "idHopDong")
	private Integer idHopDong;

	@Column(name = "idVeSi")
	private Integer idVeSi;

	@Column(name = "ngayBatDau")
	private LocalDate ngayBatDau;

	@Column(name = "ngayKetThuc")
	private LocalDate ngayKetThuc;

	@Column(name = "capBac")
	private String capBac;

	@Column(name = "noiDung")
	private String noiDung;

	@Column(name = "soSaoDanhGia")
	private Integer soSaoDanhGia;

	@Column(name = "thongTinDanhGia")
	private String thongTinDanhGia;

	@Column(name = "trangThai")
	private String trangThai;

	@Column(name = "ngayXoa")
	private LocalDateTime ngayXoa;
}
