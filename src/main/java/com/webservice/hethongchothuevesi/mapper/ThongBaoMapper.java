package com.webservice.hethongchothuevesi.mapper;

import java.util.List;

import com.webservice.hethongchothuevesi.dto.dto.ThongBaoDTO;
import com.webservice.hethongchothuevesi.entity.ThongBao;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ThongBaoMapper {

	ThongBaoMapper INSTANCE = Mappers.getMapper(ThongBaoMapper.class);

	// Chuyển đổi từ entity sang DTO
	ThongBaoDTO toDTO(ThongBao entity);

	// Chuyển đổi từ sang entity
	ThongBao toEntity(ThongBaoDTO dto);

	// Chuyển đổi List Entity sang DTO response
	List<ThongBaoDTO> toListDto(List<ThongBao> list);
}
