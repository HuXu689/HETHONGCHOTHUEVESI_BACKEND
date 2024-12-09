package com.webservice.hethongchothuevesi.dto.dto;

import java.time.LocalDateTime;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ThongBaoNguoiDungDTO {
	private Integer idThongBaoNguoiDung;
	private Integer idThongBao;
	private Integer idNguoiDung;
	private LocalDateTime thoiGianDoc;
	private LocalDateTime ngayXoa;
}
