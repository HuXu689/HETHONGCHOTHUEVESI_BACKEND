package com.webservice.hethongchothuevesi.controller;

import java.util.List;

import com.webservice.hethongchothuevesi.dto.dto.VeSiKhoaDaoTaoDTO;
import com.webservice.hethongchothuevesi.service.VeSiKhoaDaoTaoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/VeSiKhoaDaoTao")
@RequiredArgsConstructor
public class VeSiKhoaDaoTaoController {

	private final VeSiKhoaDaoTaoService veSiKhoaDaoTaoService;

	// Tạo mới vệ sĩ khóa đào tạo
	@PostMapping
	public ResponseEntity<VeSiKhoaDaoTaoDTO> createVeSiKhoaDaoTao(@RequestBody VeSiKhoaDaoTaoDTO veSiKhoaDaoTaoDTO) {
		VeSiKhoaDaoTaoDTO createdVeSiKhoaDaoTao = veSiKhoaDaoTaoService.createVeSiKhoaDaoTao(veSiKhoaDaoTaoDTO);
		return new ResponseEntity<>(createdVeSiKhoaDaoTao, HttpStatus.CREATED);
	}

	// Lấy vệ sĩ khóa đào tạo theo ID
	@GetMapping("/{id}")
	public ResponseEntity<VeSiKhoaDaoTaoDTO> getVeSiKhoaDaoTaoById(@PathVariable Integer id) {
		VeSiKhoaDaoTaoDTO veSiKhoaDaoTaoDTO = veSiKhoaDaoTaoService.getVeSiKhoaDaoTaoById(id);
		return new ResponseEntity<>(veSiKhoaDaoTaoDTO, HttpStatus.OK);
	}

	// Lấy tất cả vệ sĩ khóa đào tạo chưa bị xóa mềm
	@GetMapping
	public ResponseEntity<List<VeSiKhoaDaoTaoDTO>> getAllVeSiKhoaDaoTao() {
		List<VeSiKhoaDaoTaoDTO> veSiKhoaDaoTaoList = veSiKhoaDaoTaoService.getAllVeSiKhoaDaoTao();
		return new ResponseEntity<>(veSiKhoaDaoTaoList, HttpStatus.OK);
	}

	// Cập nhật thông tin vệ sĩ khóa đào tạo
	@PutMapping("/{id}")
	public ResponseEntity<VeSiKhoaDaoTaoDTO> updateVeSiKhoaDaoTao(
			@PathVariable Integer id, @RequestBody VeSiKhoaDaoTaoDTO dto) {
		VeSiKhoaDaoTaoDTO updatedVeSiKhoaDaoTao = veSiKhoaDaoTaoService.updateVeSiKhoaDaoTao(id, dto);
		return new ResponseEntity<>(updatedVeSiKhoaDaoTao, HttpStatus.OK);
	}

	// Xóa mềm vệ sĩ khóa đào tạo
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteVeSiKhoaDaoTao(@PathVariable Integer id) {
		veSiKhoaDaoTaoService.deleteVeSiKhoaDaoTao(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT); // Trả về HTTP 204 No Content
	}
}
