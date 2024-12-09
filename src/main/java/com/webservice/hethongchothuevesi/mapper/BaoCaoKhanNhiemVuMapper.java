package com.webservice.hethongchothuevesi.mapper;

import java.util.List;

import com.webservice.hethongchothuevesi.dto.dto.BaoCaoKhanNhiemVuDTO;
import com.webservice.hethongchothuevesi.entity.BaoCaoKhanNhiemVu;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface BaoCaoKhanNhiemVuMapper {

	BaoCaoKhanNhiemVuMapper INSTANCE = Mappers.getMapper(BaoCaoKhanNhiemVuMapper.class);

	// Chuyển đổi từ entity sang DTO
	BaoCaoKhanNhiemVuDTO toDTO(BaoCaoKhanNhiemVu entity);

	// Chuyển đổi từ sang entity
	BaoCaoKhanNhiemVu toEntity(BaoCaoKhanNhiemVuDTO dto);

	// Chuyển đổi List Entity sang DTO response
	List<BaoCaoKhanNhiemVuDTO> toListDto(List<BaoCaoKhanNhiemVu> list);
}
