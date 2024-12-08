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
@Table(name = "YeuCauHoTro")
public class YeuCauHoTro {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idYeuCauHoTro")
	Integer idYeuCauHoTro;

	@Column(name = "idNhanVien")
	Integer idNhanVien;

	@Column(name = "idNguoiDung")
	Integer idNguoiDung;

	@Column(name = "loaiYeuCau")
	String loaiYeuCau;

	@Column(name = "noiDungYeuCau")
	String noiDungYeuCau;

	@Column(name = "tepDinhKem")
	String tepDinhKem;

	@Column(name = "noiDungPhanHoi")
	String noiDungPhanHoi;

	@Column(name = "trangThai")
	String trangThai;

	@Column(name = "ngayXoa")
	LocalDateTime ngayXoa;
}
