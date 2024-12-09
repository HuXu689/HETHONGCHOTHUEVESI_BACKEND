package com.webservice.hethongchothuevesi.mapper;

import com.webservice.hethongchothuevesi.dto.dto.NhanVienDTO;
import com.webservice.hethongchothuevesi.entity.NhanVien;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface NhanVienMapper {

	NhanVienMapper INSTANCE = Mappers.getMapper(NhanVienMapper.class);

	// Chuyển đổi từ NhanVien entity sang NhanVienDTO
	NhanVienDTO toDTO(NhanVien nhanVien);

	// Chuyển đổi từ NhanVienDTO sang NhanVien entity
	NhanVien toEntity(NhanVienDTO nhanVienDTO);
}
