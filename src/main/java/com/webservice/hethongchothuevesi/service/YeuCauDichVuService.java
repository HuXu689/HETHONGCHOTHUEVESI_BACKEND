package com.webservice.hethongchothuevesi.service;

import com.webservice.hethongchothuevesi.dto.dto.YeuCauDichVuDTO;
import com.webservice.hethongchothuevesi.entity.YeuCauDichVu;
import com.webservice.hethongchothuevesi.mapper.YeuCauDichVuMapper;
import com.webservice.hethongchothuevesi.respository.YeuCauDichVuRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class YeuCauDichVuService {

    YeuCauDichVuRepository yeuCauDichVuRepository;
    YeuCauDichVuMapper yeuCauDichVuMapper;

    // Create: Tạo mới data
    public YeuCauDichVuDTO createYeuCauDichVu(YeuCauDichVuDTO yeuCauDichVuDTO) {
        YeuCauDichVu yeuCauDichVu = yeuCauDichVuMapper.toEntity(yeuCauDichVuDTO);
        yeuCauDichVu.setTrangThai("Hoạt động");
        yeuCauDichVu = yeuCauDichVuRepository.save(yeuCauDichVu);
        return yeuCauDichVuMapper.toDTO(yeuCauDichVu);
    }

    // Read (get by id): Lấy data theo ID
    public YeuCauDichVuDTO getYeuCauDichVuById(Integer id) {
        YeuCauDichVu yeuCauDichVu = yeuCauDichVuRepository
                .findByIdYeuCauDichVuAndNgayXoaIsNull(id)
                .orElseThrow(() -> new RuntimeException("Yêu cầu dịch vụ không tồn tại"));
        return yeuCauDichVuMapper.toDTO(yeuCauDichVu);
    }

    // Read (get all): Lấy tất cả data chưa bị xóa mềm
    public List<YeuCauDichVuDTO> getAllYeuCauDichVu() {
        return yeuCauDichVuMapper.toListDto(yeuCauDichVuRepository.findByNgayXoaIsNull());
    }

    // Update: Cập nhật thông tin
    public YeuCauDichVuDTO updateYeuCauDichVu(Integer id, YeuCauDichVuDTO request) {
        YeuCauDichVu yeuCauDichVu = yeuCauDichVuRepository
                .findByIdYeuCauDichVuAndNgayXoaIsNull(id)
                .orElseThrow(() -> new RuntimeException("Yêu cầu dịch vụ không tồn tại"));

        yeuCauDichVuMapper.updateEntity(yeuCauDichVu, request);

        return yeuCauDichVuMapper.toDTO(yeuCauDichVuRepository.save(yeuCauDichVu));
    }

    // Soft Delete: Xóa mềm (đặt ngày xóa)
    public void deleteYeuCauDichVu(Integer id) {
        YeuCauDichVu yeuCauDichVu = yeuCauDichVuRepository
                .findById(id)
                .orElseThrow(() -> new RuntimeException("Yêu cầu dịch vụ không tồn tại"));

        yeuCauDichVu.setNgayXoa(LocalDateTime.now());
        yeuCauDichVuRepository.save(yeuCauDichVu);
    }
}
