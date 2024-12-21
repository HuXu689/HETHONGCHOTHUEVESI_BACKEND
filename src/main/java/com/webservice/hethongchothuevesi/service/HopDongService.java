package com.webservice.hethongchothuevesi.service;

import com.webservice.hethongchothuevesi.dto.dto.HopDongDTO;
import com.webservice.hethongchothuevesi.entity.HopDong;
import com.webservice.hethongchothuevesi.mapper.HopDongMapper;
import com.webservice.hethongchothuevesi.respository.HopDongRepository;
import com.webservice.hethongchothuevesi.respository.YeuCauDichVuRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class HopDongService {

    HopDongRepository hopDongRepository;
    HopDongMapper hopDongMapper;
    NguoiDungService nguoiDungService;
    YeuCauDichVuRepository yeuCauDichVuRepository;
    EmailService emailService;

    // Create: Tạo mới data
    public HopDongDTO createHopDong(HopDongDTO hopDongDTO) {
        HopDong hopDong = hopDongMapper.toEntity(hopDongDTO);
        hopDong.setTrangThai("Chưa phân công");
        hopDong = hopDongRepository.save(hopDong);

        // Lấy thông tin email người dùng
        String emailNguoiDung = null;
        //        String emailNguoiDung =
        // nguoiDungService.getRequestById(yeuCauDichVuRepository.findByIdYeuCauDichVu(hopDong.getIdYeuCauDichVu()).get().getIdNguoiDung()).getEmail();
        //        log.info("Email người dùng: {}", emailNguoiDung);
        if (nguoiDungService
                .getRequestById(yeuCauDichVuRepository
                        .findByIdYeuCauDichVu(hopDong.getIdYeuCauDichVu())
                        .get()
                        .getIdNguoiDung())
                .getEmail()
                == null) {
            emailNguoiDung = "xuanhuynh543@gmail.com";
        } else {
            emailNguoiDung = nguoiDungService
                    .getRequestById(yeuCauDichVuRepository
                            .findByIdYeuCauDichVu(hopDong.getIdYeuCauDichVu())
                            .get()
                            .getIdNguoiDung())
                    .getEmail();
        }
        try {
            // Định nghĩa định dạng ngày giờ theo kiểu Việt Nam
            DateTimeFormatter vietnamFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
            String noiDungEmail = String.format(
                    "Xin chào,<br><br>"
                            + "Yêu cầu dịch vụ của bạn đã được duyệt. Xin vui lòng chờ chúng tôi liên hệ để tiến hành tạo hợp đồng.<br><br>"
                            + "Chi tiết yêu cầu dịch vụ:<br>"
                            + "- Mã hợp đồng: %d<br>"
                            + "- Họ tên khách hàng: %s<br>"
                            + "- Địa điểm: %s<br>"
                            + "- Số lượng vệ sĩ: %d<br>"
                            + "- Thời gian bắt đầu: %s<br>"
                            + "- Thời gian kết thúc: %s<br><br>"
                            + "Trân trọng,<br>"
                            + "Đội ngũ hỗ trợ BODYGUARD",
                    hopDong.getIdHopDong(),
                    hopDong.getHoTenKhachHang(),
                    hopDong.getDiaDiem(),
                    hopDong.getSoLuongVeSi(),
                    hopDong.getThoiGianBatDau().format(vietnamFormatter),
                    hopDong.getThoiGianKetThuc().format(vietnamFormatter));

            // Gửi email
            emailService.sendEmail(
                    emailNguoiDung, // Email người dùng
                    "Yêu cầu dịch vụ được xác nhận", // Tiêu đề
                    noiDungEmail, // Nội dung email
                    null // Không có file đính kèm
            );

            log.info("Đã gửi email thông báo đã xác nhận tới: {}", emailNguoiDung);
        } catch (Exception e) {
            log.error("Lỗi khi gửi email thông báo trạng thái đã xác nhận: ", e);
            throw new RuntimeException("Lỗi khi gửi email thông báo trạng thái đã xác nhận.");
        }

        return hopDongMapper.toDTO(hopDong);
    }

    // Read (get by id): Lấy data theo ID
    public HopDongDTO getHopDongById(Integer id) {
        return hopDongRepository.findHopDongWithTenDichVuByIdHopDongAndNgayXoaIsNull(id);
    }

    // Read (get all): Lấy tất cả data chưa bị xóa mềm
    public List<HopDongDTO> getAllHopDong() {
        return hopDongRepository.findAllHopDongWithTenDichVuAndNgayXoaIsNull();
    }

    // Read (get all): Lấy tất cả data theo idNguoiDung chưa bị xóa mềm
    public List<HopDongDTO> getHopDongByIdNguoiDungAndNgayXoaIsNull(Integer idNguoiDung) {
        return hopDongRepository.findAllHopDongWithTenDichVuByIdNguoiDungAndNgayXoaIsNull(idNguoiDung);
    }

    // Update: Cập nhật thông tin
    public HopDongDTO updateHopDong(Integer id, HopDongDTO request) {
        HopDong hopDong = hopDongRepository
                .findByIdHopDongAndNgayXoaIsNull(id)
                .orElseThrow(() -> new RuntimeException("Hợp đồng không tồn tại"));

        hopDongMapper.updateEntity(hopDong, request);

        return hopDongMapper.toDTO(hopDongRepository.save(hopDong));
    }

    // Soft Delete: Xóa mềm (đặt ngày xóa)
    public void deleteHopDong(Integer id) {
        HopDong hopDong =
                hopDongRepository.findById(id).orElseThrow(() -> new RuntimeException("Hợp đồng không tồn tại"));

        hopDong.setNgayXoa(LocalDateTime.now());
        hopDongRepository.save(hopDong);
    }
}
