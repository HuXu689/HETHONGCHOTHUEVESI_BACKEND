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
public class DanhMucThongBaoDTO {
    private Integer idDanhMucThongBao;
    private String tenLoaiThongBao;
    private String moTa;
    private LocalDateTime ngayXoa;
}
