package com.webservice.hethongchothuevesi.entity;

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
@Table(name = "KhoaDaoTao")
public class KhoaDaoTao {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idKhoaDaoTao")
	Integer idKhoaDaoTao;

	@Column(name = "idDanhMucKhoaDaoTao")
	Integer idDanhMucKhoaDaoTao;

	@Column(name = "tenKhoaDaoTao")
	String tenKhoaDaoTao;

	@Column(name = "diaDiem")
	String diaDiem;

	@Column(name = "ngayBatDau")
	LocalDate ngayBatDau;

	@Column(name = "ngayKetThuc")
	LocalDate ngayKetThuc;

	@Column(name = "moTa")
	String moTa;

	@Column(name = "trangThai")
	String trangThai;

	@Column(name = "ngayXoa")
	LocalDateTime ngayXoa;
}
