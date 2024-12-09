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

	// Create: Tạo mới nhân viên
	public NhanVienDTO createNhanVien(NhanVienDTO nhanVienDTO) {
		NhanVien nhanVien = nhanVienMapper.toEntity(nhanVienDTO);
		nhanVien.setNgayXoa(null); // Đảm bảo nhân viên mới không bị xóa mềm
		nhanVien = nhanVienRepository.save(nhanVien);
		return nhanVienMapper.toDTO(nhanVien);
	}

	// Read (get by id): Lấy nhân viên theo ID
	public NhanVienDTO getNhanVienById(Integer id) {
		NhanVien nhanVien =
				nhanVienRepository.findById(id).orElseThrow(() -> new RuntimeException("Nhân viên không tồn tại"));
		return nhanVienMapper.toDTO(nhanVien);
	}

	// Read (get all): Lấy tất cả nhân viên chưa bị xóa mềm
	public List<NhanVienDTO> getAllNhanVien() {
		return nhanVienMapper.toListDto(nhanVienRepository.findByNgayXoaIsNull());
	}

	// Update: Cập nhật thông tin nhân viên
	public NhanVienDTO updateNhanVien(Integer id, NhanVienDTO nhanVienDTO) {
		NhanVien nhanVien =
				nhanVienRepository.findById(id).orElseThrow(() -> new RuntimeException("Nhân viên không tồn tại"));

		nhanVien.setCapBac(nhanVienDTO.getCapBac());
		nhanVien.setLuong(nhanVienDTO.getLuong());
		nhanVien.setTrangThai(nhanVienDTO.getTrangThai());
		nhanVien.setNgayBatDauLam(nhanVienDTO.getNgayBatDauLam());
		nhanVien.setNgayLenCap(nhanVienDTO.getNgayLenCap());

		nhanVien = nhanVienRepository.save(nhanVien);
		return nhanVienMapper.toDTO(nhanVien);
	}

	// Soft Delete: Xóa mềm nhân viên (đặt ngày xóa)
	public void deleteNhanVien(Integer id) {
		NhanVien nhanVien =
				nhanVienRepository.findById(id).orElseThrow(() -> new RuntimeException("Nhân viên không tồn tại"));

		nhanVien.setNgayXoa(LocalDateTime.now()); // Đặt ngày xóa là thời điểm hiện tại
		nhanVienRepository.save(nhanVien);
	}
}
