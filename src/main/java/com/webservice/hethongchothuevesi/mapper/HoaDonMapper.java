package com.webservice.hethongchothuevesi.mapper;

import java.util.List;

import com.webservice.hethongchothuevesi.dto.dto.HoaDonDTO;
import com.webservice.hethongchothuevesi.entity.HoaDon;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface HoaDonMapper {

	// Chuyển đổi từ entity sang DTO
	HoaDonDTO toDTO(HoaDon entity);

	// Chuyển đổi từ sang entity
	HoaDon toEntity(HoaDonDTO dto);

	// Chuyển đổi List Entity sang DTO response
	List<HoaDonDTO> toListDto(List<HoaDon> list);
}
