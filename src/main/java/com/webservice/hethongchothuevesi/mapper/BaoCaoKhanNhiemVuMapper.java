package com.webservice.hethongchothuevesi.mapper;

import java.util.List;

import com.webservice.hethongchothuevesi.dto.dto.BaoCaoKhanNhiemVuDTO;
import com.webservice.hethongchothuevesi.entity.BaoCaoKhanNhiemVu;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface BaoCaoKhanNhiemVuMapper {

	// Chuyển đổi từ entity sang DTO
	BaoCaoKhanNhiemVuDTO toDTO(BaoCaoKhanNhiemVu entity);

	// Chuyển đổi từ sang entity
	BaoCaoKhanNhiemVu toEntity(BaoCaoKhanNhiemVuDTO dto);

	// Chuyển đổi List Entity sang DTO response
	List<BaoCaoKhanNhiemVuDTO> toListDto(List<BaoCaoKhanNhiemVu> list);
}
