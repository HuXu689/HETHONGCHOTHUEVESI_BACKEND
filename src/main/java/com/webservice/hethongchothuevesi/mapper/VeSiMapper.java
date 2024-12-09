package com.webservice.hethongchothuevesi.mapper;

import java.util.List;

import com.webservice.hethongchothuevesi.dto.dto.VeSiDTO;
import com.webservice.hethongchothuevesi.entity.VeSi;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface VeSiMapper {

	VeSiMapper INSTANCE = Mappers.getMapper(VeSiMapper.class);

	// Chuyển đổi từ entity sang DTO
	VeSiDTO toDTO(VeSi entity);

	// Chuyển đổi từ sang entity
	VeSi toEntity(VeSiDTO dto);

	// Chuyển đổi List Entity sang DTO response
	List<VeSiDTO> toListDto(List<VeSi> list);
}
