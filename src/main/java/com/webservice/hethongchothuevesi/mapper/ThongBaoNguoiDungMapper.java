package com.webservice.hethongchothuevesi.mapper;

import java.util.List;

import com.webservice.hethongchothuevesi.dto.dto.ThongBaoNguoiDungDTO;
import com.webservice.hethongchothuevesi.entity.ThongBaoNguoiDung;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ThongBaoNguoiDungMapper {

	// Chuyển đổi từ entity sang DTO
	ThongBaoNguoiDungDTO toDTO(ThongBaoNguoiDung entity);

	// Chuyển đổi từ sang entity
	ThongBaoNguoiDung toEntity(ThongBaoNguoiDungDTO dto);

	// Chuyển đổi List Entity sang DTO response
	List<ThongBaoNguoiDungDTO> toListDto(List<ThongBaoNguoiDung> list);
}
