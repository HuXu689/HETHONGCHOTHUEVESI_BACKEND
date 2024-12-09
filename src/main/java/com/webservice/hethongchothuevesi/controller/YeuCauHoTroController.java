package com.webservice.hethongchothuevesi.controller;

import java.util.List;

import com.webservice.hethongchothuevesi.dto.dto.YeuCauHoTroDTO;
import com.webservice.hethongchothuevesi.service.YeuCauHoTroService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/YeuCauHoTro")
@RequiredArgsConstructor
public class YeuCauHoTroController {

	private final YeuCauHoTroService yeuCauHoTroService;

	// Tạo mới yêu cầu hỗ trợ
	@PostMapping
	public ResponseEntity<YeuCauHoTroDTO> createYeuCauHoTro(@RequestBody YeuCauHoTroDTO yeuCauHoTroDTO) {
		YeuCauHoTroDTO createdYeuCauHoTro = yeuCauHoTroService.createYeuCauHoTro(yeuCauHoTroDTO);
		return new ResponseEntity<>(createdYeuCauHoTro, HttpStatus.CREATED);
	}

	// Lấy yêu cầu hỗ trợ theo ID
	@GetMapping("/{id}")
	public ResponseEntity<YeuCauHoTroDTO> getYeuCauHoTroById(@PathVariable Integer id) {
		YeuCauHoTroDTO yeuCauHoTroDTO = yeuCauHoTroService.getYeuCauHoTroById(id);
		return new ResponseEntity<>(yeuCauHoTroDTO, HttpStatus.OK);
	}

	// Lấy tất cả yêu cầu hỗ trợ chưa bị xóa mềm
	@GetMapping
	public ResponseEntity<List<YeuCauHoTroDTO>> getAllYeuCauHoTro() {
		List<YeuCauHoTroDTO> yeuCauHoTroList = yeuCauHoTroService.getAllYeuCauHoTro();
		return new ResponseEntity<>(yeuCauHoTroList, HttpStatus.OK);
	}

	// Cập nhật thông tin yêu cầu hỗ trợ
	@PutMapping("/{id}")
	public ResponseEntity<YeuCauHoTroDTO> updateYeuCauHoTro(@PathVariable Integer id, @RequestBody YeuCauHoTroDTO dto) {
		YeuCauHoTroDTO updatedYeuCauHoTro = yeuCauHoTroService.updateYeuCauHoTro(id, dto);
		return new ResponseEntity<>(updatedYeuCauHoTro, HttpStatus.OK);
	}

	// Xóa mềm yêu cầu hỗ trợ
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteYeuCauHoTro(@PathVariable Integer id) {
		yeuCauHoTroService.deleteYeuCauHoTro(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT); // Trả về HTTP 204 No Content
	}
}
