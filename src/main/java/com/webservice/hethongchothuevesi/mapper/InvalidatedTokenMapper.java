package com.webservice.hethongchothuevesi.mapper;

import java.util.List;

import com.webservice.hethongchothuevesi.dto.dto.InvalidatedTokenDTO;
import com.webservice.hethongchothuevesi.entity.InvalidatedToken;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface InvalidatedTokenMapper {

	InvalidatedTokenMapper INSTANCE = Mappers.getMapper(InvalidatedTokenMapper.class);

	// Chuyển đổi từ entity sang DTO
	InvalidatedTokenDTO toDTO(InvalidatedToken entity);

	// Chuyển đổi từ sang entity
	InvalidatedToken toEntity(InvalidatedTokenDTO dto);

	// Chuyển đổi List Entity sang DTO response
	List<InvalidatedTokenDTO> toListDto(List<InvalidatedToken> list);
}
