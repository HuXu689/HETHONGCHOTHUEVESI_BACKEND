package com.webservice.hethongchothuevesi.mapper;

import java.util.List;

import com.webservice.hethongchothuevesi.dto.dto.ThongBaoNguoiDungDTO;
import com.webservice.hethongchothuevesi.entity.ThongBaoNguoiDung;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ThongBaoNguoiDungMapper {

	ThongBaoNguoiDungMapper INSTANCE = Mappers.getMapper(ThongBaoNguoiDungMapper.class);

	// Chuyển đổi từ entity sang DTO
	ThongBaoNguoiDungDTO toDTO(ThongBaoNguoiDung entity);

	// Chuyển đổi từ sang entity
	ThongBaoNguoiDung toEntity(ThongBaoNguoiDungDTO dto);

	// Chuyển đổi List Entity sang DTO response
	List<ThongBaoNguoiDungDTO> toListDto(List<ThongBaoNguoiDung> list);
}
