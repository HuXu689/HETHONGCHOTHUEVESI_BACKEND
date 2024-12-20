package com.webservice.hethongchothuevesi.service;

import java.time.LocalDateTime;
import java.util.List;

import com.webservice.hethongchothuevesi.dto.dto.HoaDonDTO;
import com.webservice.hethongchothuevesi.entity.HoaDon;
import com.webservice.hethongchothuevesi.mapper.HoaDonMapper;
import com.webservice.hethongchothuevesi.respository.HoaDonRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class HoaDonService {

	HoaDonRepository hoaDonRepository;
	HoaDonMapper hoaDonMapper;

	// Create: Tạo mới data
	public HoaDonDTO createHoaDon(HoaDonDTO hoaDonDTO) {
		HoaDon hoaDon = hoaDonMapper.toEntity(hoaDonDTO);
		hoaDon.setTrangThai("Chưa thanh toán");
		hoaDon = hoaDonRepository.save(hoaDon);
		return hoaDonMapper.toDTO(hoaDon);
	}

	// Read (get by id): Lấy data theo ID
	public HoaDonDTO getHoaDonById(Integer id) {
		HoaDon hoaDon = hoaDonRepository
				.findByIdHoaDonAndNgayXoaIsNull(id)
				.orElseThrow(() -> new RuntimeException("Hóa đơn không tồn tại"));
		return hoaDonMapper.toDTO(hoaDon);
	}

	// Read (get all): Lấy tất cả data chưa bị xóa mềm
	public List<HoaDonDTO> getAllHoaDon() {
		return hoaDonMapper.toListDto(hoaDonRepository.findByNgayXoaIsNull());
	}

	// Update: Cập nhật thông tin
	public HoaDonDTO updateHoaDon(Integer id, HoaDonDTO request) {
		HoaDon hoaDon = hoaDonRepository
				.findByIdHoaDonAndNgayXoaIsNull(id)
				.orElseThrow(() -> new RuntimeException("Hóa đơn không tồn tại"));

		hoaDonMapper.updateEntity(hoaDon, request);

		return hoaDonMapper.toDTO(hoaDonRepository.save(hoaDon));
	}

	// Soft Delete: Xóa mềm (đặt ngày xóa)
	public void deleteHoaDon(Integer id) {
		HoaDon hoaDon = hoaDonRepository.findById(id).orElseThrow(() -> new RuntimeException("Hóa đơn không tồn tại"));

		hoaDon.setNgayXoa(LocalDateTime.now());
		hoaDonRepository.save(hoaDon);
	}
}
