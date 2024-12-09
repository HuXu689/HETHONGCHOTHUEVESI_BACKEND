package com.webservice.hethongchothuevesi.mapper;

import java.util.List;

import com.webservice.hethongchothuevesi.dto.dto.HoaDonDTO;
import com.webservice.hethongchothuevesi.entity.HoaDon;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring")
public interface HoaDonMapper {

	// Chuyển đổi từ entity sang DTO
	HoaDonDTO toDTO(HoaDon entity);

	// Chuyển đổi từ sang entity
	HoaDon toEntity(HoaDonDTO dto);

	// Chuyển đổi List Entity sang DTO response
	List<HoaDonDTO> toListDto(List<HoaDon> list);

	// Cập nhật dữ liệu khác null
	@BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
	void updateEntity(@MappingTarget HoaDon entity, HoaDonDTO dto);
}
