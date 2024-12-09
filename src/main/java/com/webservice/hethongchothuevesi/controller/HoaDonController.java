package com.webservice.hethongchothuevesi.controller;

import java.util.List;

import com.webservice.hethongchothuevesi.dto.dto.HoaDonDTO;
import com.webservice.hethongchothuevesi.service.HoaDonService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/HoaDon")
@RequiredArgsConstructor
public class HoaDonController {

	private final HoaDonService hoaDonService;

	// Tạo mới hóa đơn
	@PostMapping
	public ResponseEntity<HoaDonDTO> createHoaDon(@RequestBody HoaDonDTO hoaDonDTO) {
		HoaDonDTO createdHoaDon = hoaDonService.createHoaDon(hoaDonDTO);
		return new ResponseEntity<>(createdHoaDon, HttpStatus.CREATED);
	}

	// Lấy hóa đơn theo ID
	@GetMapping("/{id}")
	public ResponseEntity<HoaDonDTO> getHoaDonById(@PathVariable Integer id) {
		HoaDonDTO hoaDonDTO = hoaDonService.getHoaDonById(id);
		return new ResponseEntity<>(hoaDonDTO, HttpStatus.OK);
	}

	// Lấy tất cả hóa đơn chưa bị xóa mềm
	@GetMapping
	public ResponseEntity<List<HoaDonDTO>> getAllHoaDon() {
		List<HoaDonDTO> hoaDonList = hoaDonService.getAllHoaDon();
		return new ResponseEntity<>(hoaDonList, HttpStatus.OK);
	}

	// Cập nhật thông tin hóa đơn
	@PutMapping("/{id}")
	public ResponseEntity<HoaDonDTO> updateHoaDon(@PathVariable Integer id, @RequestBody HoaDonDTO dto) {
		HoaDonDTO updatedHoaDon = hoaDonService.updateHoaDon(id, dto);
		return new ResponseEntity<>(updatedHoaDon, HttpStatus.OK);
	}

	// Xóa mềm hóa đơn
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteHoaDon(@PathVariable Integer id) {
		hoaDonService.deleteHoaDon(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT); // Trả về HTTP 204 No Content
	}
}
