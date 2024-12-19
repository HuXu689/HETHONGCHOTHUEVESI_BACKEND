package com.webservice.hethongchothuevesi.service;

import java.time.LocalDateTime;
import java.util.List;

import com.webservice.hethongchothuevesi.dto.dto.VeSiDTO;
import com.webservice.hethongchothuevesi.entity.VeSi;
import com.webservice.hethongchothuevesi.mapper.VeSiMapper;
import com.webservice.hethongchothuevesi.respository.VeSiRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class VeSiService {

	VeSiRepository veSiRepository;
	VeSiMapper veSiMapper;

	// Create: Tạo mới data
	public VeSiDTO createVeSi(VeSiDTO veSiDTO) {
		VeSi veSi = veSiMapper.toEntity(veSiDTO);
		veSi.setTrangThai("Hoạt động");
		veSi = veSiRepository.save(veSi);
		return veSiMapper.toDTO(veSi);
	}

	// Read (get by id): Lấy data theo ID
	public VeSiDTO getVeSiById(Integer id) {
		VeSi veSi = veSiRepository
				.findByIdVeSiAndNgayXoaIsNull(id)
				.orElseThrow(() -> new RuntimeException("Vệ sĩ không tồn tại"));
		return veSiMapper.toDTO(veSi);
	}

	// Read (get all): Lấy tất cả data chưa bị xóa mềm
	public List<VeSiDTO> getAllVeSi() {
		return veSiMapper.toListDto(veSiRepository.findByNgayXoaIsNull());
	}

	// Update: Cập nhật thông tin
	public VeSiDTO updateVeSi(Integer id, VeSiDTO request) {
		VeSi veSi = veSiRepository
				.findByIdVeSiAndNgayXoaIsNull(id)
				.orElseThrow(() -> new RuntimeException("Vệ sĩ không tồn tại"));

		veSiMapper.updateEntity(veSi, request);

		return veSiMapper.toDTO(veSiRepository.save(veSi));
	}

	// Soft Delete: Xóa mềm (đặt ngày xóa)
	public void deleteVeSi(Integer id) {
		VeSi veSi = veSiRepository.findById(id).orElseThrow(() -> new RuntimeException("Vệ sĩ không tồn tại"));

		veSi.setNgayXoa(LocalDateTime.now());
		veSiRepository.save(veSi);
	}
}
