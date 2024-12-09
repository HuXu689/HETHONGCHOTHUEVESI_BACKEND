package com.webservice.hethongchothuevesi.mapper;

import java.util.List;

import com.webservice.hethongchothuevesi.dto.dto.DanhMucThongBaoDTO;
import com.webservice.hethongchothuevesi.entity.DanhMucThongBao;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring")
public interface DanhMucThongBaoMapper {

	// Chuyển đổi từ entity sang DTO
	DanhMucThongBaoDTO toDTO(DanhMucThongBao entity);

	// Chuyển đổi từ sang entity
	DanhMucThongBao toEntity(DanhMucThongBaoDTO dto);

	// Chuyển đổi List Entity sang DTO response
	List<DanhMucThongBaoDTO> toListDto(List<DanhMucThongBao> list);

	// Cập nhật dữ liệu khác null
	@BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
	void updateEntity(@MappingTarget DanhMucThongBao entity, DanhMucThongBaoDTO dto);
}
