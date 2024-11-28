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
@Table(name = "KhoaDaoTao")
public class KhoaDaoTao {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idKhoaDaoTao")
	private Integer idKhoaDaoTao;

	@Column(name = "idDanhMucKhoaDaoTao")
	private Integer idDanhMucKhoaDaoTao;

	@Column(name = "tenKhoaDaoTao")
	private String tenKhoaDaoTao;

	@Column(name = "diaDiem")
	private String diaDiem;

	@Column(name = "ngayBatDau")
	private LocalDate ngayBatDau;

	@Column(name = "ngayKetThuc")
	private LocalDate ngayKetThuc;

	@Column(name = "moTa")
	private String moTa;

	@Column(name = "trangThai")
	private String trangThai;

	@Column(name = "ngayXoa")
	private LocalDateTime ngayXoa;
}
