package com.webservice.hethongchothuevesi.controller;

import com.webservice.hethongchothuevesi.service.CloudinaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Map;

@RestController
@RequestMapping("/images")
public class ImageController {

    @Autowired
    private CloudinaryService cloudinaryService;

    /**
     * Endpoint để upload ảnh lên Cloudinary
     *
     * @param file Ảnh được upload
     * @return URL ảnh từ Cloudinary
     */
    @PostMapping("/upload")
    public ResponseEntity<?> uploadImage(@RequestParam("file") MultipartFile file) {
        try {
            Map<String, Object> uploadResult = cloudinaryService.uploadFile(file);
            String secureUrl = (String) uploadResult.get("secure_url");
            String publicId = (String) uploadResult.get("public_id");

            // Trả về URL và public_id
            return ResponseEntity.ok(Map.of(
                    "secure_url", secureUrl,
                    "public_id", publicId
            ));
        } catch (IllegalArgumentException ex) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Map.of("error", ex.getMessage()));
        } catch (IOException ex) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(Map.of("error", "Lỗi upload ảnh: " + ex.getMessage()));
        }
    }

    /**
     * Endpoint để xoá ảnh khỏi Cloudinary
     *
     * @param publicId public_id của ảnh trên Cloudinary
     * @return Kết quả xoá ảnh
     */
    @DeleteMapping("/delete")
    public ResponseEntity<?> deleteImage(@RequestParam("publicId") String publicId) {
        try {
            Map<String, Object> deleteResult = cloudinaryService.deleteFile(publicId);
            return ResponseEntity.ok(deleteResult);
        } catch (IOException ex) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(Map.of("error", "Lỗi xoá ảnh: " + ex.getMessage()));
        }
    }
}
