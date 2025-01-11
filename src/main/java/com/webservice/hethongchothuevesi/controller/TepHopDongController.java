// src/main/java/com/webservice/hethongchothuevesi/controller/TepHopDongController.java

package com.webservice.hethongchothuevesi.controller;

import com.webservice.hethongchothuevesi.entity.TepHopDong;
import com.webservice.hethongchothuevesi.exception.ResourceNotFoundException;
import com.webservice.hethongchothuevesi.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/TepHopDong")
public class TepHopDongController {

    @Autowired
    private ImageService imageService;

    /**
     * Endpoint để upload tệp hợp đồng
     *
     * @param id   ID của tệp hợp đồng
     * @param file Tệp hợp đồng
     * @return Tệp hợp đồng đã cập nhật với tệp mới
     */
    @PostMapping("/{id}/upload")
    public ResponseEntity<?> uploadContractFile(
            @PathVariable Integer id,
            @RequestParam("file") MultipartFile file) {
        try {
            TepHopDong updatedContractFile = imageService.uploadContractFile(id, file);
            return ResponseEntity.ok(updatedContractFile);
        } catch (ResourceNotFoundException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
        } catch (IOException ex) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Lỗi upload tệp: " + ex.getMessage());
        }
    }
}
