package com.webservice.hethongchothuevesi.mapper;

import com.webservice.hethongchothuevesi.dto.request.KhachHangCreationRequest;
import com.webservice.hethongchothuevesi.dto.request.KhachHangUpdateRequest;
import com.webservice.hethongchothuevesi.dto.response.KhachHangResponse;
import com.webservice.hethongchothuevesi.entity.KhachHang;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = "spring")
public interface KhachHangMapper {

    //Chuyển đổi Entity sang DTO response
    KhachHangResponse toKhachHangResponse(KhachHang khachHang);

    //Chuyển đổi List Entity sang DTO response
    List<KhachHangResponse> toKhachHangResponse(List<KhachHang> list);

    //Chuyển đổi DTO sang entity
    KhachHang toKhachHang(KhachHangCreationRequest khachHang);

    //Cập nhật dữ liệu khác null
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE) // Dữ liệu đầu vào là null thì không update
    void updateKhachHang(@MappingTarget KhachHang khachHang, KhachHangUpdateRequest khachHangUpdateRequest);

}
