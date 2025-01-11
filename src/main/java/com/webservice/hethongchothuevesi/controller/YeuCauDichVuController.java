package com.webservice.hethongchothuevesi.controller;

import com.webservice.hethongchothuevesi.dto.dto.YeuCauDichVuDTO;
import com.webservice.hethongchothuevesi.entity.YeuCauDichVu;
import com.webservice.hethongchothuevesi.exception.ResourceNotFoundException;
import com.webservice.hethongchothuevesi.service.CloudinaryService;
import com.webservice.hethongchothuevesi.service.ImageService;
import com.webservice.hethongchothuevesi.service.YeuCauDichVuService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

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

    @Autowired
    private ImageService imageService;

    /**
     * Endpoint để upload ảnh cho yêu cầu dịch vụ
     *
     * @param id   ID của yêu cầu dịch vụ
     * @param file Ảnh yêu cầu dịch vụ
     * @return Yêu cầu dịch vụ đã cập nhật với ảnh mới
     */
    @Autowired
    private CloudinaryService cloudinaryService;

    // Phương thức upload ảnh khách hàng
    @PostMapping("/{id}/upload-anh")
    public ResponseEntity<?> uploadCustomerImage(
            @PathVariable Integer id,
            @RequestParam("file") MultipartFile file) {
        try {
            YeuCauDichVu updatedRequest = yeuCauDichVuService.uploadCustomerImage(id, file);
            return ResponseEntity.ok(updatedRequest);
        } catch (ResourceNotFoundException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
        } catch (IOException ex) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Lỗi upload ảnh: " + ex.getMessage());
        }
    }

}
