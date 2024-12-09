package com.webservice.hethongchothuevesi.mapper;

import com.webservice.hethongchothuevesi.dto.dto.*;
import com.webservice.hethongchothuevesi.entity.*;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ThongBaoNguoiDungMapper {

	ThongBaoNguoiDungMapper INSTANCE = Mappers.getMapper(ThongBaoNguoiDungMapper.class);

	// Chuyển đổi từ entity sang DTO
	ThongBaoNguoiDungDTO toDTO(ThongBaoNguoiDung entity);

	// Chuyển đổi từ sang entity
	ThongBaoNguoiDung toEntity(ThongBaoNguoiDungDTO dto);
}
