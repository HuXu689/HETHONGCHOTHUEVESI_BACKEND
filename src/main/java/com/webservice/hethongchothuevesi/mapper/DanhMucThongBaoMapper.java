package com.webservice.hethongchothuevesi.mapper;

import java.util.List;

import com.webservice.hethongchothuevesi.dto.dto.DanhMucThongBaoDTO;
import com.webservice.hethongchothuevesi.entity.DanhMucThongBao;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface DanhMucThongBaoMapper {

	// Chuyển đổi từ entity sang DTO
	DanhMucThongBaoDTO toDTO(DanhMucThongBao entity);

	// Chuyển đổi từ sang entity
	DanhMucThongBao toEntity(DanhMucThongBaoDTO dto);

	// Chuyển đổi List Entity sang DTO response
	List<DanhMucThongBaoDTO> toListDto(List<DanhMucThongBao> list);
}
