package com.webservice.hethongchothuevesi.service;

import com.webservice.hethongchothuevesi.entity.NguoiDung;
import com.webservice.hethongchothuevesi.entity.TepHopDong;
import com.webservice.hethongchothuevesi.entity.YeuCauDichVu;
import com.webservice.hethongchothuevesi.exception.ResourceNotFoundException;
import com.webservice.hethongchothuevesi.repository.NguoiDungRepository;
import com.webservice.hethongchothuevesi.repository.TepHopDongRepository;
import com.webservice.hethongchothuevesi.repository.YeuCauDichVuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Map;

@Service
public class ImageService {

    @Autowired
    private CloudinaryService cloudinaryService;

    @Autowired
    private NguoiDungRepository nguoiDungRepository;

    @Autowired
    private TepHopDongRepository tepHopDongRepository;

    @Autowired
    private YeuCauDichVuRepository yeuCauDichVuRepository;

    /**
     * Upload avatar cho người dùng
     *
     * @param idNguoiDung ID của người dùng
     * @param file        Ảnh avatar
     * @return Người dùng đã cập nhật
     * @throws IOException nếu có lỗi khi upload
     */
    public NguoiDung uploadAvatar(Integer idNguoiDung, MultipartFile file) throws IOException {
        Map<String, Object> result = cloudinaryService.uploadFile(file);
        String secureUrl = (String) result.get("secure_url");
        String publicId = (String) result.get("public_id");

        // Cập nhật người dùng
        NguoiDung nguoiDung = nguoiDungRepository.findById(idNguoiDung)
                .orElseThrow(() -> new ResourceNotFoundException("Người dùng không tồn tại với ID: " + idNguoiDung));

        // Nếu người dùng đã có avatar trước đó, xoá ảnh cũ
        if (nguoiDung.getIdAnhDaiDien() != null && !nguoiDung.getIdAnhDaiDien().isEmpty()) {
            cloudinaryService.deleteFile(nguoiDung.getIdAnhDaiDien());
        }

        nguoiDung.setAnhDaiDien(secureUrl);
        nguoiDung.setIdAnhDaiDien(publicId);
        return nguoiDungRepository.save(nguoiDung);
    }

    /**
     * Upload tệp hợp đồng
     *
     * @param idTepHopDong ID của tệp hợp đồng
     * @param file         Tệp hợp đồng
     * @return Tệp hợp đồng đã cập nhật
     * @throws IOException nếu có lỗi khi upload
     */
    public TepHopDong uploadContractFile(Integer idTepHopDong, MultipartFile file) throws IOException {
        Map result = cloudinaryService.uploadFile(file);
        String secureUrl = (String) result.get("secure_url");

        // Cập nhật tệp hợp đồng
        TepHopDong tepHopDong = tepHopDongRepository.findById(idTepHopDong)
                .orElseThrow(() -> new ResourceNotFoundException("Tệp hợp đồng không tồn tại với ID: " + idTepHopDong));

        tepHopDong.setTepDinhKem(secureUrl);
        return tepHopDongRepository.save(tepHopDong);
    }

    /**
     * Upload ảnh cho yêu cầu dịch vụ
     *
     * @param idYeuCauDichVu ID của yêu cầu dịch vụ
     * @param file           Ảnh yêu cầu dịch vụ
     * @return Yêu cầu dịch vụ đã cập nhật
     * @throws IOException nếu có lỗi khi upload
     */
    public YeuCauDichVu uploadServiceRequestImage(Integer idYeuCauDichVu, MultipartFile file) throws IOException {
        Map result = cloudinaryService.uploadFile(file);
        String secureUrl = (String) result.get("secure_url");

        // Cập nhật yêu cầu dịch vụ
        YeuCauDichVu yeuCauDichVu = yeuCauDichVuRepository.findById(idYeuCauDichVu)
                .orElseThrow(() -> new ResourceNotFoundException("Yêu cầu dịch vụ không tồn tại với ID: " + idYeuCauDichVu));

        yeuCauDichVu.setAnh(secureUrl);
        return yeuCauDichVuRepository.save(yeuCauDichVu);
    }
}
