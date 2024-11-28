package com.webservice.hethongchothuevesi.entity;

import java.math.BigDecimal;
import java.time.LocalDate;
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
@Table(name = "HoaDon")
public class HoaDon {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idHoaDon")
	private Integer idHoaDon;

	@Column(name = "idHopDong")
	private Integer idHopDong;

	@Column(name = "ngayLap")
	private LocalDate ngayLap;

	@Column(name = "tongTien")
	private BigDecimal tongTien;

	@Column(name = "phuongThucThanhToan")
	private String phuongThucThanhToan;

	@Column(name = "trangThai")
	private String trangThai;

	@Column(name = "ngayXoa")
	private LocalDateTime ngayXoa;
}
