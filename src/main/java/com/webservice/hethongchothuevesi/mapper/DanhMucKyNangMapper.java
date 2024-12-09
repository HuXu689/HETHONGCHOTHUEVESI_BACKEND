package com.webservice.hethongchothuevesi.mapper;

import java.util.List;

import com.webservice.hethongchothuevesi.dto.dto.DanhMucKyNangDTO;
import com.webservice.hethongchothuevesi.entity.DanhMucKyNang;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring")
public interface DanhMucKyNangMapper {

	// Chuyển đổi từ entity sang DTO
	DanhMucKyNangDTO toDTO(DanhMucKyNang entity);

	// Chuyển đổi từ sang entity
	DanhMucKyNang toEntity(DanhMucKyNangDTO dto);

	// Chuyển đổi List Entity sang DTO response
	List<DanhMucKyNangDTO> toListDto(List<DanhMucKyNang> list);

	// Cập nhật dữ liệu khác null
	@BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
	void updateEntity(@MappingTarget DanhMucKyNang entity, DanhMucKyNangDTO dto);
}
