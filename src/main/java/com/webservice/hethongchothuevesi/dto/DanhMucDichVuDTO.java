package com.webservice.hethongchothuevesi.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DanhMucDichVuDTO {
    private Integer idDanhMucDichVu;
    private String tenDichVu;
    private String moTa;
    private BigDecimal giaDuKien;
    private LocalDateTime ngayXoa;
}
