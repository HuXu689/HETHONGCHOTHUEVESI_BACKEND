package com.webservice.hethongchothuevesi.mapper;

import java.util.List;

import com.webservice.hethongchothuevesi.dto.dto.TepHopDongDTO;
import com.webservice.hethongchothuevesi.entity.TepHopDong;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface TepHopDongMapper {

	TepHopDongMapper INSTANCE = Mappers.getMapper(TepHopDongMapper.class);

	// Chuyển đổi từ entity sang DTO
	TepHopDongDTO toDTO(TepHopDong entity);

	// Chuyển đổi từ sang entity
	TepHopDong toEntity(TepHopDongDTO dto);

	// Chuyển đổi List Entity sang DTO response
	List<TepHopDongDTO> toListDto(List<TepHopDong> list);
}
