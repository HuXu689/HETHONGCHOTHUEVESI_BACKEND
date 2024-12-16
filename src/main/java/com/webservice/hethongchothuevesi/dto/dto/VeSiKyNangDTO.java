package com.webservice.hethongchothuevesi.dto.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class VeSiKyNangDTO {
    private Integer idVeSiKyNang;
    private Integer idDanhMucKyNang;
    private Integer idVeSi;
    private String capBac;
    private String danhGia;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm:ss")
    private LocalDateTime ngayXoa;
}
