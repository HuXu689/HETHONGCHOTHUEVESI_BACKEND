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
public class DanhMucKhoaDaoTaoDTO {
    private Integer idDanhMucKhoaDaoTao;
    private String tenKhoaDaoTao;
    private String moTa;
    private LocalDateTime ngayXoa;
}
