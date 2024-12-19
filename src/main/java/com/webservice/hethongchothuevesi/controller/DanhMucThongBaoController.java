package com.webservice.hethongchothuevesi.controller;

import java.util.List;

import com.webservice.hethongchothuevesi.dto.dto.DanhMucThongBaoDTO;
import com.webservice.hethongchothuevesi.service.DanhMucThongBaoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/DanhMucThongBao")
@RequiredArgsConstructor
public class DanhMucThongBaoController {

	private final DanhMucThongBaoService danhMucThongBaoService;

	// Tạo mới danh mục thông báo
	@PostMapping
	public ResponseEntity<DanhMucThongBaoDTO> createDanhMucThongBao(
			@RequestBody DanhMucThongBaoDTO danhMucThongBaoDTO) {
		DanhMucThongBaoDTO createdDanhMucThongBao = danhMucThongBaoService.createDanhMucThongBao(danhMucThongBaoDTO);
		return new ResponseEntity<>(createdDanhMucThongBao, HttpStatus.CREATED);
	}

	// Lấy danh mục thông báo theo ID
	@GetMapping("/{id}")
	public ResponseEntity<DanhMucThongBaoDTO> getDanhMucThongBaoById(@PathVariable Integer id) {
		DanhMucThongBaoDTO danhMucThongBaoDTO = danhMucThongBaoService.getDanhMucThongBaoById(id);
		return new ResponseEntity<>(danhMucThongBaoDTO, HttpStatus.OK);
	}

	// Lấy tất cả danh mục thông báo chưa bị xóa mềm
	@GetMapping
	public ResponseEntity<List<DanhMucThongBaoDTO>> getAllDanhMucThongBao() {
		List<DanhMucThongBaoDTO> danhMucThongBaoList = danhMucThongBaoService.getAllDanhMucThongBao();
		return new ResponseEntity<>(danhMucThongBaoList, HttpStatus.OK);
	}

	// Cập nhật thông tin danh mục thông báo
	@PutMapping("/{id}")
	public ResponseEntity<DanhMucThongBaoDTO> updateDanhMucThongBao(
			@PathVariable Integer id, @RequestBody DanhMucThongBaoDTO dto) {
		DanhMucThongBaoDTO updatedDanhMucThongBao = danhMucThongBaoService.updateDanhMucThongBao(id, dto);
		return new ResponseEntity<>(updatedDanhMucThongBao, HttpStatus.OK);
	}

	// Xóa mềm danh mục thông báo
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteDanhMucThongBao(@PathVariable Integer id) {
		danhMucThongBaoService.deleteDanhMucThongBao(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT); // Trả về HTTP 204 No Content
	}
}
