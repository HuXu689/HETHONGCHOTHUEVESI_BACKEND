package com.webservice.hethongchothuevesi.entity;

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
@Table(name = "LichSuHoatDong")
public class LichSuHoatDong {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idLichSuHoatDong")
	private Integer idLichSuHoatDong;

	@Column(name = "idDoiTuong")
	private Integer idDoiTuong;

	@Column(name = "loaiDoiTuong")
	private String loaiDoiTuong;

	@Column(name = "thoiGianThucHien")
	private LocalDateTime thoiGianThucHien;

	@Column(name = "nguoiThucHien")
	private String nguoiThucHien;

	@Column(name = "hoatDong")
	private String hoatDong;

	@Column(name = "thongTinHoatDong")
	private String thongTinHoatDong;
}
