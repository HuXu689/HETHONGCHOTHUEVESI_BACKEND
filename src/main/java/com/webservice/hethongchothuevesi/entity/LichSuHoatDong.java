package com.webservice.hethongchothuevesi.entity;

import java.time.LocalDateTime;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name = "LichSuHoatDong")
public class LichSuHoatDong {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idLichSuHoatDong")
	Integer idLichSuHoatDong;

	@Column(name = "idNguoiDung")
	Integer idNguoiDung;

	@Column(name = "idDoiTuong")
	Integer idDoiTuong;

	@Column(name = "loaiDoiTuong")
	String loaiDoiTuong;

	@Column(name = "thoiGianThucHien")
	LocalDateTime thoiGianThucHien;

	@Column(name = "hoatDong")
	String hoatDong;

	@Column(name = "thongTinHoatDong")
	String thongTinHoatDong;
}
