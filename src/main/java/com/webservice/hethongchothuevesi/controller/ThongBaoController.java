package com.webservice.hethongchothuevesi.controller;

import java.util.List;

import com.webservice.hethongchothuevesi.dto.dto.ThongBaoDTO;
import com.webservice.hethongchothuevesi.service.ThongBaoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ThongBao")
@RequiredArgsConstructor
public class ThongBaoController {

	private final ThongBaoService thongBaoService;

	// Tạo mới thông báo
	@PostMapping
	public ResponseEntity<ThongBaoDTO> createThongBao(@RequestBody ThongBaoDTO thongBaoDTO) {
		ThongBaoDTO createdThongBao = thongBaoService.createThongBao(thongBaoDTO);
		return new ResponseEntity<>(createdThongBao, HttpStatus.CREATED);
	}

	// Lấy thông báo theo ID
	@GetMapping("/{id}")
	public ResponseEntity<ThongBaoDTO> getThongBaoById(@PathVariable Integer id) {
		ThongBaoDTO thongBaoDTO = thongBaoService.getThongBaoById(id);
		return new ResponseEntity<>(thongBaoDTO, HttpStatus.OK);
	}

	// Lấy tất cả thông báo chưa bị xóa mềm
	@GetMapping
	public ResponseEntity<List<ThongBaoDTO>> getAllThongBao() {
		List<ThongBaoDTO> thongBaoList = thongBaoService.getAllThongBao();
		return new ResponseEntity<>(thongBaoList, HttpStatus.OK);
	}

	// Cập nhật thông tin thông báo
	@PutMapping("/{id}")
	public ResponseEntity<ThongBaoDTO> updateThongBao(@PathVariable Integer id, @RequestBody ThongBaoDTO dto) {
		ThongBaoDTO updatedThongBao = thongBaoService.updateThongBao(id, dto);
		return new ResponseEntity<>(updatedThongBao, HttpStatus.OK);
	}

	// Xóa mềm thông báo
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteThongBao(@PathVariable Integer id) {
		thongBaoService.deleteThongBao(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT); // Trả về HTTP 204 No Content
	}
}
