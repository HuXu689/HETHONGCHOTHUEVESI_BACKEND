package com.webservice.hethongchothuevesi.service;

import java.time.LocalDateTime;
import java.util.List;

import com.webservice.hethongchothuevesi.dto.dto.NhiemVuDTO;
import com.webservice.hethongchothuevesi.entity.NhiemVu;
import com.webservice.hethongchothuevesi.mapper.NhiemVuMapper;
import com.webservice.hethongchothuevesi.respository.NhiemVuRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class NhiemVuService {

	NhiemVuRepository nhiemVuRepository;
	NhiemVuMapper nhiemVuMapper;

	// Create: Tạo mới data
	public NhiemVuDTO createNhiemVu(NhiemVuDTO nhiemVuDTO) {
		NhiemVu nhiemVu = nhiemVuMapper.toEntity(nhiemVuDTO);
		nhiemVu.setTrangThai("Hoạt động");
		nhiemVu = nhiemVuRepository.save(nhiemVu);
		return nhiemVuMapper.toDTO(nhiemVu);
	}

	// Read (get by id): Lấy data theo ID
	public NhiemVuDTO getNhiemVuById(Integer id) {
		NhiemVu nhiemVu = nhiemVuRepository
				.findByIdNhiemVuAndNgayXoaIsNull(id)
				.orElseThrow(() -> new RuntimeException("Nhiệm vụ không tồn tại"));
		return nhiemVuMapper.toDTO(nhiemVu);
	}

	// Read (get all): Lấy tất cả data chưa bị xóa mềm
	public List<NhiemVuDTO> getAllNhiemVu() {
		return nhiemVuMapper.toListDto(nhiemVuRepository.findByNgayXoaIsNull());
	}

	// Update: Cập nhật thông tin
	public NhiemVuDTO updateNhiemVu(Integer id, NhiemVuDTO request) {
		NhiemVu nhiemVu = nhiemVuRepository
				.findByIdNhiemVuAndNgayXoaIsNull(id)
				.orElseThrow(() -> new RuntimeException("Nhiệm vụ không tồn tại"));

		nhiemVuMapper.updateEntity(nhiemVu, request);

		return nhiemVuMapper.toDTO(nhiemVuRepository.save(nhiemVu));
	}

	// Soft Delete: Xóa mềm (đặt ngày xóa)
	public void deleteNhiemVu(Integer id) {
		NhiemVu nhiemVu =
				nhiemVuRepository.findById(id).orElseThrow(() -> new RuntimeException("Nhiệm vụ không tồn tại"));

		nhiemVu.setNgayXoa(LocalDateTime.now());
		nhiemVuRepository.save(nhiemVu);
	}
}
