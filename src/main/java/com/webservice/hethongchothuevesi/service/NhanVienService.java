package com.webservice.hethongchothuevesi.service;

import java.time.LocalDateTime;
import java.util.List;

import com.webservice.hethongchothuevesi.dto.dto.NhanVienDTO;
import com.webservice.hethongchothuevesi.entity.NhanVien;
import com.webservice.hethongchothuevesi.mapper.NhanVienMapper;
import com.webservice.hethongchothuevesi.respository.NhanVienRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class NhanVienService {

	NhanVienRepository nhanVienRepository;
	NhanVienMapper nhanVienMapper;

	// Create: Tạo mới data
	public NhanVienDTO createNhanVien(NhanVienDTO nhanVienDTO) {
		NhanVien nhanVien = nhanVienMapper.toEntity(nhanVienDTO);
		nhanVien.setTrangThai("Hoạt động");
		nhanVien = nhanVienRepository.save(nhanVien);
		return nhanVienMapper.toDTO(nhanVien);
	}

	// Read (get by id): Lấy data theo ID
	public NhanVienDTO getNhanVienById(Integer id) {
		NhanVien nhanVien = nhanVienRepository
				.findByIdNhanVienAndNgayXoaIsNull(id)
				.orElseThrow(() -> new RuntimeException("Nhân viên không tồn tại"));
		return nhanVienMapper.toDTO(nhanVien);
	}

	// Read (get all): Lấy tất cả data chưa bị xóa mềm
	public List<NhanVienDTO> getAllNhanVien() {
		return nhanVienMapper.toListDto(nhanVienRepository.findByNgayXoaIsNull());
	}

	// Update: Cập nhật thông tin
	public NhanVienDTO updateNhanVien(Integer id, NhanVienDTO request) {
		NhanVien nhanVien = nhanVienRepository
				.findByIdNhanVienAndNgayXoaIsNull(id)
				.orElseThrow(() -> new RuntimeException("Nhân viên không tồn tại"));

		nhanVienMapper.updateEntity(nhanVien, request);

		return nhanVienMapper.toDTO(nhanVienRepository.save(nhanVien));
	}

	// Soft Delete: Xóa mềm (đặt ngày xóa)
	public void deleteNhanVien(Integer id) {
		NhanVien nhanVien =
				nhanVienRepository.findById(id).orElseThrow(() -> new RuntimeException("Nhân viên không tồn tại"));

		nhanVien.setNgayXoa(LocalDateTime.now());
		nhanVienRepository.save(nhanVien);
	}
}
