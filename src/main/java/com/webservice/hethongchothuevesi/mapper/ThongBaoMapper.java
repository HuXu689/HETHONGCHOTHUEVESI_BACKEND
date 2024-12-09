package com.webservice.hethongchothuevesi.mapper;

import java.util.List;

import com.webservice.hethongchothuevesi.dto.dto.ThongBaoDTO;
import com.webservice.hethongchothuevesi.entity.ThongBao;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring")
public interface ThongBaoMapper {

	// Chuyển đổi từ entity sang DTO
	ThongBaoDTO toDTO(ThongBao entity);

	// Chuyển đổi từ sang entity
	ThongBao toEntity(ThongBaoDTO dto);

	// Chuyển đổi List Entity sang DTO response
	List<ThongBaoDTO> toListDto(List<ThongBao> list);

	// Cập nhật dữ liệu khác null
	@BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
	void updateEntity(@MappingTarget ThongBao entity, ThongBaoDTO dto);
}
