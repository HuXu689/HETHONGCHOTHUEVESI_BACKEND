package com.webservice.hethongchothuevesi.mapper;

import java.util.List;

import com.webservice.hethongchothuevesi.dto.dto.NhiemVuDTO;
import com.webservice.hethongchothuevesi.entity.NhiemVu;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface NhiemVuMapper {

	NhiemVuMapper INSTANCE = Mappers.getMapper(NhiemVuMapper.class);

	// Chuyển đổi từ entity sang DTO
	NhiemVuDTO toDTO(NhiemVu entity);

	// Chuyển đổi từ sang entity
	NhiemVu toEntity(NhiemVuDTO dto);

	// Chuyển đổi List Entity sang DTO response
	List<NhiemVuDTO> toListDto(List<NhiemVu> list);
}
