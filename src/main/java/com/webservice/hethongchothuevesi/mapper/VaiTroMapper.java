package com.webservice.hethongchothuevesi.mapper;

import java.util.List;

import com.webservice.hethongchothuevesi.dto.dto.VaiTroDTO;
import com.webservice.hethongchothuevesi.entity.VaiTro;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring")
public interface VaiTroMapper {

	// Chuyển đổi từ entity sang DTO
	VaiTroDTO toDTO(VaiTro entity);

	// Chuyển đổi từ sang entity
	VaiTro toEntity(VaiTroDTO dto);

	// Chuyển đổi List Entity sang DTO response
	List<VaiTroDTO> toListDto(List<VaiTro> list);

	// Cập nhật dữ liệu khác null
	@BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
	void updateEntity(@MappingTarget VaiTro entity, VaiTroDTO dto);
}
