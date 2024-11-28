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
@Table(name = "ThongBao")
public class ThongBao {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idThongBao")
	private Integer idThongBao;

	@Column(name = "idNhanVien")
	private Integer idNhanVien;

	@Column(name = "idDanhMucThongBao")
	private Integer idDanhMucThongBao;

	@Column(name = "tieuDe")
	private String tieuDe;

	@Column(name = "noiDung")
	private String noiDung;

	@Column(name = "ngayXoa")
	private LocalDateTime ngayXoa;
}
