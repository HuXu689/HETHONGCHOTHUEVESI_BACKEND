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
@Table(name = "DanhMucDichVu")
public class DanhMucDichVu {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idDanhMucDichVu")
	private Integer idDanhMucDichVu;

	@Column(name = "tenDichVu")
	private String tenDichVu;

	@Column(name = "moTa")
	private String moTa;

	@Column(name = "giaDuKien")
	private BigDecimal giaDuKien;

	@Column(name = "ngayXoa")
	private LocalDateTime ngayXoa;
}
