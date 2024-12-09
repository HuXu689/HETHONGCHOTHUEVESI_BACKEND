package com.webservice.hethongchothuevesi.controller;

import java.util.List;

import com.webservice.hethongchothuevesi.dto.dto.KhoaDaoTaoDTO;
import com.webservice.hethongchothuevesi.service.KhoaDaoTaoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/KhoaDaoTao")
@RequiredArgsConstructor
public class KhoaDaoTaoController {

	private final KhoaDaoTaoService khoaDaoTaoService;

	// Tạo mới khóa đào tạo
	@PostMapping
	public ResponseEntity<KhoaDaoTaoDTO> createKhoaDaoTao(@RequestBody KhoaDaoTaoDTO khoaDaoTaoDTO) {
		KhoaDaoTaoDTO createdKhoaDaoTao = khoaDaoTaoService.createKhoaDaoTao(khoaDaoTaoDTO);
		return new ResponseEntity<>(createdKhoaDaoTao, HttpStatus.CREATED);
	}

	// Lấy khóa đào tạo theo ID
	@GetMapping("/{id}")
	public ResponseEntity<KhoaDaoTaoDTO> getKhoaDaoTaoById(@PathVariable Integer id) {
		KhoaDaoTaoDTO khoaDaoTaoDTO = khoaDaoTaoService.getKhoaDaoTaoById(id);
		return new ResponseEntity<>(khoaDaoTaoDTO, HttpStatus.OK);
	}

	// Lấy tất cả khóa đào tạo chưa bị xóa mềm
	@GetMapping
	public ResponseEntity<List<KhoaDaoTaoDTO>> getAllKhoaDaoTao() {
		List<KhoaDaoTaoDTO> khoaDaoTaoList = khoaDaoTaoService.getAllKhoaDaoTao();
		return new ResponseEntity<>(khoaDaoTaoList, HttpStatus.OK);
	}

	// Cập nhật thông tin khóa đào tạo
	@PutMapping("/{id}")
	public ResponseEntity<KhoaDaoTaoDTO> updateKhoaDaoTao(@PathVariable Integer id, @RequestBody KhoaDaoTaoDTO dto) {
		KhoaDaoTaoDTO updatedKhoaDaoTao = khoaDaoTaoService.updateKhoaDaoTao(id, dto);
		return new ResponseEntity<>(updatedKhoaDaoTao, HttpStatus.OK);
	}

	// Xóa mềm khóa đào tạo
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteKhoaDaoTao(@PathVariable Integer id) {
		khoaDaoTaoService.deleteKhoaDaoTao(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT); // Trả về HTTP 204 No Content
	}
}
