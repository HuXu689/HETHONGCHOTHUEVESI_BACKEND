package com.webservice.hethongchothuevesi.controller;

import java.util.List;

import com.webservice.hethongchothuevesi.dto.dto.HopDongDTO;
import com.webservice.hethongchothuevesi.service.HopDongService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/HopDong")
@RequiredArgsConstructor
public class HopDongController {

	private final HopDongService hopDongService;

	// Tạo mới hợp đồng
	@PostMapping
	public ResponseEntity<HopDongDTO> createHopDong(@RequestBody HopDongDTO hopDongDTO) {
		HopDongDTO createdHopDong = hopDongService.createHopDong(hopDongDTO);
		return new ResponseEntity<>(createdHopDong, HttpStatus.CREATED);
	}

	// Lấy nhân viên theo ID
	@GetMapping("/{id}")
	public ResponseEntity<HopDongDTO> getHopDongById(@PathVariable Integer id) {
		HopDongDTO hopDongDTO = hopDongService.getHopDongById(id);
		return new ResponseEntity<>(hopDongDTO, HttpStatus.OK);
	}

	// Lấy tất cả nhân viên chưa bị xóa mềm
	@GetMapping
	public ResponseEntity<List<HopDongDTO>> getAllHopDong() {
		List<HopDongDTO> hopDongList = hopDongService.getAllHopDong();
		return new ResponseEntity<>(hopDongList, HttpStatus.OK);
	}

	// Cập nhật thông tin nhân viên
	@PutMapping("/{id}")
	public ResponseEntity<HopDongDTO> updateHopDong(@PathVariable Integer id, @RequestBody HopDongDTO dto) {
		HopDongDTO updatedHopDong = hopDongService.updateHopDong(id, dto);
		return new ResponseEntity<>(updatedHopDong, HttpStatus.OK);
	}

	// Xóa mềm nhân viên
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteHopDong(@PathVariable Integer id) {
		hopDongService.deleteHopDong(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT); // Trả về HTTP 204 No Content
	}
}
