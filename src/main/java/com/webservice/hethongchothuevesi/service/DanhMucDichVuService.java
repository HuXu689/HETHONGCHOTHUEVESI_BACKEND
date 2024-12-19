package com.webservice.hethongchothuevesi.service;

import java.time.LocalDateTime;
import java.util.List;

import com.webservice.hethongchothuevesi.dto.dto.DanhMucDichVuDTO;
import com.webservice.hethongchothuevesi.entity.DanhMucDichVu;
import com.webservice.hethongchothuevesi.mapper.DanhMucDichVuMapper;
import com.webservice.hethongchothuevesi.respository.DanhMucDichVuRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class DanhMucDichVuService {

	DanhMucDichVuRepository danhMucDichVuRepository;
	DanhMucDichVuMapper danhMucDichVuMapper;

	// Create: Tạo mới data
	public DanhMucDichVuDTO createDanhMucDichVu(DanhMucDichVuDTO danhMucDichVuDTO) {
		DanhMucDichVu danhMucDichVu = danhMucDichVuMapper.toEntity(danhMucDichVuDTO);
		danhMucDichVu = danhMucDichVuRepository.save(danhMucDichVu);
		return danhMucDichVuMapper.toDTO(danhMucDichVu);
	}

	// Read (get by id): Lấy data theo ID
	public DanhMucDichVuDTO getDanhMucDichVuById(Integer id) {
		DanhMucDichVu danhMucDichVu = danhMucDichVuRepository
				.findByIdDanhMucDichVuAndNgayXoaIsNull(id)
				.orElseThrow(() -> new RuntimeException("Danh mục dịch vụ không tồn tại"));
		return danhMucDichVuMapper.toDTO(danhMucDichVu);
	}

	// Read (get all): Lấy tất cả data chưa bị xóa mềm
	public List<DanhMucDichVuDTO> getAllDanhMucDichVu() {
		return danhMucDichVuMapper.toListDto(danhMucDichVuRepository.findByNgayXoaIsNull());
	}

	// Update: Cập nhật thông tin
	public DanhMucDichVuDTO updateDanhMucDichVu(Integer id, DanhMucDichVuDTO request) {
		DanhMucDichVu danhMucDichVu = danhMucDichVuRepository
				.findByIdDanhMucDichVuAndNgayXoaIsNull(id)
				.orElseThrow(() -> new RuntimeException("Danh mục dịch vụ không tồn tại"));

		danhMucDichVuMapper.updateEntity(danhMucDichVu, request);

		return danhMucDichVuMapper.toDTO(danhMucDichVuRepository.save(danhMucDichVu));
	}

	// Soft Delete: Xóa mềm (đặt ngày xóa)
	public void deleteDanhMucDichVu(Integer id) {
		DanhMucDichVu danhMucDichVu = danhMucDichVuRepository
				.findById(id)
				.orElseThrow(() -> new RuntimeException("Danh mục dịch vụ không tồn tại"));

		danhMucDichVu.setNgayXoa(LocalDateTime.now());
		danhMucDichVuRepository.save(danhMucDichVu);
	}
}
