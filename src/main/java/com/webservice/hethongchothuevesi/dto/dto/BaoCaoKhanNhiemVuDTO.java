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
public class BaoCaoKhanNhiemVuDTO {
    private Integer idBaoCaoKhan;
    private Integer idNhiemVu;
    private Integer idNhanVien;
    private String noiDung;
    private String mucDoKhanCap;
    private String trangThai;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm:ss")
    private LocalDateTime ngayXoa;
}
