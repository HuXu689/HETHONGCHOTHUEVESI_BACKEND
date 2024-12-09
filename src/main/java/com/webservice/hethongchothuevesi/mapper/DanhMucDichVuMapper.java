package com.webservice.hethongchothuevesi.mapper;

import java.util.List;

import com.webservice.hethongchothuevesi.dto.dto.DanhMucDichVuDTO;
import com.webservice.hethongchothuevesi.entity.DanhMucDichVu;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface DanhMucDichVuMapper {

	// Chuyển đổi từ entity sang DTO
	DanhMucDichVuDTO toDTO(DanhMucDichVu entity);

	// Chuyển đổi từ sang entity
	DanhMucDichVu toEntity(DanhMucDichVuDTO dto);

	// Chuyển đổi List Entity sang DTO response
	List<DanhMucDichVuDTO> toListDto(List<DanhMucDichVu> list);
}
