package com.webservice.hethongchothuevesi.mapper;

import java.util.List;

import com.webservice.hethongchothuevesi.dto.dto.KhoaDaoTaoDTO;
import com.webservice.hethongchothuevesi.entity.KhoaDaoTao;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface KhoaDaoTaoMapper {

	KhoaDaoTaoMapper INSTANCE = Mappers.getMapper(KhoaDaoTaoMapper.class);

	// Chuyển đổi từ entity sang DTO
	KhoaDaoTaoDTO toDTO(KhoaDaoTao entity);

	// Chuyển đổi từ sang entity
	KhoaDaoTao toEntity(KhoaDaoTaoDTO dto);

	// Chuyển đổi List Entity sang DTO response
	List<KhoaDaoTaoDTO> toListDto(List<KhoaDaoTao> list);
}
