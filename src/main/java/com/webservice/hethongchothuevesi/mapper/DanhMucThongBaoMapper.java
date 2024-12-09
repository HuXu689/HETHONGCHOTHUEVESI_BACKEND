package com.webservice.hethongchothuevesi.mapper;

import com.webservice.hethongchothuevesi.dto.dto.DanhMucThongBaoDTO;
import com.webservice.hethongchothuevesi.entity.DanhMucThongBao;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface DanhMucThongBaoMapper {

	DanhMucThongBaoMapper INSTANCE = Mappers.getMapper(DanhMucThongBaoMapper.class);

	// Chuyển đổi từ entity sang DTO
	DanhMucThongBaoDTO toDTO(DanhMucThongBao entity);

	// Chuyển đổi từ sang entity
	DanhMucThongBao toEntity(DanhMucThongBaoDTO dto);
}
