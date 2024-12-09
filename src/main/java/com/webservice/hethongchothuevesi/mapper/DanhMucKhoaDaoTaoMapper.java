package com.webservice.hethongchothuevesi.mapper;

import com.webservice.hethongchothuevesi.dto.dto.DanhMucKhoaDaoTaoDTO;
import com.webservice.hethongchothuevesi.entity.DanhMucKhoaDaoTao;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface DanhMucKhoaDaoTaoMapper {

	DanhMucKhoaDaoTaoMapper INSTANCE = Mappers.getMapper(DanhMucKhoaDaoTaoMapper.class);

	// Chuyển đổi từ entity sang DTO
	DanhMucKhoaDaoTaoDTO toDTO(DanhMucKhoaDaoTao entity);

	// Chuyển đổi từ sang entity
	DanhMucKhoaDaoTao toEntity(DanhMucKhoaDaoTaoDTO dto);
}
