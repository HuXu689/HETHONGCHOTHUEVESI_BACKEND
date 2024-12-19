package com.webservice.hethongchothuevesi.service;

import com.webservice.hethongchothuevesi.dto.dto.HopDongDTO;
import com.webservice.hethongchothuevesi.entity.HopDong;
import com.webservice.hethongchothuevesi.mapper.HopDongMapper;
import com.webservice.hethongchothuevesi.respository.HopDongRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class HopDongService {

    HopDongRepository hopDongRepository;
    HopDongMapper hopDongMapper;

    // Create: Tạo mới data
    public HopDongDTO createHopDong(HopDongDTO hopDongDTO) {
        HopDong hopDong = hopDongMapper.toEntity(hopDongDTO);
        hopDong.setTrangThai("Chưa phân công");
        hopDong = hopDongRepository.save(hopDong);
        return hopDongMapper.toDTO(hopDong);
    }

    // Read (get by id): Lấy data theo ID
    public HopDongDTO getHopDongById(Integer id) {
        HopDong hopDong = hopDongRepository
                .findByIdHopDongAndNgayXoaIsNull(id)
                .orElseThrow(() -> new RuntimeException("Hợp đồng không tồn tại"));
        return hopDongMapper.toDTO(hopDong);
    }

    // Read (get all): Lấy tất cả data chưa bị xóa mềm
    public List<HopDongDTO> getAllHopDong() {
        return hopDongMapper.toListDto(hopDongRepository.findByNgayXoaIsNull());
    }

    // Read (get all): Lấy tất cả data theo idNguoiDung chưa bị xóa mềm
    public List<HopDongDTO> getHopDongByIdNguoiDungAndNgayXoaIsNull(Integer idNguoiDung) {
        return hopDongMapper.toListDto(hopDongRepository.findAllHopDongByIdNguoiDungAndNgayXoaIsNull(idNguoiDung));
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
