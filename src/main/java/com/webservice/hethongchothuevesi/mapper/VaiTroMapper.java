package com.webservice.hethongchothuevesi.mapper;

import java.util.List;

import com.webservice.hethongchothuevesi.dto.dto.VaiTroDTO;
import com.webservice.hethongchothuevesi.entity.VaiTro;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface VaiTroMapper {

	// Chuyển đổi từ entity sang DTO
	VaiTroDTO toDTO(VaiTro entity);

	// Chuyển đổi từ sang entity
	VaiTro toEntity(VaiTroDTO dto);

	// Chuyển đổi List Entity sang DTO response
	List<VaiTroDTO> toListDto(List<VaiTro> list);
}
