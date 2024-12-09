package com.webservice.hethongchothuevesi.mapper;

import com.webservice.hethongchothuevesi.dto.dto.*;
import com.webservice.hethongchothuevesi.entity.*;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface HoaDonMapper {

	HoaDonMapper INSTANCE = Mappers.getMapper(HoaDonMapper.class);

	// Chuyển đổi từ entity sang DTO
	HoaDonDTO toDTO(HoaDon entity);

	// Chuyển đổi từ sang entity
	HoaDon toEntity(HoaDonDTO dto);
}
