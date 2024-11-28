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
@Table(name = "YeuCauHoTro")
public class YeuCauHoTro {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idYeuCauHoTro")
	private Integer idYeuCauHoTro;

	@Column(name = "idNhanVien")
	private Integer idNhanVien;

	@Column(name = "idNguoiYeuCau")
	private Integer idNguoiYeuCau;

	@Column(name = "vaiTroNguoiYeuCau")
	private String vaiTroNguoiYeuCau;

	@Column(name = "loaiYeuCau")
	private String loaiYeuCau;

	@Column(name = "noiDungYeuCau")
	private String noiDungYeuCau;

	@Column(name = "tepDinhKem")
	private String tepDinhKem;

	@Column(name = "noiDungPhanHoi")
	private String noiDungPhanHoi;

	@Column(name = "trangThai")
	private String trangThai;

	@Column(name = "ngayXoa")
	private LocalDateTime ngayXoa;
}
