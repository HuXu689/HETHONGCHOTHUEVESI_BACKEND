package com.webservice.hethongchothuevesi.service;

import com.webservice.hethongchothuevesi.dto.dto.YeuCauDichVuDTO;
import com.webservice.hethongchothuevesi.entity.DanhMucDichVu;
import com.webservice.hethongchothuevesi.entity.YeuCauDichVu;
import com.webservice.hethongchothuevesi.mapper.YeuCauDichVuMapper;
import com.webservice.hethongchothuevesi.respository.DanhMucDichVuRepository;
import com.webservice.hethongchothuevesi.respository.YeuCauDichVuRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class YeuCauDichVuService {

    YeuCauDichVuRepository yeuCauDichVuRepository;
    YeuCauDichVuMapper yeuCauDichVuMapper;
    DanhMucDichVuRepository danhMucDichVuRepository;

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
}
