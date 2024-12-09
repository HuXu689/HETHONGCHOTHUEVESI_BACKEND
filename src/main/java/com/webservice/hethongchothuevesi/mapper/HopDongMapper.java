package com.webservice.hethongchothuevesi.mapper;

import java.util.List;

import com.webservice.hethongchothuevesi.dto.dto.HopDongDTO;
import com.webservice.hethongchothuevesi.entity.HopDong;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface HopDongMapper {

	// Chuyển đổi từ entity sang DTO
	HopDongDTO toDTO(HopDong entity);

	// Chuyển đổi từ sang entity
	HopDong toEntity(HopDongDTO dto);

	// Chuyển đổi List Entity sang DTO response
	List<HopDongDTO> toListDto(List<HopDong> list);
}
