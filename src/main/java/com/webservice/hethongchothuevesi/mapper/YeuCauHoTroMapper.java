package com.webservice.hethongchothuevesi.mapper;

import java.util.List;

import com.webservice.hethongchothuevesi.dto.dto.YeuCauHoTroDTO;
import com.webservice.hethongchothuevesi.entity.YeuCauHoTro;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring")
public interface YeuCauHoTroMapper {

	// Chuyển đổi từ entity sang DTO
	YeuCauHoTroDTO toDTO(YeuCauHoTro entity);

	// Chuyển đổi từ sang entity
	YeuCauHoTro toEntity(YeuCauHoTroDTO dto);

	// Chuyển đổi List Entity sang DTO response
	List<YeuCauHoTroDTO> toListDto(List<YeuCauHoTro> list);

	// Cập nhật dữ liệu khác null
	@BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
	void updateEntity(@MappingTarget YeuCauHoTro entity, YeuCauHoTroDTO dto);
}
