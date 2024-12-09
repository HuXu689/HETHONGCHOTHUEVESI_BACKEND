package com.webservice.hethongchothuevesi.mapper;

import com.webservice.hethongchothuevesi.dto.dto.*;
import com.webservice.hethongchothuevesi.entity.*;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface YeuCauDichVuMapper {

	YeuCauDichVuMapper INSTANCE = Mappers.getMapper(YeuCauDichVuMapper.class);

	// Chuyển đổi từ entity sang DTO
	YeuCauDichVuDTO toDTO(YeuCauDichVu entity);

	// Chuyển đổi từ sang entity
	YeuCauDichVu toEntity(YeuCauDichVuDTO dto);
}
