package com.webservice.hethongchothuevesi.mapper;

import com.webservice.hethongchothuevesi.dto.dto.LichSuHoatDongDTO;
import com.webservice.hethongchothuevesi.entity.LichSuHoatDong;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface LichSuHoatDongMapper {

	LichSuHoatDongMapper INSTANCE = Mappers.getMapper(LichSuHoatDongMapper.class);

	// Chuyển đổi từ entity sang DTO
	LichSuHoatDongDTO toDTO(LichSuHoatDong entity);

	// Chuyển đổi từ sang entity
	LichSuHoatDong toEntity(LichSuHoatDongDTO dto);
}
