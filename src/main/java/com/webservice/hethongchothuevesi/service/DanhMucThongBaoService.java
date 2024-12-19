package com.webservice.hethongchothuevesi.service;

import java.time.LocalDateTime;
import java.util.List;

import com.webservice.hethongchothuevesi.dto.dto.DanhMucThongBaoDTO;
import com.webservice.hethongchothuevesi.entity.DanhMucThongBao;
import com.webservice.hethongchothuevesi.mapper.DanhMucThongBaoMapper;
import com.webservice.hethongchothuevesi.respository.DanhMucThongBaoRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class DanhMucThongBaoService {

	DanhMucThongBaoRepository danhMucThongBaoRepository;
	DanhMucThongBaoMapper danhMucThongBaoMapper;

	// Create: Tạo mới data
	public DanhMucThongBaoDTO createDanhMucThongBao(DanhMucThongBaoDTO danhMucThongBaoDTO) {
		DanhMucThongBao danhMucThongBao = danhMucThongBaoMapper.toEntity(danhMucThongBaoDTO);
		danhMucThongBao = danhMucThongBaoRepository.save(danhMucThongBao);
		return danhMucThongBaoMapper.toDTO(danhMucThongBao);
	}

	// Read (get by id): Lấy data theo ID
	public DanhMucThongBaoDTO getDanhMucThongBaoById(Integer id) {
		DanhMucThongBao danhMucThongBao = danhMucThongBaoRepository
				.findByIdDanhMucThongBaoAndNgayXoaIsNull(id)
				.orElseThrow(() -> new RuntimeException("Danh mục thông báo không tồn tại"));
		return danhMucThongBaoMapper.toDTO(danhMucThongBao);
	}

	// Read (get all): Lấy tất cả data chưa bị xóa mềm
	public List<DanhMucThongBaoDTO> getAllDanhMucThongBao() {
		return danhMucThongBaoMapper.toListDto(danhMucThongBaoRepository.findByNgayXoaIsNull());
	}

	// Update: Cập nhật thông tin
	public DanhMucThongBaoDTO updateDanhMucThongBao(Integer id, DanhMucThongBaoDTO request) {
		DanhMucThongBao danhMucThongBao = danhMucThongBaoRepository
				.findByIdDanhMucThongBaoAndNgayXoaIsNull(id)
				.orElseThrow(() -> new RuntimeException("Danh mục thông báo không tồn tại"));

		danhMucThongBaoMapper.updateEntity(danhMucThongBao, request);

		return danhMucThongBaoMapper.toDTO(danhMucThongBaoRepository.save(danhMucThongBao));
	}

	// Soft Delete: Xóa mềm (đặt ngày xóa)
	public void deleteDanhMucThongBao(Integer id) {
		DanhMucThongBao danhMucThongBao = danhMucThongBaoRepository
				.findById(id)
				.orElseThrow(() -> new RuntimeException("Danh mục thông báo không tồn tại"));

		danhMucThongBao.setNgayXoa(LocalDateTime.now());
		danhMucThongBaoRepository.save(danhMucThongBao);
	}
}
