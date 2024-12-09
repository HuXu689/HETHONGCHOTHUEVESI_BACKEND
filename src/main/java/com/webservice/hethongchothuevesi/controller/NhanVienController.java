package com.webservice.hethongchothuevesi.controller;

import java.util.List;

import com.webservice.hethongchothuevesi.dto.dto.NhanVienDTO;
import com.webservice.hethongchothuevesi.service.NhanVienService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/NhanVien")
@RequiredArgsConstructor
public class NhanVienController {

	private final NhanVienService nhanVienService;

	// Tạo mới nhân viên
	@PostMapping
	public ResponseEntity<NhanVienDTO> createNhanVien(@RequestBody NhanVienDTO nhanVienDTO) {
		NhanVienDTO createdNhanVien = nhanVienService.createNhanVien(nhanVienDTO);
		return new ResponseEntity<>(createdNhanVien, HttpStatus.CREATED);
	}

	// Lấy nhân viên theo ID
	@GetMapping("/{id}")
	public ResponseEntity<NhanVienDTO> getNhanVienById(@PathVariable Integer id) {
		NhanVienDTO nhanVienDTO = nhanVienService.getNhanVienById(id);
		return new ResponseEntity<>(nhanVienDTO, HttpStatus.OK);
	}

	// Lấy tất cả nhân viên chưa bị xóa mềm
	@GetMapping
	public ResponseEntity<List<NhanVienDTO>> getAllNhanVien() {
		List<NhanVienDTO> nhanVienList = nhanVienService.getAllNhanVien();
		return new ResponseEntity<>(nhanVienList, HttpStatus.OK);
	}

	// Cập nhật thông tin nhân viên
	@PutMapping("/{id}")
	public ResponseEntity<NhanVienDTO> updateNhanVien(@PathVariable Integer id, @RequestBody NhanVienDTO dto) {
		NhanVienDTO updatedNhanVien = nhanVienService.updateNhanVien(id, dto);
		return new ResponseEntity<>(updatedNhanVien, HttpStatus.OK);
	}

	// Xóa mềm nhân viên
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteNhanVien(@PathVariable Integer id) {
		nhanVienService.deleteNhanVien(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT); // Trả về HTTP 204 No Content
	}
}
