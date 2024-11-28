package com.webservice.hethongchothuevesi.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ThongBaoDTO {
	private Integer idThongBao;
	private Integer idNhanVien;
	private Integer idDanhMucThongBao;
	private String tieuDe;
	private String noiDung;
	private LocalDateTime ngayXoa;
}
