package com.webservice.hethongchothuevesi.mapper;

import com.webservice.hethongchothuevesi.dto.dto.VaiTroDTO;
import com.webservice.hethongchothuevesi.entity.VaiTro;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface VaiTroMapper {

	VaiTroMapper INSTANCE = Mappers.getMapper(VaiTroMapper.class);

	// Chuyển đổi từ entity sang DTO
	VaiTroDTO toDTO(VaiTro entity);

	// Chuyển đổi từ sang entity
	VaiTro toEntity(VaiTroDTO dto);
}
