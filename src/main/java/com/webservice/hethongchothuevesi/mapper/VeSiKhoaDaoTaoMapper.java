package com.webservice.hethongchothuevesi.mapper;

import java.util.List;

import com.webservice.hethongchothuevesi.dto.dto.VeSiKhoaDaoTaoDTO;
import com.webservice.hethongchothuevesi.entity.VeSiKhoaDaoTao;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface VeSiKhoaDaoTaoMapper {

	// Chuyển đổi từ entity sang DTO
	VeSiKhoaDaoTaoDTO toDTO(VeSiKhoaDaoTao entity);

	// Chuyển đổi từ sang entity
	VeSiKhoaDaoTao toEntity(VeSiKhoaDaoTaoDTO dto);

	// Chuyển đổi List Entity sang DTO response
	List<VeSiKhoaDaoTaoDTO> toListDto(List<VeSiKhoaDaoTao> list);
}
