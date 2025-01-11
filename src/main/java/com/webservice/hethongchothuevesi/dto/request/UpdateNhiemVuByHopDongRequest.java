package com.webservice.hethongchothuevesi.dto.request;

import com.webservice.hethongchothuevesi.dto.dto.NhiemVuDTO;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.util.List;

@Data
public class UpdateNhiemVuByHopDongRequest {

    @NotNull(message = "idHopDong không được để trống")
    private Integer idHopDong;

    @NotNull(message = "Danh sách nhiệm vụ không được để trống")
    @Size(min = 1, message = "Phải có ít nhất một nhiệm vụ")
    private List<NhiemVuDTO> nhiemVus;
}
