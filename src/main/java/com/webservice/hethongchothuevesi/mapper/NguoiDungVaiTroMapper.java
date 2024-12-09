package com.webservice.hethongchothuevesi.mapper;

import java.util.List;

import com.webservice.hethongchothuevesi.dto.dto.NguoiDungVaiTroDTO;
import com.webservice.hethongchothuevesi.entity.NguoiDungVaiTro;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring")
public interface NguoiDungVaiTroMapper {

	// Chuyển đổi từ entity sang DTO
	NguoiDungVaiTroDTO toDTO(NguoiDungVaiTro entity);

	// Chuyển đổi từ sang entity
	NguoiDungVaiTro toEntity(NguoiDungVaiTroDTO dto);

	// Chuyển đổi List Entity sang DTO response
	List<NguoiDungVaiTroDTO> toListDto(List<NguoiDungVaiTro> list);

	// Cập nhật dữ liệu khác null
	@BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
	void updateEntity(@MappingTarget NguoiDungVaiTro entity, NguoiDungVaiTroDTO dto);
}
