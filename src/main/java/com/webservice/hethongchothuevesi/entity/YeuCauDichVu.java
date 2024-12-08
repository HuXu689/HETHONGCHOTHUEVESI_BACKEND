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
@Table(name = "YeuCauDichVu")
public class YeuCauDichVu {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idYeuCauDichVu")
	Integer idYeuCauDichVu;

	@Column(name = "idNguoiDung")
	Integer idNguoiDung;

	@Column(name = "idDanhMucDichVu")
	Integer idDanhMucDichVu;

	@Column(name = "hoTenKhachHang")
	String hoTenKhachHang;

	@Column(name = "soDienThoai")
	String soDienThoai;

	@Column(name = "anh")
	String anh;

	@Column(name = "soCCCD")
	String soCccd;

	@Column(name = "diaDiem")
	String diaDiem;

	@Column(name = "soLuongVeSi")
	Integer soLuongVeSi;

	@Column(name = "ngayBatDau")
	LocalDate ngayBatDau;

	@Column(name = "ngayKetThuc")
	LocalDate ngayKetThuc;

	@Column(name = "giaTienDuKien")
	BigDecimal giaTienDuKien;

	@Column(name = "ghiChu")
	String ghiChu;

	@Column(name = "noiDungTraLoi")
	String noiDungTraLoi;

	@Column(name = "trangThai")
	String trangThai;

	@Column(name = "ngayXoa")
	LocalDateTime ngayXoa;
}
