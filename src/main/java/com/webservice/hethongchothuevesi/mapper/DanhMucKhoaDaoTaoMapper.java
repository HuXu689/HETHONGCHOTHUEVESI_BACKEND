package com.webservice.hethongchothuevesi.mapper;

import java.util.List;

import com.webservice.hethongchothuevesi.dto.dto.DanhMucKhoaDaoTaoDTO;
import com.webservice.hethongchothuevesi.entity.DanhMucKhoaDaoTao;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring")
public interface DanhMucKhoaDaoTaoMapper {

	// Chuyển đổi từ entity sang DTO
	DanhMucKhoaDaoTaoDTO toDTO(DanhMucKhoaDaoTao entity);

	// Chuyển đổi từ sang entity
	DanhMucKhoaDaoTao toEntity(DanhMucKhoaDaoTaoDTO dto);

	// Chuyển đổi List Entity sang DTO response
	List<DanhMucKhoaDaoTaoDTO> toListDto(List<DanhMucKhoaDaoTao> list);

	// Cập nhật dữ liệu khác null
	@BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
	void updateEntity(@MappingTarget DanhMucKhoaDaoTao entity, DanhMucKhoaDaoTaoDTO dto);
}
