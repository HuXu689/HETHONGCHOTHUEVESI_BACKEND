package com.webservice.hethongchothuevesi.controller;

import com.webservice.hethongchothuevesi.dto.dto.NhiemVuDTO;
import com.webservice.hethongchothuevesi.dto.request.NhiemVuRequest;
import com.webservice.hethongchothuevesi.dto.response.UpdateResult;
import com.webservice.hethongchothuevesi.entity.NhiemVu;
import com.webservice.hethongchothuevesi.service.NhiemVuService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/NhiemVu")
@RequiredArgsConstructor
public class NhiemVuController {

    private final NhiemVuService nhiemVuService;

    // Tạo mới nhiệm vụ
    @PostMapping
    public ResponseEntity<NhiemVuDTO> createNhiemVu(@RequestBody NhiemVuDTO nhiemVuDTO) {
        NhiemVuDTO createdNhiemVu = nhiemVuService.createNhiemVu(nhiemVuDTO);
        return new ResponseEntity<>(createdNhiemVu, HttpStatus.CREATED);
    }

    // Tạo nhiệm vụ theo idHopDong và danh sách idVeSi
    @PostMapping("/AddByidHopDongAndListIdVeSi")
    public ResponseEntity<String> addListNhiemVu(@RequestBody NhiemVuRequest request) {
        try {
            nhiemVuService.addListNhiemVu(request);
            return ResponseEntity.ok("Danh sách nhiệm vụ đã được thêm thành công.");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Lỗi khi thêm danh sách nhiệm vụ: " + e.getMessage());
        }
    }

    // Lấy nhiệm vụ theo ID
    @GetMapping("/{id}")
    public ResponseEntity<NhiemVuDTO> getNhiemVuById(@PathVariable Integer id) {
        NhiemVuDTO nhiemVuDTO = nhiemVuService.getNhiemVuById(id);
        return new ResponseEntity<>(nhiemVuDTO, HttpStatus.OK);
    }

    // Lấy tất cả nhiệm vụ chưa bị xóa mềm
    @GetMapping
    public ResponseEntity<List<NhiemVuDTO>> getAllNhiemVu() {
        List<NhiemVuDTO> nhiemVuList = nhiemVuService.getAllNhiemVu();
        return new ResponseEntity<>(nhiemVuList, HttpStatus.OK);
    }

    // API: Lấy nhiệm vụ theo idVeSi chưa bị xóa mềm
    @GetMapping("/ByIdVeSi/{idVeSi}")
    public ResponseEntity<List<NhiemVuDTO>> getNhiemVuByIdVeSi(@PathVariable Integer idVeSi) {
        List<NhiemVuDTO> nhiemVus = nhiemVuService.getNhiemVuByIdVeSi(idVeSi);
        return ResponseEntity.ok(nhiemVus);
    }

    // API: Lấy nhiệm vụ theo idVeSi và trạng thái chưa bị xóa mềm
    @GetMapping("/ByIdVeSiAndTrangThai")
    public ResponseEntity<List<NhiemVuDTO>> getNhiemVuByIdVeSiAndTrangThai(
            @RequestParam Integer idVeSi, @RequestParam String trangThai) {
        List<NhiemVuDTO> nhiemVus = nhiemVuService.getNhiemVuByIdVeSiAndTrangThai(idVeSi, trangThai);
        return ResponseEntity.ok(nhiemVus);
    }

    // Endpoint để lấy một nhiệm vụ cụ thể theo idHopDong và idVeSi, trả về DTO
    @GetMapping("/ByIdHopDongAndIdVeSi")
    public ResponseEntity<Optional<NhiemVuDTO>> getOneNhiemVuByHopDongAndVeSi(
            @RequestParam Integer idHopDong, @RequestParam Integer idVeSi) {
        Optional<NhiemVuDTO> nhiemVu = nhiemVuService.getNhiemVuDTOByIdHopDongAndIdVeSi(idHopDong, idVeSi);
        return ResponseEntity.ok(nhiemVu);
    }

    // API: Lấy nhiệm vụ theo trạng thái chưa bị xóa mềm
    @GetMapping("/ByTrangThai")
    public ResponseEntity<List<NhiemVuDTO>> getNhiemVuByTrangThai(@RequestParam String trangThai) {
        List<NhiemVuDTO> nhiemVus = nhiemVuService.getNhiemVuByTrangThai(trangThai);
        return ResponseEntity.ok(nhiemVus);
    }

    // API: Lấy nhiệm vụ theo idHopDong chưa bị xóa mềm
    @GetMapping("/ByIdHopDong/{idHopDong}")
    public ResponseEntity<List<NhiemVu>> getNhiemVuByIdHopDong(@PathVariable Integer idHopDong) {
        List<NhiemVu> nhiemVus = nhiemVuService.getNhiemVuByIdHopDong(idHopDong);
        return ResponseEntity.ok(nhiemVus);
    }

    // Cập nhật thông tin nhiệm vụ
    @PutMapping("/{id}")
    public ResponseEntity<NhiemVuDTO> updateNhiemVu(@PathVariable Integer id, @RequestBody NhiemVuDTO dto) {
        NhiemVuDTO updatedNhiemVu = nhiemVuService.updateNhiemVu(id, dto);
        return new ResponseEntity<>(updatedNhiemVu, HttpStatus.OK);
    }

    // Xóa mềm nhiệm vụ
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteNhiemVu(@PathVariable Integer id) {
        nhiemVuService.deleteNhiemVu(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT); // Trả về HTTP 204 No Content
    }

    // Xóa nhiệm vụ theo idHopDong
    @DeleteMapping("ByIdHopDong/{idHopDong}")
    public ResponseEntity<Void> deleteNhiemVuByIdHopDong(@PathVariable Integer idHopDong) {
        nhiemVuService.softDeleteNhiemVuByIdHopDong(idHopDong);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT); // Trả về HTTP 204 No Content
    }

    // Cập nhật tất cả nhiệm vụ theo idHopDong
    @PutMapping("/BulkUpdateByIdHopDong/{idHopDong}")
    public ResponseEntity<UpdateResult> bulkUpdateNhiemVuByIdHopDong(
            @PathVariable Integer idHopDong,
            @Valid @RequestBody NhiemVuDTO dto) {
        try {
            UpdateResult result = nhiemVuService.bulkUpdateNhiemVuByIdHopDong(idHopDong, dto);
            return ResponseEntity.ok(result);
        } catch (Exception e) {
            UpdateResult errorResult = new UpdateResult(0, "Lỗi khi cập nhật nhiệm vụ: " + e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(errorResult);
        }
    }
}
