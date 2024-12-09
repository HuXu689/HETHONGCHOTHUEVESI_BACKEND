package com.webservice.hethongchothuevesi.mapper;

import com.webservice.hethongchothuevesi.dto.dto.HoSoDTO;
import com.webservice.hethongchothuevesi.entity.HoSo;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface HoSoMapper {

	HoSoMapper INSTANCE = Mappers.getMapper(HoSoMapper.class);

	// Chuyển đổi từ entity sang DTO
	HoSoDTO toDTO(HoSo entity);

	// Chuyển đổi từ sang entity
	HoSo toEntity(HoSoDTO dto);
}
