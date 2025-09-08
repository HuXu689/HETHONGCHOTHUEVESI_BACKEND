package com.webservice.hethongchothuevesi.service;

import java.time.LocalDateTime;
import java.util.List;

import com.webservice.hethongchothuevesi.dto.dto.BaoCaoKhanNhiemVuDTO;
import com.webservice.hethongchothuevesi.entity.BaoCaoKhanNhiemVu;
import com.webservice.hethongchothuevesi.mapper.BaoCaoKhanNhiemVuMapper;
import com.webservice.hethongchothuevesi.repository.BaoCaoKhanNhiemVuRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class BaoCaoKhanNhiemVuService {

    BaoCaoKhanNhiemVuRepository baoCaoKhanNhiemVuRepository;
    BaoCaoKhanNhiemVuMapper baoCaoKhanNhiemVuMapper;

    // Create: Tạo mới data
    public BaoCaoKhanNhiemVuDTO createBaoCaoKhanNhiemVu(BaoCaoKhanNhiemVuDTO baoCaoKhanNhiemVuDTO) {
        BaoCaoKhanNhiemVu baoCaoKhanNhiemVu = baoCaoKhanNhiemVuMapper.toEntity(baoCaoKhanNhiemVuDTO);
        baoCaoKhanNhiemVu.setTrangThai("Hoạt động");
        baoCaoKhanNhiemVu = baoCaoKhanNhiemVuRepository.save(baoCaoKhanNhiemVu);
        return baoCaoKhanNhiemVuMapper.toDTO(baoCaoKhanNhiemVu);
    }

    // Read (get by id): Lấy data theo ID
    public BaoCaoKhanNhiemVuDTO getBaoCaoKhanNhiemVuById(Integer id) {
        BaoCaoKhanNhiemVu baoCaoKhanNhiemVu = baoCaoKhanNhiemVuRepository
                .findByIdBaoCaoKhanAndNgayXoaIsNull(id)
                .orElseThrow(() -> new RuntimeException("Báo cáo khẩn không tồn tại"));
        return baoCaoKhanNhiemVuMapper.toDTO(baoCaoKhanNhiemVu);
    }

    // Read (get all): Lấy tất cả data chưa bị xóa mềm
    public List<BaoCaoKhanNhiemVuDTO> getAllBaoCaoKhanNhiemVu() {
        return baoCaoKhanNhiemVuMapper.toListDto(baoCaoKhanNhiemVuRepository.findByNgayXoaIsNull());
    }

    // Update: Cập nhật thông tin
    public BaoCaoKhanNhiemVuDTO updateBaoCaoKhanNhiemVu(Integer id, BaoCaoKhanNhiemVuDTO request) {
        BaoCaoKhanNhiemVu baoCaoKhanNhiemVu = baoCaoKhanNhiemVuRepository
                .findByIdBaoCaoKhanAndNgayXoaIsNull(id)
                .orElseThrow(() -> new RuntimeException("Báo cáo khẩn không tồn tại"));

        baoCaoKhanNhiemVuMapper.updateEntity(baoCaoKhanNhiemVu, request);

        return baoCaoKhanNhiemVuMapper.toDTO(baoCaoKhanNhiemVuRepository.save(baoCaoKhanNhiemVu));
    }

    // Soft Delete: Xóa mềm (đặt ngày xóa)
    public void deleteBaoCaoKhanNhiemVu(Integer id) {
        BaoCaoKhanNhiemVu baoCaoKhanNhiemVu = baoCaoKhanNhiemVuRepository
                .findById(id)
                .orElseThrow(() -> new RuntimeException("Báo cáo khẩn không tồn tại"));

        baoCaoKhanNhiemVu.setNgayXoa(LocalDateTime.now());
        baoCaoKhanNhiemVuRepository.save(baoCaoKhanNhiemVu);
    }
}
