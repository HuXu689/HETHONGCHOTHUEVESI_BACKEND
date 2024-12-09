package com.webservice.hethongchothuevesi.mapper;

import java.util.List;

import com.webservice.hethongchothuevesi.dto.dto.HoSoDTO;
import com.webservice.hethongchothuevesi.entity.HoSo;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface HoSoMapper {

	// Chuyển đổi từ entity sang DTO
	HoSoDTO toDTO(HoSo entity);

	// Chuyển đổi từ sang entity
	HoSo toEntity(HoSoDTO dto);

	// Chuyển đổi List Entity sang DTO response
	List<HoSoDTO> toListDto(List<HoSo> list);
}
