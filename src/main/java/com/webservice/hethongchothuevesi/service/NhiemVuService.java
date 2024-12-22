package com.webservice.hethongchothuevesi.service;

import com.webservice.hethongchothuevesi.dto.dto.NhiemVuDTO;
import com.webservice.hethongchothuevesi.dto.request.NhiemVuRequest;
import com.webservice.hethongchothuevesi.entity.NhiemVu;
import com.webservice.hethongchothuevesi.mapper.NhiemVuMapper;
import com.webservice.hethongchothuevesi.respository.NhiemVuRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class NhiemVuService {

    NhiemVuRepository nhiemVuRepository;
    NhiemVuMapper nhiemVuMapper;

    // Create: Tạo mới data
    public NhiemVuDTO createNhiemVu(NhiemVuDTO nhiemVuDTO) {
        NhiemVu nhiemVu = nhiemVuMapper.toEntity(nhiemVuDTO);
        nhiemVu.setTrangThai("Đang thực hiện");
        nhiemVu = nhiemVuRepository.save(nhiemVu);
        return nhiemVuMapper.toDTO(nhiemVu);
    }

    public void addListNhiemVu(NhiemVuRequest request) {
        // Xóa tất cả các nhiệm vụ có idHopDong tương ứng
        nhiemVuRepository.deleteByIdHopDong(request.getIdHopDong());

        // Lặp qua danh sách idVeSi và tạo nhiệm vụ mới
        List<NhiemVu> nhiemVus = request.getListIdVeSi().stream()
                .map(idVeSi -> {
                    NhiemVu nhiemVu = new NhiemVu();
                    nhiemVu.setIdHopDong(request.getIdHopDong());
                    nhiemVu.setIdVeSi(idVeSi);
                    nhiemVu.setNgayBatDau(request.getNgayBatDau());
                    nhiemVu.setNgayKetThuc(request.getNgayKetThuc());
                    nhiemVu.setNoiDung(request.getNoiDung());
                    nhiemVu.setTrangThai("Đang thực hiện");
                    return nhiemVu;
                })
                .collect(Collectors.toList());

        // Lưu toàn bộ danh sách vào database
        nhiemVuRepository.saveAll(nhiemVus);
    }


    // Read (get by id): Lấy data theo ID
    public NhiemVuDTO getNhiemVuById(Integer id) {
        NhiemVu nhiemVu = nhiemVuRepository
                .findByIdNhiemVuAndNgayXoaIsNull(id)
                .orElseThrow(() -> new RuntimeException("Nhiệm vụ không tồn tại"));
        return nhiemVuMapper.toDTO(nhiemVu);
    }

    // Lấy tất cả data chưa bị xóa mềm
    public List<NhiemVuDTO> getAllNhiemVu() {
        return nhiemVuMapper.toListDto(nhiemVuRepository.findByNgayXoaIsNull());
    }

    // Lấy nhiệm vụ theo idVeSi chưa bị xóa mềm
    public List<NhiemVuDTO> getNhiemVuByIdVeSi(Integer idVeSi) {
        return nhiemVuRepository.findAllByIdVeSiAndNgayXoaIsNull(idVeSi);
    }

    // Lấy nhiệm vụ theo idVeSi và trạng thái chưa bị xóa mềm
    public List<NhiemVuDTO> getNhiemVuByIdVeSiAndTrangThai(Integer idVeSi, String trangThai) {
        return nhiemVuRepository.findAllByIdVeSiAndTrangThaiAndNgayXoaIsNull(idVeSi, trangThai);
    }

    // Lấy nhiệm vụ theo trạng thái chưa bị xóa mềm
    public List<NhiemVuDTO> getNhiemVuByTrangThai(String trangThai) {
        return nhiemVuRepository.findAllByTrangThaiAndNgayXoaIsNull(trangThai);
    }

    // Update: Cập nhật thông tin
    public NhiemVuDTO updateNhiemVu(Integer id, NhiemVuDTO request) {
        NhiemVu nhiemVu = nhiemVuRepository
                .findByIdNhiemVuAndNgayXoaIsNull(id)
                .orElseThrow(() -> new RuntimeException("Nhiệm vụ không tồn tại"));

        nhiemVuMapper.updateEntity(nhiemVu, request);

        return nhiemVuMapper.toDTO(nhiemVuRepository.save(nhiemVu));
    }

    // Tìm một nhiệm vụ cụ thể theo idHopDong và idVeSi, chưa bị xóa mềm (trả về DTO)
    public Optional<NhiemVuDTO> getNhiemVuDTOByIdHopDongAndIdVeSi(Integer idHopDong, Integer idVeSi) {
        return nhiemVuRepository.findByIdHopDongAndIdVeSiAndNgayXoaIsNull(idHopDong, idVeSi);
    }

    // Soft Delete: Xóa mềm (đặt ngày xóa)
    public void deleteNhiemVu(Integer id) {
        NhiemVu nhiemVu =
                nhiemVuRepository.findById(id).orElseThrow(() -> new RuntimeException("Nhiệm vụ không tồn tại"));

        nhiemVu.setNgayXoa(LocalDateTime.now());
        nhiemVuRepository.save(nhiemVu);
    }
}
