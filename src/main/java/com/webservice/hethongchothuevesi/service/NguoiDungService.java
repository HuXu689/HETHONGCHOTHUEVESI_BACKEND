package com.webservice.hethongchothuevesi.service;

import com.webservice.hethongchothuevesi.dto.request.NguoiDungChangePasswordRequest;
import com.webservice.hethongchothuevesi.dto.request.NguoiDungCreationRequest;
import com.webservice.hethongchothuevesi.dto.request.NguoiDungUpdateRequest;
import com.webservice.hethongchothuevesi.dto.response.NguoiDungResponse;
import com.webservice.hethongchothuevesi.entity.NguoiDung;
import com.webservice.hethongchothuevesi.enums.Role;
import com.webservice.hethongchothuevesi.exception.AppException;
import com.webservice.hethongchothuevesi.exception.ErrorCode;
import com.webservice.hethongchothuevesi.mapper.NguoiDungMapper;
import com.webservice.hethongchothuevesi.respository.NguoiDungRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class NguoiDungService {
    NguoiDungRepository nguoiDungRepository;
    NguoiDungMapper nguoiDungMapper;
    AuthenticationService authenticationService;

    /*
     * @author: XuanHuynh
     * @since: 13/10/2024 12:07 SA
     * description: Tạo tài khoản khách hàng mới
     * update:
     */
    public NguoiDungResponse createRequest(NguoiDungCreationRequest request) {
        if (nguoiDungRepository.existsByTenDangNhap(request.getTenDangNhap())) {
            throw new AppException(ErrorCode.TENDANGNHAP_EXISTED);
        }

        NguoiDung nguoiDung = nguoiDungMapper.toNguoiDung(request);
        nguoiDung.setMatKhau(authenticationService.encryption(request.getMatKhau()));

        nguoiDung.setRole(Role.USER.name());

        return nguoiDungMapper.toNguoiDungResponse(nguoiDungRepository.save(nguoiDung));
    }

    /*
     * @author: XuanHuynh
     * @since: 10/14/2024 12:27 PM
     * description: Cập nhật thông tin khách hàng
     * update:
     */
    public NguoiDungResponse updateRequest(int id, NguoiDungUpdateRequest request) {
        NguoiDung nguoiDung = findNguoiDungById(id);
        nguoiDungMapper.updateNguoiDung(nguoiDung, request);
        return nguoiDungMapper.toNguoiDungResponse(nguoiDungRepository.save(nguoiDung));
    }

    /*
     * @author: XuanHuynh
     * @since: 10/14/2024 12:27 PM
     * description: Thay đổi mật khẩu khách hàng
     * update:
     */
    public boolean changePasswordRequest(int id, NguoiDungChangePasswordRequest request) {
        NguoiDung nguoiDung = findNguoiDungById(id);
        if (authenticationService.checkNguoiDungId(id, request.getMatKhauCu())) {
            nguoiDung.setMatKhau(authenticationService.encryption(request.getMatKhauMoi()));
            return true;
        }
        return false;
    }

    /*
     * @author: XuanHuynh
     * @since: 10/14/2024 12:27 PM
     * description: Xóa mềm khách hàng
     * update:
     */
    public void deleteSoftRequest(int id) {
        NguoiDung nguoiDung = findNguoiDungById(id);
        nguoiDung.setNgayXoa(LocalDateTime.now());
        nguoiDungRepository.save(nguoiDung); // Lưu trạng thái xóa mềm
    }

    /*
     * @author: XuanHuynh
     * @since: 10/14/2024 12:27 PM
     * description: Xóa vĩnh viễn khách hàng
     * update:
     */
    public void deleteRequest(int id) {
        NguoiDung nguoiDung = findNguoiDungById(id);
        if (nguoiDung.getNgayXoa() == null) {
            throw new AppException(ErrorCode.NGUOIDUNG_NOT_DELETED);
        }
        nguoiDungRepository.delete(nguoiDung);
    }

    /*
     * @author: XuanHuynh
     * @since: 16/10/2024 1:05 AM
     * description: Khôi phục khách hàng đã xóa mềm
     * update:
     */
    public NguoiDungResponse restoreSoftDeletedRequest(int id) {
        NguoiDung nguoiDung = findNguoiDungById(id);
        if (nguoiDung.getNgayXoa() == null) {
            throw new AppException(ErrorCode.NGUOIDUNG_NOT_DELETED); // Nếu chưa bị xóa mềm
        }
        nguoiDung.setNgayXoa(null); // Khôi phục trạng thái
        nguoiDungRepository.save(nguoiDung);
        return nguoiDungMapper.toNguoiDungResponse(nguoiDung);
    }

    /*
     * @author: XuanHuynh
     * @since: 10/14/2024 6:56 PM
     * description: Lấy dữ liệu của tất cả khách hàng chưa bị xóa mềm
     * update:
     */
    public List<NguoiDungResponse> getAllSoftRequest() {
        return nguoiDungMapper.toNguoiDungResponse(nguoiDungRepository.findByNgayXoaIsNull());
    }

    /*
     * @author: XuanHuynh
     * @since: 13/10/2024 12:07 SA
     * description: Lấy dữ liệu của tất cả khách hàng
     * update:
     */
    public List<NguoiDungResponse> getAllRequest() {
        return nguoiDungMapper.toNguoiDungResponse(nguoiDungRepository.findAll());
    }

    /*
     * @author: XuanHuynh
     * @since: 13/10/2024 12:08 SA
     * description: Lấy dữ liệu của khách hàng theo ID chưa bị xóa mềm
     * update:
     */
    public NguoiDungResponse getSoftRequestById(int id) {
        return nguoiDungMapper.toNguoiDungResponse(nguoiDungRepository
                .findByIdNguoiDungAndNgayXoaIsNull(id)
                .orElseThrow(() -> new AppException(ErrorCode.NGUOIDUNG_NOT_EXISTED)));
    }

    /*
     * @author: XuanHuynh
     * @since: 13/10/2024 12:08 SA
     * description: Lấy dữ liệu của khách hàng theo ID
     * update:
     */
    public NguoiDungResponse getRequestById(int id) {
        return nguoiDungMapper.toNguoiDungResponse(findNguoiDungById(id));
    }

    /*
     * @author: XuanHuynh
     * @since: 16/10/2024 1:05 AM
     * description: Tìm kiếm khách hàng theo tên đăng nhập hoặc email
     * update:
     */
    public List<NguoiDungResponse> searchNguoiDung(String keyword) {
        List<NguoiDung> nguoiDungList =
                nguoiDungRepository.findByTenDangNhapContainingOrEmailContaining(keyword, keyword);
        return nguoiDungMapper.toNguoiDungResponse(nguoiDungList);
    }

    /*
     * @author: XuanHuynh
     * @since: 16/10/2024 1:05 AM
     * description: Tìm khách hàng theo ID
     * update:
     */
    private NguoiDung findNguoiDungById(int id) {
        return nguoiDungRepository.findById(id).orElseThrow(() -> new AppException(ErrorCode.NGUOIDUNG_NOT_EXISTED));
    }

    /*
     * @author: XuanHuynh
     * @since: 16/10/2024 1:05 AM
     * description: Đếm tổng số khách hàng
     * update:
     */
    public long countAllNguoiDung() {
        return nguoiDungRepository.count();
    }

    /*
     * @author: XuanHuynh
     * @since: 16/10/2024 1:05 AM
     * description: Đếm số khách hàng chưa bị xóa mềm
     * update:
     */
    public long countSoftNguoiDung() {
        return nguoiDungRepository.countByNgayXoaIsNull();
    }

    /*
     * @author: XuanHuynh
     * @since: 16/10/2024 10:12 PM
     * description: Phân trang gồm số trang, số lượng
     * update:
     */
    public Page<NguoiDungResponse> getPhanTrangNguoiDung(int trang, int sl) {
        Pageable pageable = PageRequest.of(trang, sl); // Tạo đối tượng Pageable với trang và số lượng phần tử

        // Truy xuất danh sách khách hàng với phân trang
        Page<NguoiDung> nguoiDungPage = nguoiDungRepository.findAll(pageable);

        // Ánh xạ từng đối tượng NguoiDung thành NguoiDungResponse
        return nguoiDungPage.map(nguoiDungMapper::toNguoiDungResponse);
    }
}
