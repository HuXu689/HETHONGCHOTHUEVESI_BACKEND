package com.webservice.hethongchothuevesi.mapper;

import com.webservice.hethongchothuevesi.dto.dto.NguoiDungVaiTroDTO;
import com.webservice.hethongchothuevesi.entity.NguoiDungVaiTro;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface NguoiDungVaiTroMapper {

	NguoiDungVaiTroMapper INSTANCE = Mappers.getMapper(NguoiDungVaiTroMapper.class);

	// Chuyển đổi từ entity sang DTO
	NguoiDungVaiTroDTO toDTO(NguoiDungVaiTro entity);

	// Chuyển đổi từ sang entity
	NguoiDungVaiTro toEntity(NguoiDungVaiTroDTO dto);
}
