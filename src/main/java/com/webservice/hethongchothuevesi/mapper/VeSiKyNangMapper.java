package com.webservice.hethongchothuevesi.mapper;

import com.webservice.hethongchothuevesi.dto.dto.*;
import com.webservice.hethongchothuevesi.entity.*;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface VeSiKyNangMapper {

	VeSiKyNangMapper INSTANCE = Mappers.getMapper(VeSiKyNangMapper.class);

	// Chuyển đổi từ entity sang DTO
	VeSiKyNangDTO toDTO(VeSiKyNang entity);

	// Chuyển đổi từ sang entity
	VeSiKyNang toEntity(VeSiKyNangDTO dto);
}
