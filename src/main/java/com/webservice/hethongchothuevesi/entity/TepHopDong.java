package com.webservice.hethongchothuevesi.entity;

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
@Table(name = "TepHopDong")
public class TepHopDong {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idTepHopDong")
	private Integer idTepHopDong;

	@Column(name = "idHopDong")
	private Integer idHopDong;

	@Column(name = "loaiTep")
	private String loaiTep;

	@Column(name = "tepDinhKem")
	private String tepDinhKem;
}
