package com.webservice.hethongchothuevesi.controller;

import com.webservice.hethongchothuevesi.dto.dto.DanhMucDichVuDTO;
import com.webservice.hethongchothuevesi.service.DanhMucDichVuService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/DanhMucDichVu")
@RequiredArgsConstructor
public class DanhMucDichVuController {

    private final DanhMucDichVuService danhMucDichVuService;

    // Tạo mới danh mục dịch vụ
    @PostMapping
    public ResponseEntity<DanhMucDichVuDTO> createDanhMucDichVu(@RequestBody DanhMucDichVuDTO danhMucDichVuDTO) {
        DanhMucDichVuDTO createdDanhMucDichVu = danhMucDichVuService.createDanhMucDichVu(danhMucDichVuDTO);
        return new ResponseEntity<>(createdDanhMucDichVu, HttpStatus.CREATED);
    }

    // Lấy danh mục dịch vụ theo ID
    @GetMapping("/{id}")
    public ResponseEntity<DanhMucDichVuDTO> getDanhMucDichVuById(@PathVariable Integer id) {
        DanhMucDichVuDTO danhMucDichVuDTO = danhMucDichVuService.getDanhMucDichVuById(id);
        return new ResponseEntity<>(danhMucDichVuDTO, HttpStatus.OK);
    }

    // Lấy tất cả danh mục dịch vụ chưa bị xóa mềm
    @GetMapping
    public ResponseEntity<List<DanhMucDichVuDTO>> getAllDanhMucDichVu() {
        List<DanhMucDichVuDTO> danhMucDichVuList = danhMucDichVuService.getAllDanhMucDichVu();
        return new ResponseEntity<>(danhMucDichVuList, HttpStatus.OK);
    }

    // Cập nhật thông tin danh mục dịch vụ
    @PutMapping("/{id}")
    public ResponseEntity<DanhMucDichVuDTO> updateDanhMucDichVu(@PathVariable Integer id, @RequestBody DanhMucDichVuDTO dto) {
        DanhMucDichVuDTO updatedDanhMucDichVu = danhMucDichVuService.updateDanhMucDichVu(id, dto);
        return new ResponseEntity<>(updatedDanhMucDichVu, HttpStatus.OK);
    }

    // Xóa mềm danh mục dịch vụ
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDanhMucDichVu(@PathVariable Integer id) {
        danhMucDichVuService.deleteDanhMucDichVu(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT); // Trả về HTTP 204 No Content
    }
}
