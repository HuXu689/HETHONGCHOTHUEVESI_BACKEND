package com.webservice.hethongchothuevesi.controller;

import java.util.List;

import com.webservice.hethongchothuevesi.dto.dto.YeuCauDichVuDTO;
import com.webservice.hethongchothuevesi.service.YeuCauDichVuService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/YeuCauDichVu")
@RequiredArgsConstructor
public class YeuCauDichVuController {

	private final YeuCauDichVuService yeuCauDichVuService;

	// Tạo mới yêu cầu dịch vụ
	@PostMapping
	public ResponseEntity<YeuCauDichVuDTO> createYeuCauDichVu(@RequestBody YeuCauDichVuDTO yeuCauDichVuDTO) {
		YeuCauDichVuDTO createdYeuCauDichVu = yeuCauDichVuService.createYeuCauDichVu(yeuCauDichVuDTO);
		return new ResponseEntity<>(createdYeuCauDichVu, HttpStatus.CREATED);
	}

	// Lấy yêu cầu dịch vụ theo ID
	@GetMapping("/{id}")
	public ResponseEntity<YeuCauDichVuDTO> getYeuCauDichVuById(@PathVariable Integer id) {
		YeuCauDichVuDTO yeuCauDichVuDTO = yeuCauDichVuService.getYeuCauDichVuById(id);
		return new ResponseEntity<>(yeuCauDichVuDTO, HttpStatus.OK);
	}

	// Lấy tất cả yêu cầu dịch vụ chưa bị xóa mềm
	@GetMapping
	public ResponseEntity<List<YeuCauDichVuDTO>> getAllYeuCauDichVu() {
		List<YeuCauDichVuDTO> yeuCauDichVuList = yeuCauDichVuService.getAllYeuCauDichVu();
		return new ResponseEntity<>(yeuCauDichVuList, HttpStatus.OK);
	}

	// Lấy tất cả yêu cầu dịch vụ chưa bị xóa mềm
	@GetMapping("/GetAllByIdNguoiDung/{idNguoiDung}")
	public ResponseEntity<List<YeuCauDichVuDTO>> getAllYeuCauDichVuByIdNguoiDung(
			@PathVariable("idNguoiDung") int idNguoiDung) {
		List<YeuCauDichVuDTO> yeuCauDichVuList = yeuCauDichVuService.getAllYeuCauDichVuByIdNguoiDung(idNguoiDung);
		return new ResponseEntity<>(yeuCauDichVuList, HttpStatus.OK);
	}

	// Cập nhật thông tin yêu cầu dịch vụ
	@PutMapping("/{id}")
	public ResponseEntity<YeuCauDichVuDTO> updateYeuCauDichVu(
			@PathVariable Integer id, @RequestBody YeuCauDichVuDTO dto) {
		YeuCauDichVuDTO updatedYeuCauDichVu = yeuCauDichVuService.updateYeuCauDichVu(id, dto);
		return new ResponseEntity<>(updatedYeuCauDichVu, HttpStatus.OK);
	}

	// Xóa mềm yêu cầu dịch vụ
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteYeuCauDichVu(@PathVariable Integer id) {
		yeuCauDichVuService.deleteYeuCauDichVu(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT); // Trả về HTTP 204 No Content
	}
}
