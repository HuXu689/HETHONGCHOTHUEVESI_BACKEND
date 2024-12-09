package com.webservice.hethongchothuevesi.mapper;

import java.util.List;

import com.webservice.hethongchothuevesi.dto.dto.VeSiKyNangDTO;
import com.webservice.hethongchothuevesi.entity.VeSiKyNang;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface VeSiKyNangMapper {

	// Chuyển đổi từ entity sang DTO
	VeSiKyNangDTO toDTO(VeSiKyNang entity);

	// Chuyển đổi từ sang entity
	VeSiKyNang toEntity(VeSiKyNangDTO dto);

	// Chuyển đổi List Entity sang DTO response
	List<VeSiKyNangDTO> toListDto(List<VeSiKyNang> list);
}
