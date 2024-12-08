package com.webservice.hethongchothuevesi.entity;

import java.math.BigDecimal;
import java.time.LocalDate;
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
@Table(name = "VeSi")
public class VeSi {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idVeSi")
	Integer idVeSi;

	@Column(name = "kinhNghiem")
	Integer kinhNghiem;

	@Column(name = "thongTinDanhGiaChung")
	String thongTinDanhGiaChung;

	@Column(name = "ngayBatDauLam")
	LocalDate ngayBatDauLam;

	@Column(name = "capBac")
	String capBac;

	@Column(name = "ngayLenCap")
	LocalDate ngayLenCap;

	@Column(name = "luong")
	BigDecimal luong;

	@Column(name = "trangThai")
	String trangThai;

	@Column(name = "ngayXoa")
	LocalDateTime ngayXoa;
}
