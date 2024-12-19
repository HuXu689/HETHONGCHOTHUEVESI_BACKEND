package com.webservice.hethongchothuevesi.dto.dto;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ThongBaoDTO {
	private Integer idThongBao;
	private Integer idNhanVien;
	private Integer idDanhMucThongBao;
	private String tieuDe;
	private String noiDung;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm:ss")
	private LocalDateTime ngayXoa;
}
