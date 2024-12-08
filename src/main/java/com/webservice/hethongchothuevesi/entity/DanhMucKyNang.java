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
@Table(name = "DanhMucKyNang")
public class DanhMucKyNang {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idDanhMucKyNang")
	Integer idDanhMucKyNang;

	@Column(name = "tenKyNang")
	String tenKyNang;

	@Column(name = "moTa")
	String moTa;

	@Column(name = "ngayXoa")
	LocalDateTime ngayXoa;
}
