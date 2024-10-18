package com.webservice.hethongchothuevesi.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class HoSoDTO {
    private Integer idHoSo;
    private Integer idVeSi;
    private String loaiHoSo;
    private String tepDinhKem;
    private LocalDateTime ngayXoa;
}
