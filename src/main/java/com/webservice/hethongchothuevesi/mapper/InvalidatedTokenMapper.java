package com.webservice.hethongchothuevesi.mapper;

import java.util.List;

import com.webservice.hethongchothuevesi.dto.dto.InvalidatedTokenDTO;
import com.webservice.hethongchothuevesi.entity.InvalidatedToken;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring")
public interface InvalidatedTokenMapper {

	// Chuyển đổi từ entity sang DTO
	InvalidatedTokenDTO toDTO(InvalidatedToken entity);

	// Chuyển đổi từ sang entity
	InvalidatedToken toEntity(InvalidatedTokenDTO dto);

	// Chuyển đổi List Entity sang DTO response
	List<InvalidatedTokenDTO> toListDto(List<InvalidatedToken> list);

	// Cập nhật dữ liệu khác null
	@BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
	void updateEntity(@MappingTarget InvalidatedToken entity, InvalidatedTokenDTO dto);
}
