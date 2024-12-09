package com.webservice.hethongchothuevesi.mapper;

import com.webservice.hethongchothuevesi.dto.dto.*;
import com.webservice.hethongchothuevesi.entity.*;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface NhiemVuMapper {

	NhiemVuMapper INSTANCE = Mappers.getMapper(NhiemVuMapper.class);

	// Chuyển đổi từ entity sang DTO
	NhiemVuDTO toDTO(NhiemVu entity);

	// Chuyển đổi từ sang entity
	NhiemVu toEntity(NhiemVuDTO dto);
}
