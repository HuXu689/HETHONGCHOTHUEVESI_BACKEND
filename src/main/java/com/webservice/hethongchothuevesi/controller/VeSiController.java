package com.webservice.hethongchothuevesi.controller;

import java.util.List;

import com.webservice.hethongchothuevesi.dto.dto.VeSiDTO;
import com.webservice.hethongchothuevesi.service.VeSiService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/VeSi")
@RequiredArgsConstructor
public class VeSiController {

	private final VeSiService veSiService;

	// Tạo mới vệ sĩ
	@PostMapping
	public ResponseEntity<VeSiDTO> createVeSi(@RequestBody VeSiDTO veSiDTO) {
		VeSiDTO createdVeSi = veSiService.createVeSi(veSiDTO);
		return new ResponseEntity<>(createdVeSi, HttpStatus.CREATED);
	}

	// Lấy vệ sĩ theo ID
	@GetMapping("/{id}")
	public ResponseEntity<VeSiDTO> getVeSiById(@PathVariable Integer id) {
		VeSiDTO veSiDTO = veSiService.getVeSiById(id);
		return new ResponseEntity<>(veSiDTO, HttpStatus.OK);
	}

	// Lấy tất cả vệ sĩ chưa bị xóa mềm
	@GetMapping
	public ResponseEntity<List<VeSiDTO>> getAllVeSi() {
		List<VeSiDTO> veSiList = veSiService.getAllVeSi();
		return new ResponseEntity<>(veSiList, HttpStatus.OK);
	}

	// Cập nhật thông tin vệ sĩ
	@PutMapping("/{id}")
	public ResponseEntity<VeSiDTO> updateVeSi(@PathVariable Integer id, @RequestBody VeSiDTO dto) {
		VeSiDTO updatedVeSi = veSiService.updateVeSi(id, dto);
		return new ResponseEntity<>(updatedVeSi, HttpStatus.OK);
	}

	// Xóa mềm vệ sĩ
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteVeSi(@PathVariable Integer id) {
		veSiService.deleteVeSi(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT); // Trả về HTTP 204 No Content
	}
}
