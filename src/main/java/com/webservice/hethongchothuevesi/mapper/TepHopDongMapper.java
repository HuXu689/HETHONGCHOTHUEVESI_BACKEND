package com.webservice.hethongchothuevesi.mapper;

import java.util.List;

import com.webservice.hethongchothuevesi.dto.dto.TepHopDongDTO;
import com.webservice.hethongchothuevesi.entity.TepHopDong;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TepHopDongMapper {

	// Chuyển đổi từ entity sang DTO
	TepHopDongDTO toDTO(TepHopDong entity);

	// Chuyển đổi từ sang entity
	TepHopDong toEntity(TepHopDongDTO dto);

	// Chuyển đổi List Entity sang DTO response
	List<TepHopDongDTO> toListDto(List<TepHopDong> list);
}
