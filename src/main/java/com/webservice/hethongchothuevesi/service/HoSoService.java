package com.webservice.hethongchothuevesi.service;

import java.time.LocalDateTime;
import java.util.List;

import com.webservice.hethongchothuevesi.dto.dto.HoSoDTO;
import com.webservice.hethongchothuevesi.entity.HoSo;
import com.webservice.hethongchothuevesi.mapper.HoSoMapper;
import com.webservice.hethongchothuevesi.repository.HoSoRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class HoSoService {

    HoSoRepository hoSoRepository;
    HoSoMapper hoSoMapper;

    // Create: Tạo mới data
    public HoSoDTO createHoSo(HoSoDTO hoSoDTO) {
        HoSo hoSo = hoSoMapper.toEntity(hoSoDTO);
        hoSo = hoSoRepository.save(hoSo);
        return hoSoMapper.toDTO(hoSo);
    }

    // Read (get by id): Lấy data theo ID
    public HoSoDTO getHoSoById(Integer id) {
        HoSo hoSo = hoSoRepository
                .findByIdHoSoAndNgayXoaIsNull(id)
                .orElseThrow(() -> new RuntimeException("Hồ sơ không tồn tại"));
        return hoSoMapper.toDTO(hoSo);
    }

    // Read (get all): Lấy tất cả data chưa bị xóa mềm
    public List<HoSoDTO> getAllHoSo() {
        return hoSoMapper.toListDto(hoSoRepository.findByNgayXoaIsNull());
    }

    // Update: Cập nhật thông tin
    public HoSoDTO updateHoSo(Integer id, HoSoDTO request) {
        HoSo hoSo = hoSoRepository
                .findByIdHoSoAndNgayXoaIsNull(id)
                .orElseThrow(() -> new RuntimeException("Hồ sơ không tồn tại"));

        hoSoMapper.updateEntity(hoSo, request);

        return hoSoMapper.toDTO(hoSoRepository.save(hoSo));
    }

    // Soft Delete: Xóa mềm (đặt ngày xóa)
    public void deleteHoSo(Integer id) {
        HoSo hoSo = hoSoRepository.findById(id).orElseThrow(() -> new RuntimeException("Hồ sơ không tồn tại"));

        hoSo.setNgayXoa(LocalDateTime.now());
        hoSoRepository.save(hoSo);
    }
}
