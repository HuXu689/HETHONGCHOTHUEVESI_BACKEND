package com.webservice.hethongchothuevesi.mapper;

import com.webservice.hethongchothuevesi.dto.dto.DanhMucKyNangDTO;
import com.webservice.hethongchothuevesi.entity.DanhMucKyNang;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface DanhMucKyNangMapper {

	DanhMucKyNangMapper INSTANCE = Mappers.getMapper(DanhMucKyNangMapper.class);

	// Chuyển đổi từ entity sang DTO
	DanhMucKyNangDTO toDTO(DanhMucKyNang entity);

	// Chuyển đổi từ sang entity
	DanhMucKyNang toEntity(DanhMucKyNangDTO dto);
}
