package com.webservice.hethongchothuevesi.service;

import java.time.LocalDateTime;
import java.util.List;

import com.webservice.hethongchothuevesi.dto.dto.YeuCauHoTroDTO;
import com.webservice.hethongchothuevesi.entity.YeuCauHoTro;
import com.webservice.hethongchothuevesi.mapper.YeuCauHoTroMapper;
import com.webservice.hethongchothuevesi.respository.YeuCauHoTroRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class YeuCauHoTroService {

	YeuCauHoTroRepository yeuCauHoTroRepository;
	YeuCauHoTroMapper yeuCauHoTroMapper;

	// Create: Tạo mới data
	public YeuCauHoTroDTO createYeuCauHoTro(YeuCauHoTroDTO yeuCauHoTroDTO) {
		YeuCauHoTro yeuCauHoTro = yeuCauHoTroMapper.toEntity(yeuCauHoTroDTO);
		yeuCauHoTro.setNgayXoa(null); // Đảm bảo nhân viên mới không bị xóa mềm
		yeuCauHoTro.setTrangThai("Hoạt động");
		yeuCauHoTro = yeuCauHoTroRepository.save(yeuCauHoTro);
		return yeuCauHoTroMapper.toDTO(yeuCauHoTro);
	}

	// Read (get by id): Lấy data theo ID
	public YeuCauHoTroDTO getYeuCauHoTroById(Integer id) {
		YeuCauHoTro yeuCauHoTro = yeuCauHoTroRepository
				.findByIdYeuCauHoTroAndNgayXoaIsNull(id)
				.orElseThrow(() -> new RuntimeException("Yêu cầu hỗ trợ không tồn tại"));
		return yeuCauHoTroMapper.toDTO(yeuCauHoTro);
	}

	// Read (get all): Lấy tất cả data chưa bị xóa mềm
	public List<YeuCauHoTroDTO> getAllYeuCauHoTro() {
		return yeuCauHoTroMapper.toListDto(yeuCauHoTroRepository.findByNgayXoaIsNull());
	}

	// Update: Cập nhật thông tin
	public YeuCauHoTroDTO updateYeuCauHoTro(Integer id, YeuCauHoTroDTO request) {
		YeuCauHoTro yeuCauHoTro = yeuCauHoTroRepository
				.findByIdYeuCauHoTroAndNgayXoaIsNull(id)
				.orElseThrow(() -> new RuntimeException("Yêu cầu hỗ trợ không tồn tại"));

		yeuCauHoTroMapper.updateEntity(yeuCauHoTro, request);

		return yeuCauHoTroMapper.toDTO(yeuCauHoTroRepository.save(yeuCauHoTro));
	}

	// Soft Delete: Xóa mềm (đặt ngày xóa)
	public void deleteYeuCauHoTro(Integer id) {
		YeuCauHoTro yeuCauHoTro = yeuCauHoTroRepository
				.findById(id)
				.orElseThrow(() -> new RuntimeException("Yêu cầu hỗ trợ không tồn tại"));

		yeuCauHoTro.setNgayXoa(LocalDateTime.now());
		yeuCauHoTroRepository.save(yeuCauHoTro);
	}
}
