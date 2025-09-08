package com.webservice.hethongchothuevesi.service;

import com.webservice.hethongchothuevesi.dto.dto.NhiemVuDTO;
import com.webservice.hethongchothuevesi.dto.request.NhiemVuRequest;
import com.webservice.hethongchothuevesi.dto.request.UpdateNhiemVuByHopDongRequest;
import com.webservice.hethongchothuevesi.dto.response.UpdateResult;
import com.webservice.hethongchothuevesi.entity.NhiemVu;
import com.webservice.hethongchothuevesi.exception.ResourceNotFoundException;
import com.webservice.hethongchothuevesi.mapper.NhiemVuMapper;
import com.webservice.hethongchothuevesi.repository.NhiemVuRepository;
import jakarta.transaction.Transactional;
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
                    nhiemVu.setTrangThai("Chưa bắt đầu");
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

    // Lấy nhiệm vụ theo idHopDong chưa bị xóa mềm
    public List<NhiemVu> getNhiemVuByIdHopDong(Integer idHopDong) {
        return nhiemVuRepository.findByIdHopDongAndNgayXoaIsNull(idHopDong);
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

    // Delete: Xóa list NhiemVu theo idHopDong
    public void deleteNhiemVuByIdHopDong(Integer idHopDong) {
        nhiemVuRepository.deleteByIdHopDong(idHopDong);
    }

    // Soft Delete: Xóa mềm list NhiemVu theo idHopDong
    @Transactional
    public void softDeleteNhiemVuByIdHopDong(Integer idHopDong) {
        List<NhiemVu> danhSachNhiemVu = nhiemVuRepository.findByIdHopDongAndNgayXoaIsNull(idHopDong);

        if (danhSachNhiemVu.isEmpty()) {
            // Tuỳ vào logic, bạn có thể ném ngoại lệ hoặc chỉ dừng lại
            throw new RuntimeException("Không tìm thấy nhiệm vụ cho idHopDong: " + idHopDong);
        }

        LocalDateTime ngayXoa = LocalDateTime.now();
        for (NhiemVu nv : danhSachNhiemVu) {
            nv.setNgayXoa(ngayXoa);
        }

        // 3. Lưu lại toàn bộ nhiệm vụ đã cập nhật
        nhiemVuRepository.saveAll(danhSachNhiemVu);
    }

    /**
     * Cập nhật tất cả các nhiệm vụ liên quan đến một hợp đồng cụ thể.
     *
     * @param request Yêu cầu cập nhật bao gồm idHopDong và danh sách NhiemVuDTO
     * @return UpdateResult chứa thông tin về số lượng nhiệm vụ đã cập nhật và xóa
     */
    @Transactional
    public UpdateResult updateNhiemVuByIdHopDong(UpdateNhiemVuByHopDongRequest request) {
        Integer idHopDong = request.getIdHopDong();
        List<NhiemVuDTO> nhiemVusDTO = request.getNhiemVus();

        // Lấy danh sách nhiệm vụ hiện tại của hợp đồng
        List<NhiemVu> existingNhiemVus = nhiemVuRepository.findByIdHopDongAndNgayXoaIsNull(idHopDong);

        // Map existing NhiemVu by id for dễ dàng tìm kiếm
        // Sử dụng Optional để xử lý các nhiệm vụ có thể không có id
        var existingMap = existingNhiemVus.stream()
                .filter(nhiemVu -> nhiemVu.getIdNhiemVu() != null)
                .collect(Collectors.toMap(NhiemVu::getIdNhiemVu, nhiemVu -> nhiemVu));

        List<NhiemVu> updatedNhiemVus = nhiemVusDTO.stream()
                .map(dto -> {
                    if (dto.getIdNhiemVu() != null && existingMap.containsKey(dto.getIdNhiemVu())) {
                        // Cập nhật nhiệm vụ hiện có
                        NhiemVu existing = existingMap.get(dto.getIdNhiemVu());
                        nhiemVuMapper.updateEntityFromDto(dto, existing);
                        return existing;
                    } else {
                        // Thêm nhiệm vụ mới
                        NhiemVu newNhiemVu = nhiemVuMapper.toEntity(dto);
                        newNhiemVu.setIdHopDong(idHopDong);
                        return newNhiemVu;
                    }
                })
                .collect(Collectors.toList());

        // Lưu lại các nhiệm vụ đã cập nhật và thêm mới
        List<NhiemVu> savedNhiemVus = nhiemVuRepository.saveAll(updatedNhiemVus);

        // Xác định các nhiệm vụ cần xóa (nhiệm vụ hiện tại không có trong danh sách cập nhật)
        List<NhiemVu> toDelete = existingNhiemVus.stream()
                .filter(nhiemVu -> nhiemVu.getIdNhiemVu() != null && !updatedNhiemVus.contains(nhiemVu))
                .collect(Collectors.toList());

        // Xóa các nhiệm vụ không còn trong danh sách cập nhật
        int deletedCount = 0;
        if (!toDelete.isEmpty()) {
            nhiemVuRepository.deleteAll(toDelete);
            deletedCount = toDelete.size();
        }

        // Số lượng nhiệm vụ đã cập nhật
        int updatedCount = savedNhiemVus.size();

        return new UpdateResult(updatedCount, "thành công");
    }

    @Transactional
    public UpdateResult bulkUpdateNhiemVuByIdHopDong(Integer idHopDong, NhiemVuDTO dto) {
        // Lấy danh sách nhiệm vụ hiện tại của hợp đồng
        List<NhiemVu> nhiemVus = nhiemVuRepository.findByIdHopDongAndNgayXoaIsNull(idHopDong);

        if (nhiemVus.isEmpty()) {
            throw new ResourceNotFoundException("Không tìm thấy nhiệm vụ với idHopDong: " + idHopDong);
        }

        int updatedCount = 0;

        // Lặp qua danh sách nhiệm vụ và cập nhật các trường không null trong DTO
        for (NhiemVu nhiemVu : nhiemVus) {
            boolean isUpdated = false;

            if (dto.getTrangThai() != null && !dto.getTrangThai().equals(nhiemVu.getTrangThai())) {
                nhiemVu.setTrangThai(dto.getTrangThai());
                isUpdated = true;
            }

            // Cập nhật các trường khác tương tự, ví dụ:
            if (dto.getNoiDung() != null && !dto.getNoiDung().equals(nhiemVu.getNoiDung())) {
                nhiemVu.setNoiDung(dto.getNoiDung());
                isUpdated = true;
            }

            // Thêm các điều kiện cập nhật cho các trường khác nếu cần
            // Ví dụ:
            // if (dto.getNgayBatDau() != null && !dto.getNgayBatDau().equals(nhiemVu.getNgayBatDau())) {
            //     nhiemVu.setNgayBatDau(dto.getNgayBatDau());
            //     isUpdated = true;
            // }

            if (isUpdated) {
                updatedCount++;
            }
        }

        // Lưu lại tất cả các nhiệm vụ đã được cập nhật
        nhiemVuRepository.saveAll(nhiemVus);

        return new UpdateResult(updatedCount, "Cập nhật thành công.");
    }
}
