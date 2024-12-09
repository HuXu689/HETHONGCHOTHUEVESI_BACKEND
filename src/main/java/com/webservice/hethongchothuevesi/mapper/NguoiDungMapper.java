package com.webservice.hethongchothuevesi.mapper;

import java.util.List;

import com.webservice.hethongchothuevesi.dto.request.NguoiDungCreationRequest;
import com.webservice.hethongchothuevesi.dto.request.NguoiDungUpdateRequest;
import com.webservice.hethongchothuevesi.dto.response.NguoiDungResponse;
import com.webservice.hethongchothuevesi.entity.NguoiDung;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring")
public interface NguoiDungMapper {

	// Chuyển đổi Entity sang DTO response
	NguoiDungResponse toNguoiDungResponse(NguoiDung nguoiDung);

	// Chuyển đổi List Entity sang DTO response
	List<NguoiDungResponse> toNguoiDungResponse(List<NguoiDung> list);

	// Chuyển đổi DTO sang entity
	NguoiDung toNguoiDung(NguoiDungCreationRequest nguoiDung);

	// Cập nhật dữ liệu khác null
	@BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
	// Dữ liệu đầu vào là null thì không update
	void updateNguoiDung(@MappingTarget NguoiDung nguoiDung, NguoiDungUpdateRequest nguoiDungUpdateRequest);
}
