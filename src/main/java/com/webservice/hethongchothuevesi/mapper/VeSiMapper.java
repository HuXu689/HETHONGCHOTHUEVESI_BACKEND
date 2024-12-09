package com.webservice.hethongchothuevesi.mapper;

import com.webservice.hethongchothuevesi.dto.dto.*;
import com.webservice.hethongchothuevesi.entity.*;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface VeSiMapper {

	VeSiMapper INSTANCE = Mappers.getMapper(VeSiMapper.class);

	// Chuyển đổi từ entity sang DTO
	VeSiDTO toDTO(VeSi entity);

	// Chuyển đổi từ sang entity
	VeSi toEntity(VeSiDTO dto);
}
