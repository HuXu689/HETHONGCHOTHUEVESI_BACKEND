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
@Table(name = "BaoCaoKhanNhiemVu")
public class BaoCaoKhanNhiemVu {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idBaoCaoKhan")
	Integer idBaoCaoKhan;

	@Column(name = "idNhiemVu")
	Integer idNhiemVu;

	@Column(name = "idNhanVien")
	Integer idNhanVien;

	@Column(name = "noiDung")
	String noiDung;

	@Column(name = "mucDoKhanCap")
	String mucDoKhanCap;

	@Column(name = "trangThai")
	String trangThai;

	@Column(name = "ngayXoa")
	LocalDateTime ngayXoa;
}
