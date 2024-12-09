package com.webservice.hethongchothuevesi.mapper;

import com.webservice.hethongchothuevesi.dto.dto.*;
import com.webservice.hethongchothuevesi.entity.*;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface HopDongMapper {

	HopDongMapper INSTANCE = Mappers.getMapper(HopDongMapper.class);

	// Chuyển đổi từ entity sang DTO
	HopDongDTO toDTO(HopDong entity);

	// Chuyển đổi từ sang entity
	HopDong toEntity(HopDongDTO dto);
}
