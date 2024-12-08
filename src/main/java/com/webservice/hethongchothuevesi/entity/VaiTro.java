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
@Table(name = "VaiTro")
public class VaiTro {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idVaiTro")
	Integer idVaiTro;

	@Column(name = "tenVaiTro")
	String tenVaiTro;

	@Column(name = "capBac")
	String capBac;

	@Column(name = "moTa")
	String moTa;
}
