package com.webservice.hethongchothuevesi.mapper;

import com.webservice.hethongchothuevesi.dto.dto.VeSiKhoaDaoTaoDTO;
import com.webservice.hethongchothuevesi.entity.VeSiKhoaDaoTao;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface VeSiKhoaDaoTaoMapper {

	VeSiKhoaDaoTaoMapper INSTANCE = Mappers.getMapper(VeSiKhoaDaoTaoMapper.class);

	// Chuyển đổi từ entity sang DTO
	VeSiKhoaDaoTaoDTO toDTO(VeSiKhoaDaoTao entity);

	// Chuyển đổi từ sang entity
	VeSiKhoaDaoTao toEntity(VeSiKhoaDaoTaoDTO dto);
}
