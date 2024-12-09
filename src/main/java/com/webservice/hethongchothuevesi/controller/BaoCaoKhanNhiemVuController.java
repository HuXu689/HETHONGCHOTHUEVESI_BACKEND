package com.webservice.hethongchothuevesi.controller;

import java.util.List;

import com.webservice.hethongchothuevesi.dto.dto.BaoCaoKhanNhiemVuDTO;
import com.webservice.hethongchothuevesi.service.BaoCaoKhanNhiemVuService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/BaoCaoKhanNhiemVu")
@RequiredArgsConstructor
public class BaoCaoKhanNhiemVuController {

	private final BaoCaoKhanNhiemVuService baoCaoKhanNhiemVuService;

	// Tạo mới báo cáo khẩn
	@PostMapping
	public ResponseEntity<BaoCaoKhanNhiemVuDTO> createBaoCaoKhanNhiemVu(
			@RequestBody BaoCaoKhanNhiemVuDTO baoCaoKhanNhiemVuDTO) {
		BaoCaoKhanNhiemVuDTO createdBaoCaoKhanNhiemVu =
				baoCaoKhanNhiemVuService.createBaoCaoKhanNhiemVu(baoCaoKhanNhiemVuDTO);
		return new ResponseEntity<>(createdBaoCaoKhanNhiemVu, HttpStatus.CREATED);
	}

	// Lấy báo cáo khẩn theo ID
	@GetMapping("/{id}")
	public ResponseEntity<BaoCaoKhanNhiemVuDTO> getBaoCaoKhanNhiemVuById(@PathVariable Integer id) {
		BaoCaoKhanNhiemVuDTO baoCaoKhanNhiemVuDTO = baoCaoKhanNhiemVuService.getBaoCaoKhanNhiemVuById(id);
		return new ResponseEntity<>(baoCaoKhanNhiemVuDTO, HttpStatus.OK);
	}

	// Lấy tất cả báo cáo khẩn chưa bị xóa mềm
	@GetMapping
	public ResponseEntity<List<BaoCaoKhanNhiemVuDTO>> getAllBaoCaoKhanNhiemVu() {
		List<BaoCaoKhanNhiemVuDTO> baoCaoKhanNhiemVuList = baoCaoKhanNhiemVuService.getAllBaoCaoKhanNhiemVu();
		return new ResponseEntity<>(baoCaoKhanNhiemVuList, HttpStatus.OK);
	}

	// Cập nhật thông tin báo cáo khẩn
	@PutMapping("/{id}")
	public ResponseEntity<BaoCaoKhanNhiemVuDTO> updateBaoCaoKhanNhiemVu(
			@PathVariable Integer id, @RequestBody BaoCaoKhanNhiemVuDTO dto) {
		BaoCaoKhanNhiemVuDTO updatedBaoCaoKhanNhiemVu = baoCaoKhanNhiemVuService.updateBaoCaoKhanNhiemVu(id, dto);
		return new ResponseEntity<>(updatedBaoCaoKhanNhiemVu, HttpStatus.OK);
	}

	// Xóa mềm báo cáo khẩn
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteBaoCaoKhanNhiemVu(@PathVariable Integer id) {
		baoCaoKhanNhiemVuService.deleteBaoCaoKhanNhiemVu(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT); // Trả về HTTP 204 No Content
	}
}
