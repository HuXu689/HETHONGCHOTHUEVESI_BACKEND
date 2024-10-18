package com.webservice.hethongchothuevesi.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class VeSiKhoaDaoTaoDTO {
    private Integer idVeSiKhoaDaoTao;
    private Integer idKhoaDaoTao;
    private Integer idVeSi;
    private LocalDate ngayHoanThanh;
    private Float diem;
    private String chungChi;
    private String trangThai;
    private LocalDateTime ngayXoa;
}
