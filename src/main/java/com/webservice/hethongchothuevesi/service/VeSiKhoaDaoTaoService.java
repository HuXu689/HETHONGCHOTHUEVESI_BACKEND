package com.webservice.hethongchothuevesi.service;

import java.time.LocalDateTime;
import java.util.List;

import com.webservice.hethongchothuevesi.dto.dto.VeSiKhoaDaoTaoDTO;
import com.webservice.hethongchothuevesi.entity.VeSiKhoaDaoTao;
import com.webservice.hethongchothuevesi.mapper.VeSiKhoaDaoTaoMapper;
import com.webservice.hethongchothuevesi.repository.VeSiKhoaDaoTaoRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class VeSiKhoaDaoTaoService {

    VeSiKhoaDaoTaoRepository veSiKhoaDaoTaoRepository;
    VeSiKhoaDaoTaoMapper veSiKhoaDaoTaoMapper;

    // Create: Tạo mới data
    public VeSiKhoaDaoTaoDTO createVeSiKhoaDaoTao(VeSiKhoaDaoTaoDTO veSiKhoaDaoTaoDTO) {
        VeSiKhoaDaoTao veSiKhoaDaoTao = veSiKhoaDaoTaoMapper.toEntity(veSiKhoaDaoTaoDTO);
        veSiKhoaDaoTao.setTrangThai("Hoạt động");
        veSiKhoaDaoTao = veSiKhoaDaoTaoRepository.save(veSiKhoaDaoTao);
        return veSiKhoaDaoTaoMapper.toDTO(veSiKhoaDaoTao);
    }

    // Read (get by id): Lấy data theo ID
    public VeSiKhoaDaoTaoDTO getVeSiKhoaDaoTaoById(Integer id) {
        VeSiKhoaDaoTao veSiKhoaDaoTao = veSiKhoaDaoTaoRepository
                .findByIdVeSiKhoaDaoTaoAndNgayXoaIsNull(id)
                .orElseThrow(() -> new RuntimeException("Vệ sĩ khóa đào tạo không tồn tại"));
        return veSiKhoaDaoTaoMapper.toDTO(veSiKhoaDaoTao);
    }

    // Read (get all): Lấy tất cả data chưa bị xóa mềm
    public List<VeSiKhoaDaoTaoDTO> getAllVeSiKhoaDaoTao() {
        return veSiKhoaDaoTaoMapper.toListDto(veSiKhoaDaoTaoRepository.findByNgayXoaIsNull());
    }

    // Update: Cập nhật thông tin
    public VeSiKhoaDaoTaoDTO updateVeSiKhoaDaoTao(Integer id, VeSiKhoaDaoTaoDTO request) {
        VeSiKhoaDaoTao veSiKhoaDaoTao = veSiKhoaDaoTaoRepository
                .findByIdVeSiKhoaDaoTaoAndNgayXoaIsNull(id)
                .orElseThrow(() -> new RuntimeException("Vệ sĩ khóa đào tạo không tồn tại"));

        veSiKhoaDaoTaoMapper.updateEntity(veSiKhoaDaoTao, request);

        return veSiKhoaDaoTaoMapper.toDTO(veSiKhoaDaoTaoRepository.save(veSiKhoaDaoTao));
    }

    // Soft Delete: Xóa mềm (đặt ngày xóa)
    public void deleteVeSiKhoaDaoTao(Integer id) {
        VeSiKhoaDaoTao veSiKhoaDaoTao = veSiKhoaDaoTaoRepository
                .findById(id)
                .orElseThrow(() -> new RuntimeException("Vệ sĩ khóa đào tạo không tồn tại"));

        veSiKhoaDaoTao.setNgayXoa(LocalDateTime.now());
        veSiKhoaDaoTaoRepository.save(veSiKhoaDaoTao);
    }
}
