package com.webservice.hethongchothuevesi.entity;

import java.math.BigDecimal;
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
@Table(name = "DanhMucDichVu")
public class DanhMucDichVu {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idDanhMucDichVu")
	Integer idDanhMucDichVu;

	@Column(name = "tenDichVu")
	String tenDichVu;

	@Column(name = "moTa")
	String moTa;

	@Column(name = "giaDuKien")
	BigDecimal giaDuKien;

	@Column(name = "ngayXoa")
	LocalDateTime ngayXoa;
}
