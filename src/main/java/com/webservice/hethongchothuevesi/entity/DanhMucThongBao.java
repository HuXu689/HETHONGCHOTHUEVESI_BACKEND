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
@Table(name = "DanhMucThongBao")
public class DanhMucThongBao {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idDanhMucThongBao")
	private Integer idDanhMucThongBao;

	@Column(name = "tenLoaiThongBao")
	private String tenLoaiThongBao;

	@Column(name = "moTa")
	private String moTa;

	@Column(name = "ngayXoa")
	private LocalDateTime ngayXoa;
}
