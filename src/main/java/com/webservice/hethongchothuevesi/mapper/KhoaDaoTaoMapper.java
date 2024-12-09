package com.webservice.hethongchothuevesi.mapper;

import com.webservice.hethongchothuevesi.dto.dto.*;
import com.webservice.hethongchothuevesi.entity.*;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface KhoaDaoTaoMapper {

	KhoaDaoTaoMapper INSTANCE = Mappers.getMapper(KhoaDaoTaoMapper.class);

	// Chuyển đổi từ entity sang DTO
	KhoaDaoTaoDTO toDTO(KhoaDaoTao entity);

	// Chuyển đổi từ sang entity
	KhoaDaoTao toEntity(KhoaDaoTaoDTO dto);
}
