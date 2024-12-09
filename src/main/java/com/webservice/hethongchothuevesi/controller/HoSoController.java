package com.webservice.hethongchothuevesi.controller;

import java.util.List;

import com.webservice.hethongchothuevesi.dto.dto.HoSoDTO;
import com.webservice.hethongchothuevesi.service.HoSoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/HoSo")
@RequiredArgsConstructor
public class HoSoController {

	private final HoSoService hoSoService;

	// Tạo mới hồ sơ
	@PostMapping
	public ResponseEntity<HoSoDTO> createHoSo(@RequestBody HoSoDTO hoSoDTO) {
		HoSoDTO createdHoSo = hoSoService.createHoSo(hoSoDTO);
		return new ResponseEntity<>(createdHoSo, HttpStatus.CREATED);
	}

	// Lấy hồ sơ theo ID
	@GetMapping("/{id}")
	public ResponseEntity<HoSoDTO> getHoSoById(@PathVariable Integer id) {
		HoSoDTO hoSoDTO = hoSoService.getHoSoById(id);
		return new ResponseEntity<>(hoSoDTO, HttpStatus.OK);
	}

	// Lấy tất cả hồ sơ chưa bị xóa mềm
	@GetMapping
	public ResponseEntity<List<HoSoDTO>> getAllHoSo() {
		List<HoSoDTO> hoSoList = hoSoService.getAllHoSo();
		return new ResponseEntity<>(hoSoList, HttpStatus.OK);
	}

	// Cập nhật thông tin hồ sơ
	@PutMapping("/{id}")
	public ResponseEntity<HoSoDTO> updateHoSo(@PathVariable Integer id, @RequestBody HoSoDTO dto) {
		HoSoDTO updatedHoSo = hoSoService.updateHoSo(id, dto);
		return new ResponseEntity<>(updatedHoSo, HttpStatus.OK);
	}

	// Xóa mềm hồ sơ
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteHoSo(@PathVariable Integer id) {
		hoSoService.deleteHoSo(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT); // Trả về HTTP 204 No Content
	}
}
