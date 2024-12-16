package com.webservice.hethongchothuevesi.dto.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.webservice.hethongchothuevesi.validator.DobConstraint;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class NguoiDungUpdateRequest {
    String anhDaiDien;
    String gioiTinh;

    @DobConstraint(min = 18)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    LocalDate ngaySinh;

    String email;
    String soDienThoai;
    String hoTen;
    String soCccd;
    String diaChi;
}
