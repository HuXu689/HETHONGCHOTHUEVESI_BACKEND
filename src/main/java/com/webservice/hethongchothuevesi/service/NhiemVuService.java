package com.webservice.hethongchothuevesi.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import com.webservice.hethongchothuevesi.dto.dto.NhiemVuDTO;
import com.webservice.hethongchothuevesi.dto.request.NhiemVuRequest;
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
		nhiemVu.setTrangThai("Đang thực hiện");
		nhiemVu = nhiemVuRepository.save(nhiemVu);
		return nhiemVuMapper.toDTO(nhiemVu);
	}

	public void addListNhiemVu(NhiemVuRequest request) {
		// Lặp qua danh sách idVeSi và tạo nhiệm vụ
		List<NhiemVu> nhiemVus = request.getListIdVeSi().stream()
				.map(idVeSi -> {
					NhiemVu nhiemVu = new NhiemVu();
					nhiemVu.setIdHopDong(request.getIdHopDong());
					nhiemVu.setIdVeSi(idVeSi);
					nhiemVu.setNgayBatDau(request.getNgayBatDau());
					nhiemVu.setNgayKetThuc(request.getNgayKetThuc());
					nhiemVu.setNoiDung(request.getNoiDung());
					nhiemVu.setTrangThai("Đang thực hiện");
					return nhiemVu;
				})
				.collect(Collectors.toList());

		// Lưu toàn bộ danh sách vào database
		nhiemVuRepository.saveAll(nhiemVus);
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
