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
@Table(name = "VeSiKhoaDaoTao")
public class VeSiKhoaDaoTao {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idVeSiKhoaDaoTao")
	private Integer idVeSiKhoaDaoTao;

	@Column(name = "idKhoaDaoTao")
	private Integer idKhoaDaoTao;

	@Column(name = "idVeSi")
	private Integer idVeSi;

	@Column(name = "ngayHoanThanh")
	private LocalDate ngayHoanThanh;

	@Column(name = "diem")
	private Float diem;

	@Column(name = "chungChi")
	private String chungChi;

	@Column(name = "trangThai")
	private String trangThai;

	@Column(name = "ngayXoa")
	private LocalDateTime ngayXoa;
}
