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
public class ThongBaoNguoiNhanDTO {
    private Integer idThongBaoNguoiNhan;
    private Integer idThongBao;
    private Integer idNguoiNhan;
    private String vaiTroNguoiNhan;
    private LocalDateTime thoiGianDoc;
    private LocalDateTime ngayXoa;
}
