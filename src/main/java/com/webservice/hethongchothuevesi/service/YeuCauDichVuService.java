package com.webservice.hethongchothuevesi.service;

import com.webservice.hethongchothuevesi.dto.dto.YeuCauDichVuDTO;
import com.webservice.hethongchothuevesi.entity.DanhMucDichVu;
import com.webservice.hethongchothuevesi.entity.YeuCauDichVu;
import com.webservice.hethongchothuevesi.exception.ResourceNotFoundException;
import com.webservice.hethongchothuevesi.mapper.YeuCauDichVuMapper;
import com.webservice.hethongchothuevesi.respository.DanhMucDichVuRepository;
import com.webservice.hethongchothuevesi.respository.YeuCauDichVuRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class YeuCauDichVuService {

    YeuCauDichVuRepository yeuCauDichVuRepository;
    YeuCauDichVuMapper yeuCauDichVuMapper;
    DanhMucDichVuRepository danhMucDichVuRepository;
    EmailService emailService;
    NguoiDungService nguoiDungService;

    // Create: Tạo mới data
    public YeuCauDichVuDTO createYeuCauDichVu(YeuCauDichVuDTO yeuCauDichVuDTO) {
        YeuCauDichVu yeuCauDichVu = yeuCauDichVuMapper.toEntity(yeuCauDichVuDTO);
        yeuCauDichVu.setTrangThai("Chưa xác nhận");
        yeuCauDichVu = yeuCauDichVuRepository.save(yeuCauDichVu);
        return yeuCauDichVuMapper.toDTO(yeuCauDichVu);
    }

    // Read (get by id): Lấy data theo ID và lấy tên danh mục dịch vụ từ bảng DanhMucDichVu
    public YeuCauDichVuDTO getYeuCauDichVuById(Integer id) {
        YeuCauDichVu yeuCauDichVu = yeuCauDichVuRepository
                .findByIdYeuCauDichVuAndNgayXoaIsNull(id)
                .orElseThrow(() -> new RuntimeException("Yêu cầu dịch vụ không tồn tại"));

        // Lấy tên danh mục dịch vụ từ bảng DanhMucDichVu
        Optional<String> tenDanhMucDichVu = danhMucDichVuRepository
                .findByIdDanhMucDichVu(yeuCauDichVu.getIdDanhMucDichVu())
                .map(DanhMucDichVu::getTenDichVu);

        YeuCauDichVuDTO yeuCauDichVuDTO = yeuCauDichVuMapper.toDTO(yeuCauDichVu);
        tenDanhMucDichVu.ifPresent(yeuCauDichVuDTO::setTenDanhMucDichVu);

        return yeuCauDichVuDTO;
    }

    // Read (get all): Lấy tất cả data chưa bị xóa mềm
    public List<YeuCauDichVuDTO> getAllYeuCauDichVu() {
        List<YeuCauDichVu> yeuCauDichVus = yeuCauDichVuRepository.findByNgayXoaIsNull();
        List<YeuCauDichVuDTO> yeuCauDichVuDTOs = yeuCauDichVuMapper.toListDto(yeuCauDichVus);

        // Lấy tên danh mục dịch vụ cho từng yêu cầu dịch vụ
        for (YeuCauDichVuDTO dto : yeuCauDichVuDTOs) {
            Optional<String> tenDanhMucDichVu = danhMucDichVuRepository
                    .findByIdDanhMucDichVu(dto.getIdDanhMucDichVu())
                    .map(DanhMucDichVu::getTenDichVu);

            tenDanhMucDichVu.ifPresent(dto::setTenDanhMucDichVu);
        }

        return yeuCauDichVuDTOs;
    }

    // Read (get all by idNguoiDung): Lấy tất cả data chưa bị xóa mềm với idNguoiDung
    public List<YeuCauDichVuDTO> getAllYeuCauDichVuByIdNguoiDung(int idNguoiDung) {
        List<YeuCauDichVu> yeuCauDichVus = yeuCauDichVuRepository.findByIdNguoiDungAndNgayXoaIsNull(idNguoiDung);
        List<YeuCauDichVuDTO> yeuCauDichVuDTOs = yeuCauDichVuMapper.toListDto(yeuCauDichVus);

        // Lấy tên danh mục dịch vụ cho từng yêu cầu dịch vụ
        for (YeuCauDichVuDTO dto : yeuCauDichVuDTOs) {
            Optional<String> tenDanhMucDichVu = danhMucDichVuRepository
                    .findByIdDanhMucDichVu(dto.getIdDanhMucDichVu())
                    .map(DanhMucDichVu::getTenDichVu);

            tenDanhMucDichVu.ifPresent(dto::setTenDanhMucDichVu);
        }

        return yeuCauDichVuDTOs;
    }

    // Update: Cập nhật thông tin
    public YeuCauDichVuDTO updateYeuCauDichVu(Integer id, YeuCauDichVuDTO request) {
        YeuCauDichVu yeuCauDichVu = yeuCauDichVuRepository
                .findByIdYeuCauDichVuAndNgayXoaIsNull(id)
                .orElseThrow(() -> new RuntimeException("Yêu cầu dịch vụ không tồn tại"));

        // Cập nhật thông tin từ request
        yeuCauDichVuMapper.updateEntity(yeuCauDichVu, request);
        yeuCauDichVu = yeuCauDichVuRepository.save(yeuCauDichVu);
        // Kiểm tra trạng thái và gửi email nếu trạng thái là "Không xác nhận"
        if ("Không xác nhận".equals(request.getTrangThai())) {
            try {
                // Lấy thông tin người dùng
                String emailNguoiDung = nguoiDungService
                        .getRequestById(yeuCauDichVu.getIdNguoiDung())
                        .getEmail();

                // Tạo nội dung email chi tiết
                String noiDungEmail = String.format(
                        "Xin chào,<br><br>"
                                + "Yêu cầu dịch vụ của bạn đã không được xác nhận. Vui lòng kiểm tra lại thông tin.<br><br>"
                                + "Chi tiết yêu cầu dịch vụ:<br>"
                                + "- Mã yêu cầu: %d<br>"
                                + "- Họ tên khách hàng: %s<br>"
                                + "- Địa điểm: %s<br>"
                                + "- Ngày bắt đầu: %s<br>"
                                + "- Ngày kết thúc: %s<br><br>"
                                + "Lý do không xác nhận: %s<br><br>"
                                + "Trân trọng,<br>"
                                + "Đội ngũ hỗ trợ BODYGUARD",
                        yeuCauDichVu.getIdYeuCauDichVu(),
                        yeuCauDichVu.getHoTenKhachHang(),
                        yeuCauDichVu.getDiaDiem(),
                        yeuCauDichVu.getNgayBatDau(),
                        yeuCauDichVu.getNgayKetThuc(),
                        yeuCauDichVu.getNoiDungTraLoi());

                // Gửi email
                emailService.sendEmail(
                        emailNguoiDung, // Email người dùng
                        "Yêu cầu dịch vụ không được xác nhận", // Tiêu đề
                        noiDungEmail, // Nội dung email
                        null // Không có file đính kèm
                );

                log.info("Đã gửi email thông báo không xác nhận tới: {}", emailNguoiDung);
            } catch (Exception e) {
                log.error("Lỗi khi gửi email thông báo trạng thái không xác nhận: ", e);
                throw new RuntimeException("Lỗi khi gửi email thông báo trạng thái không xác nhận.");
            }
        }
        return yeuCauDichVuMapper.toDTO(yeuCauDichVu);
    }

    // Soft Delete: Xóa mềm (đặt ngày xóa)
    public void deleteYeuCauDichVu(Integer id) {
        YeuCauDichVu yeuCauDichVu = yeuCauDichVuRepository
                .findById(id)
                .orElseThrow(() -> new RuntimeException("Yêu cầu dịch vụ không tồn tại"));

        yeuCauDichVu.setNgayXoa(LocalDateTime.now());
        yeuCauDichVuRepository.save(yeuCauDichVu);
    }

    @Autowired
    private CloudinaryService cloudinaryService;

    /**
     * Upload ảnh khách hàng cho yêu cầu dịch vụ và cập nhật vào database
     *
     * @param id   ID của yêu cầu dịch vụ
     * @param file Tệp ảnh được upload
     * @return YeuCauDichVu đã được cập nhật
     * @throws IOException nếu có lỗi khi upload
     */
    public YeuCauDichVu uploadCustomerImage(Integer id, MultipartFile file) throws IOException {
        // Upload ảnh lên Cloudinary
        Map<String, Object> result = cloudinaryService.uploadFile(file);
        String secureUrl = (String) result.get("secure_url");
        String publicId = (String) result.get("public_id");

        // Tìm yêu cầu dịch vụ theo ID
        YeuCauDichVu yeuCauDichVu = yeuCauDichVuRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Yêu cầu dịch vụ không tồn tại với ID: " + id));

        // Nếu đã có ảnh trước đó, xoá ảnh cũ khỏi Cloudinary
        if (yeuCauDichVu.getIdAnh() != null && !yeuCauDichVu.getIdAnh().isEmpty()) {
            cloudinaryService.deleteFile(yeuCauDichVu.getIdAnh());
        }

        // Cập nhật thông tin ảnh mới
        yeuCauDichVu.setAnh(secureUrl);
        yeuCauDichVu.setIdAnh(publicId);

        // Lưu lại yêu cầu dịch vụ
        return yeuCauDichVuRepository.save(yeuCauDichVu);
    }

}
