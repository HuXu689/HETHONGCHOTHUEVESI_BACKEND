package com.webservice.hethongchothuevesi.mapper;

import java.util.List;

import com.webservice.hethongchothuevesi.dto.dto.YeuCauDichVuDTO;
import com.webservice.hethongchothuevesi.entity.YeuCauDichVu;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface YeuCauDichVuMapper {

	// Chuyển đổi từ entity sang DTO
	YeuCauDichVuDTO toDTO(YeuCauDichVu entity);

	// Chuyển đổi từ sang entity
	YeuCauDichVu toEntity(YeuCauDichVuDTO dto);

	// Chuyển đổi List Entity sang DTO response
	List<YeuCauDichVuDTO> toListDto(List<YeuCauDichVu> list);
}
