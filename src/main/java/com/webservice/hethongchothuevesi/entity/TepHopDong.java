package com.webservice.hethongchothuevesi.entity;

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
