package com.webservice.hethongchothuevesi.service;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Map;

@Slf4j
@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CloudinaryService {

    @Autowired
    private Cloudinary cloudinary;

    /**
     * Upload file lên Cloudinary
     *
     * @param file MultipartFile cần upload
     * @return Map chứa thông tin file từ Cloudinary
     * @throws IOException nếu có lỗi khi upload
     */
    public Map uploadFile(MultipartFile file) throws IOException {
        // Kiểm tra định dạng và kích thước file (đã được xử lý ở controller)
        return cloudinary.uploader().upload(file.getBytes(), ObjectUtils.emptyMap());
    }

    /**
     * Xoá file khỏi Cloudinary dựa vào public_id
     *
     * @param publicId public_id của file trên Cloudinary
     * @return Map chứa kết quả xoá file
     * @throws IOException nếu có lỗi khi xoá
     */
    public Map<String, Object> deleteFile(String publicId) throws IOException {
        return cloudinary.uploader().destroy(publicId, ObjectUtils.emptyMap());
    }
}

