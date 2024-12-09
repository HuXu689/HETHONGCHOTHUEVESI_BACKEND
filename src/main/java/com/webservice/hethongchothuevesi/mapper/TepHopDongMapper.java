package com.webservice.hethongchothuevesi.mapper;

import java.util.List;

import com.webservice.hethongchothuevesi.dto.dto.TepHopDongDTO;
import com.webservice.hethongchothuevesi.entity.TepHopDong;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring")
public interface TepHopDongMapper {

	// Chuyển đổi từ entity sang DTO
	TepHopDongDTO toDTO(TepHopDong entity);

	// Chuyển đổi từ sang entity
	TepHopDong toEntity(TepHopDongDTO dto);

	// Chuyển đổi List Entity sang DTO response
	List<TepHopDongDTO> toListDto(List<TepHopDong> list);

	// Cập nhật dữ liệu khác null
	@BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
	void updateEntity(@MappingTarget TepHopDong entity, TepHopDongDTO dto);
}
