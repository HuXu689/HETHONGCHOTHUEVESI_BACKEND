package com.webservice.hethongchothuevesi.mapper;

import com.webservice.hethongchothuevesi.dto.dto.NhiemVuDTO;
import com.webservice.hethongchothuevesi.entity.NhiemVu;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

import java.util.List;

@Mapper(componentModel = "spring")
public interface NhiemVuMapper {

    // Chuyển đổi từ entity sang DTO
    NhiemVuDTO toDTO(NhiemVu entity);

    // Chuyển đổi từ sang entity
    NhiemVu toEntity(NhiemVuDTO dto);

    // Chuyển đổi List Entity sang DTO response
    List<NhiemVuDTO> toListDto(List<NhiemVu> list);

    // Cập nhật dữ liệu khác null
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateEntity(@MappingTarget NhiemVu entity, NhiemVuDTO dto);

    // Phương thức để cập nhật entity từ DTO
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateEntityFromDto(NhiemVuDTO dto, @MappingTarget NhiemVu entity);
}
