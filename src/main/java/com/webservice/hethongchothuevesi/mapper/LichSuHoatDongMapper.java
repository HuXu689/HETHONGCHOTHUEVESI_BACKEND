package com.webservice.hethongchothuevesi.mapper;

import java.util.List;

import com.webservice.hethongchothuevesi.dto.dto.LichSuHoatDongDTO;
import com.webservice.hethongchothuevesi.entity.LichSuHoatDong;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface LichSuHoatDongMapper {

	// Chuyển đổi từ entity sang DTO
	LichSuHoatDongDTO toDTO(LichSuHoatDong entity);

	// Chuyển đổi từ sang entity
	LichSuHoatDong toEntity(LichSuHoatDongDTO dto);

	// Chuyển đổi List Entity sang DTO response
	List<LichSuHoatDongDTO> toListDto(List<LichSuHoatDong> list);
}
