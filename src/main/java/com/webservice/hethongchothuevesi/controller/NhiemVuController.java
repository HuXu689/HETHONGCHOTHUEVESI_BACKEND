package com.webservice.hethongchothuevesi.controller;

import java.util.List;

import com.webservice.hethongchothuevesi.dto.dto.NhiemVuDTO;
import com.webservice.hethongchothuevesi.service.NhiemVuService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/NhiemVu")
@RequiredArgsConstructor
public class NhiemVuController {

	private final NhiemVuService nhiemVuService;

	// Tạo mới nhiệm vụ
	@PostMapping
	public ResponseEntity<NhiemVuDTO> createNhiemVu(@RequestBody NhiemVuDTO nhiemVuDTO) {
		NhiemVuDTO createdNhiemVu = nhiemVuService.createNhiemVu(nhiemVuDTO);
		return new ResponseEntity<>(createdNhiemVu, HttpStatus.CREATED);
	}

	// Lấy nhiệm vụ theo ID
	@GetMapping("/{id}")
	public ResponseEntity<NhiemVuDTO> getNhiemVuById(@PathVariable Integer id) {
		NhiemVuDTO nhiemVuDTO = nhiemVuService.getNhiemVuById(id);
		return new ResponseEntity<>(nhiemVuDTO, HttpStatus.OK);
	}

	// Lấy tất cả nhiệm vụ chưa bị xóa mềm
	@GetMapping
	public ResponseEntity<List<NhiemVuDTO>> getAllNhiemVu() {
		List<NhiemVuDTO> nhiemVuList = nhiemVuService.getAllNhiemVu();
		return new ResponseEntity<>(nhiemVuList, HttpStatus.OK);
	}

	// Cập nhật thông tin nhiệm vụ
	@PutMapping("/{id}")
	public ResponseEntity<NhiemVuDTO> updateNhiemVu(@PathVariable Integer id, @RequestBody NhiemVuDTO dto) {
		NhiemVuDTO updatedNhiemVu = nhiemVuService.updateNhiemVu(id, dto);
		return new ResponseEntity<>(updatedNhiemVu, HttpStatus.OK);
	}

	// Xóa mềm nhiệm vụ
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteNhiemVu(@PathVariable Integer id) {
		nhiemVuService.deleteNhiemVu(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT); // Trả về HTTP 204 No Content
	}
}
