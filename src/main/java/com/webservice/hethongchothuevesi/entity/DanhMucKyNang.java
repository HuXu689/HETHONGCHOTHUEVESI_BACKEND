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
@Table(name = "DanhMucKyNang")
public class DanhMucKyNang {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idDanhMucKyNang")
	private Integer idDanhMucKyNang;

	@Column(name = "tenKyNang")
	private String tenKyNang;

	@Column(name = "moTa")
	private String moTa;

	@Column(name = "ngayXoa")
	private LocalDateTime ngayXoa;
}
