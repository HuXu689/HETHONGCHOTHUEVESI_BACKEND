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
@Table(name = "DanhMucThongBao")
public class DanhMucThongBao {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idDanhMucThongBao")
	Integer idDanhMucThongBao;

	@Column(name = "tenLoaiThongBao")
	String tenLoaiThongBao;

	@Column(name = "moTa")
	String moTa;

	@Column(name = "ngayXoa")
	LocalDateTime ngayXoa;
}
