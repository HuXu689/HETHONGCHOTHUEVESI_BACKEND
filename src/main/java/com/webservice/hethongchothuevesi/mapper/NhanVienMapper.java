package com.webservice.hethongchothuevesi.mapper;

import java.util.List;

import com.webservice.hethongchothuevesi.dto.dto.NhanVienDTO;
import com.webservice.hethongchothuevesi.entity.NhanVien;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface NhanVienMapper {

	// Chuyển đổi từ entity sang DTO
	NhanVienDTO toDTO(NhanVien nhanVien);

	// Chuyển đổi từ DTO sang entity
	NhanVien toEntity(NhanVienDTO nhanVienDTO);

	// Chuyển đổi List Entity sang DTO response
	List<NhanVienDTO> toListDto(List<NhanVien> list);
}
