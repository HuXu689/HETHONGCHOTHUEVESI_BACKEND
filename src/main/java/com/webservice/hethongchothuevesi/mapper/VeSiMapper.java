package com.webservice.hethongchothuevesi.mapper;

import java.util.List;

import com.webservice.hethongchothuevesi.dto.dto.VeSiDTO;
import com.webservice.hethongchothuevesi.entity.VeSi;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring")
public interface VeSiMapper {

	// Chuyển đổi từ entity sang DTO
	VeSiDTO toDTO(VeSi entity);

	// Chuyển đổi từ sang entity
	VeSi toEntity(VeSiDTO dto);

	// Chuyển đổi List Entity sang DTO response
	List<VeSiDTO> toListDto(List<VeSi> list);

	// Cập nhật dữ liệu khác null
	@BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
	void updateEntity(@MappingTarget VeSi entity, VeSiDTO dto);
}
