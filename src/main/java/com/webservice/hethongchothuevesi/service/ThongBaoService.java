package com.webservice.hethongchothuevesi.service;

import java.time.LocalDateTime;
import java.util.List;

import com.webservice.hethongchothuevesi.dto.dto.ThongBaoDTO;
import com.webservice.hethongchothuevesi.entity.ThongBao;
import com.webservice.hethongchothuevesi.mapper.ThongBaoMapper;
import com.webservice.hethongchothuevesi.respository.ThongBaoRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class ThongBaoService {

	ThongBaoRepository thongBaoRepository;
	ThongBaoMapper thongBaoMapper;

	// Create: Tạo mới data
	public ThongBaoDTO createThongBao(ThongBaoDTO thongBaoDTO) {
		ThongBao thongBao = thongBaoMapper.toEntity(thongBaoDTO);
		thongBao = thongBaoRepository.save(thongBao);
		return thongBaoMapper.toDTO(thongBao);
	}

	// Read (get by id): Lấy data theo ID
	public ThongBaoDTO getThongBaoById(Integer id) {
		ThongBao thongBao = thongBaoRepository
				.findByIdThongBaoAndNgayXoaIsNull(id)
				.orElseThrow(() -> new RuntimeException("Thông báo không tồn tại"));
		return thongBaoMapper.toDTO(thongBao);
	}

	// Read (get all): Lấy tất cả data chưa bị xóa mềm
	public List<ThongBaoDTO> getAllThongBao() {
		return thongBaoMapper.toListDto(thongBaoRepository.findByNgayXoaIsNull());
	}

	// Update: Cập nhật thông tin
	public ThongBaoDTO updateThongBao(Integer id, ThongBaoDTO request) {
		ThongBao thongBao = thongBaoRepository
				.findByIdThongBaoAndNgayXoaIsNull(id)
				.orElseThrow(() -> new RuntimeException("Thông báo không tồn tại"));

		thongBaoMapper.updateEntity(thongBao, request);

		return thongBaoMapper.toDTO(thongBaoRepository.save(thongBao));
	}

	// Soft Delete: Xóa mềm (đặt ngày xóa)
	public void deleteThongBao(Integer id) {
		ThongBao thongBao =
				thongBaoRepository.findById(id).orElseThrow(() -> new RuntimeException("Thông báo không tồn tại"));

		thongBao.setNgayXoa(LocalDateTime.now());
		thongBaoRepository.save(thongBao);
	}
}
