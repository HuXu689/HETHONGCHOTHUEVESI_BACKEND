package com.webservice.hethongchothuevesi.service;

import com.webservice.hethongchothuevesi.dto.dto.KhoaDaoTaoDTO;
import com.webservice.hethongchothuevesi.entity.KhoaDaoTao;
import com.webservice.hethongchothuevesi.mapper.KhoaDaoTaoMapper;
import com.webservice.hethongchothuevesi.respository.KhoaDaoTaoRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class KhoaDaoTaoService {

    KhoaDaoTaoRepository khoaDaoTaoRepository;
    KhoaDaoTaoMapper khoaDaoTaoMapper;

    // Create: Tạo mới data
    public KhoaDaoTaoDTO createKhoaDaoTao(KhoaDaoTaoDTO khoaDaoTaoDTO) {
        KhoaDaoTao khoaDaoTao = khoaDaoTaoMapper.toEntity(khoaDaoTaoDTO);
        khoaDaoTao.setTrangThai("Hoạt động");
        khoaDaoTao = khoaDaoTaoRepository.save(khoaDaoTao);
        return khoaDaoTaoMapper.toDTO(khoaDaoTao);
    }

    // Read (get by id): Lấy data theo ID
    public KhoaDaoTaoDTO getKhoaDaoTaoById(Integer id) {
        KhoaDaoTao khoaDaoTao = khoaDaoTaoRepository
                .findByIdKhoaDaoTaoAndNgayXoaIsNull(id)
                .orElseThrow(() -> new RuntimeException("Khóa đào tạo không tồn tại"));
        return khoaDaoTaoMapper.toDTO(khoaDaoTao);
    }

    // Read (get all): Lấy tất cả data chưa bị xóa mềm
    public List<KhoaDaoTaoDTO> getAllKhoaDaoTao() {
        return khoaDaoTaoMapper.toListDto(khoaDaoTaoRepository.findByNgayXoaIsNull());
    }

    // Update: Cập nhật thông tin
    public KhoaDaoTaoDTO updateKhoaDaoTao(Integer id, KhoaDaoTaoDTO request) {
        KhoaDaoTao khoaDaoTao = khoaDaoTaoRepository
                .findByIdKhoaDaoTaoAndNgayXoaIsNull(id)
                .orElseThrow(() -> new RuntimeException("Khóa đào tạo không tồn tại"));

        khoaDaoTaoMapper.updateEntity(khoaDaoTao, request);

        return khoaDaoTaoMapper.toDTO(khoaDaoTaoRepository.save(khoaDaoTao));
    }

    // Soft Delete: Xóa mềm (đặt ngày xóa)
    public void deleteKhoaDaoTao(Integer id) {
        KhoaDaoTao khoaDaoTao =
                khoaDaoTaoRepository.findById(id).orElseThrow(() -> new RuntimeException("Khóa đào tạo không tồn tại"));

        khoaDaoTao.setNgayXoa(LocalDateTime.now());
        khoaDaoTaoRepository.save(khoaDaoTao);
    }
}
