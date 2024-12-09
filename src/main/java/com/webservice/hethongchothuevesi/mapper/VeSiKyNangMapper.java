package com.webservice.hethongchothuevesi.mapper;

import java.util.List;

import com.webservice.hethongchothuevesi.dto.dto.VeSiKyNangDTO;
import com.webservice.hethongchothuevesi.entity.VeSiKyNang;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring")
public interface VeSiKyNangMapper {

	// Chuyển đổi từ entity sang DTO
	VeSiKyNangDTO toDTO(VeSiKyNang entity);

	// Chuyển đổi từ sang entity
	VeSiKyNang toEntity(VeSiKyNangDTO dto);

	// Chuyển đổi List Entity sang DTO response
	List<VeSiKyNangDTO> toListDto(List<VeSiKyNang> list);

	// Cập nhật dữ liệu khác null
	@BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
	void updateEntity(@MappingTarget VeSiKyNang entity, VeSiKyNangDTO dto);
}
