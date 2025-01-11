package com.webservice.hethongchothuevesi.service;

import com.webservice.hethongchothuevesi.dto.request.NguoiDungChangePasswordRequest;
import com.webservice.hethongchothuevesi.dto.request.NguoiDungCreationRequest;
import com.webservice.hethongchothuevesi.dto.request.NguoiDungUpdateRequest;
import com.webservice.hethongchothuevesi.dto.response.NguoiDungResponse;
import com.webservice.hethongchothuevesi.entity.NguoiDung;
import com.webservice.hethongchothuevesi.entity.NguoiDungVaiTro;
import com.webservice.hethongchothuevesi.exception.AppException;
import com.webservice.hethongchothuevesi.exception.ErrorCode;
import com.webservice.hethongchothuevesi.mapper.NguoiDungMapper;
import com.webservice.hethongchothuevesi.respository.NguoiDungRepository;
import com.webservice.hethongchothuevesi.respository.NguoiDungVaiTroRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class NguoiDungService {
    NguoiDungRepository nguoiDungRepository;
    NguoiDungMapper nguoiDungMapper;
    AuthenticationService authenticationService;
    NguoiDungVaiTroRepository nguoiDungVaiTroRepository;

    /*
     * @author: XuanHuynh
     * @since: 13/10/2024 12:07 SA
     * description: Tạo tài khoản khách hàng mới
     * update:
     */
    public NguoiDungResponse createRequest(NguoiDungCreationRequest request) {
        if (Boolean.TRUE.equals(nguoiDungRepository.existsByTenDangNhap(request.getTenDangNhap()))) {
            throw new AppException(ErrorCode.TENDANGNHAP_EXISTED);
        }

        NguoiDung nguoiDung = nguoiDungMapper.toNguoiDung(request);

        // Đặt trạng thái mặc định là "Hoạt động"
        nguoiDung.setTrangThai("Hoạt động");
        nguoiDung.setMatKhau(authenticationService.encryption(request.getMatKhau()));
        nguoiDung = nguoiDungRepository.save(nguoiDung);
        // Đặt vai trò là Khách hàng
        NguoiDungVaiTro nguoiDungVaiTro = NguoiDungVaiTro.builder()
                .idNguoiDung(nguoiDung.getIdNguoiDung())
                .idVaiTro(1)
                .build();

        nguoiDungVaiTroRepository.save(nguoiDungVaiTro);
        return nguoiDungMapper.toNguoiDungResponse(nguoiDungRepository.save(nguoiDung));
    }

    /*
     * @author: XuanHuynh
     * @since: 10/14/2024 12:27 PM
     * description: Cập nhật thông tin người dùng
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
     * description: Thay đổi mật khẩu người dùng
     * update:
     */
    public boolean changePasswordRequest(int id, NguoiDungChangePasswordRequest request) {
        NguoiDung nguoiDung = findNguoiDungById(id);
        log.info("Người dùng: {}", nguoiDung);
        if (authenticationService.checkNguoiDungId(id, request.getMatKhauCu())) {
            nguoiDung.setMatKhau(authenticationService.encryption(request.getMatKhauMoi()));
            nguoiDungRepository.save(nguoiDung);
            return true;
        }
        return false;
    }

    /*
     * @author: XuanHuynh
     * @since: 17/12/2024 4:47 PM
     * description: Thay đổi mật khẩu người dùng qua email (không cần mật khẩu cũ)
     * update:
     */
    public boolean changePasswordByEmail(int id, NguoiDungChangePasswordRequest request) {
        NguoiDung nguoiDung = findNguoiDungById(id);
        nguoiDung.setMatKhau(authenticationService.encryption(request.getMatKhauMoi()));
        nguoiDungRepository.save(nguoiDung);
        return true;
    }

    /*
     * @author: XuanHuynh
     * @since: 10/14/2024 12:27 PM
     * description: Xóa mềm người dùng
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
     * description: Xóa vĩnh viễn người dùng
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
     * description: Khôi phục người dùng đã xóa mềm
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
     * description: Lấy dữ liệu của tất cả người dùng chưa bị xóa mềm
     * update:
     */
    public List<NguoiDungResponse> getAllSoftRequest() {
        return nguoiDungMapper.toNguoiDungResponse(nguoiDungRepository.findByNgayXoaIsNull());
    }

    /*
     * @author: XuanHuynh
     * @since: 13/10/2024 12:07 SA
     * description: Lấy dữ liệu của tất cả người dùng
     * update:
     */
    public List<NguoiDungResponse> getAllRequest() {

        // Liệt kê danh sách vai trò của người dùng đang login
        //        var authentication = SecurityContextHolder.getContext().getAuthentication();
        //        log.info("Tên đăng nhập: {}", authentication.getName());
        //        authentication.getAuthorities().forEach(grantedAuthority -> log.info("Vai trò: {}",
        // grantedAuthority.getAuthority()));

        return nguoiDungMapper.toNguoiDungResponse(nguoiDungRepository.findAll());
    }

    /*
     * @author: XuanHuynh
     * @since: 13/10/2024 12:08 SA
     * description: Lấy dữ liệu của người dùng theo ID chưa bị xóa mềm
     * update:
     */
    public NguoiDungResponse getSoftRequestById(int id) {
        return nguoiDungMapper.toNguoiDungResponse(nguoiDungRepository
                .findByIdNguoiDungAndNgayXoaIsNull(id)
                .orElseThrow(() -> new AppException(ErrorCode.NGUOIDUNG_NOT_EXISTED)));
    }

    /*
     * @author: XuanHuynh
     * @since: 16/10/2024 1:05 AM
     * description: Tìm kiếm người dùng chưa bị xóa mềm theo tên đăng nhập hoặc email
     * update:
     */
    public List<NguoiDungResponse> searchSoftNguoiDung(String keyword) {
        List<NguoiDung> nguoiDungList =
                nguoiDungRepository.findByTenDangNhapContainingOrEmailContainingAndNgayXoaIsNull(keyword, keyword);
        return nguoiDungMapper.toNguoiDungResponse(nguoiDungList);
    }

    /*
     * @author: XuanHuynh
     * @since: 16/10/2024 1:05 AM
     * description: Đếm số người dùng chưa bị xóa mềm
     * update:
     */
    public long countSoftNguoiDung() {
        return nguoiDungRepository.countByNgayXoaIsNull();
    }

    /*
     * @author: XuanHuynh
     * @since: 5/12/2024 11:50 PM
     * description: Lấy dữ liêu phân trang cho người dùng chưa xóa mềm
     * update:
     */
    public Page<NguoiDungResponse> getPhanTrangSoftNguoiDung(int trang, int sl) {
        Pageable pageable = PageRequest.of(trang, sl);
        Page<NguoiDung> nguoiDungPage = nguoiDungRepository.findByNgayXoaIsNull(pageable);
        return nguoiDungPage.map(nguoiDungMapper::toNguoiDungResponse);
    }

    /*
     * @author: XuanHuynh
     * @since: 16/10/2024 1:05 AM
     * description: Tìm người dùng theo ID
     * update:
     */
    private NguoiDung findNguoiDungById(int id) {
        return nguoiDungRepository.findById(id).orElseThrow(() -> new AppException(ErrorCode.NGUOIDUNG_NOT_EXISTED));
    }

    /*
     * @author: XuanHuynh
     * @since: 18/12/2024 1:42 PM
     * description: Tìm người duùng theo tên đăng nhập
     * update:
     */
    public NguoiDungResponse findNguoiDungByTenDangNhap(String tenDangNhap) {
        return nguoiDungMapper.toNguoiDungResponse(nguoiDungRepository
                .findByTenDangNhapAndNgayXoaIsNull(tenDangNhap)
                .orElseThrow(() -> new AppException(ErrorCode.NGUOIDUNG_NOT_EXISTED)));
    }

    /*
     * @author: XuanHuynh
     * @since: 13/10/2024 12:08 SA
     * description: Lấy dữ liệu của người dùng theo ID
     * update:
     */
    public NguoiDungResponse getRequestById(int id) {
        return nguoiDungMapper.toNguoiDungResponse(findNguoiDungById(id));
    }

    /*
     * @author: XuanHuynh
     * @since: 16/10/2024 1:05 AM
     * description: Tìm kiếm người dùng theo tên đăng nhập hoặc email
     * update:
     */
    public List<NguoiDungResponse> searchNguoiDung(String keyword) {
        List<NguoiDung> nguoiDungList =
                nguoiDungRepository.findByTenDangNhapContainingOrEmailContaining(keyword, keyword);
        return nguoiDungMapper.toNguoiDungResponse(nguoiDungList);
    }

    /*
     * @author: XuanHuynh
     * @since: 17/10/2024 12:00 PM
     * description: Đổi trạng thái người dùng thành "Bị khóa"
     * update:
     */
    public NguoiDungResponse blockNguoiDung(int id) {
        NguoiDung nguoiDung = findNguoiDungById(id);

        // Kiểm tra nếu người dùng đã bị khóa trước đó
        if ("Bị khóa".equals(nguoiDung.getTrangThai())) {
            throw new AppException(ErrorCode.NGUOIDUNG_ALREADY_BLOCKED);
        }

        nguoiDung.setTrangThai("Bị khóa");
        nguoiDungRepository.save(nguoiDung);

        return nguoiDungMapper.toNguoiDungResponse(nguoiDung);
    }

    /*
     * @author: XuanHuynh
     * @since: 16/10/2024 1:05 AM
     * description: Đếm tổng số người dùng
     * update:
     */
    public long countAllNguoiDung() {
        return nguoiDungRepository.count();
    }

    /*
     * @author: XuanHuynh
     * @since: 16/10/2024 10:12 PM
     * description: Phân trang gồm số trang, số lượng
     * update:
     */
    public Page<NguoiDungResponse> getPhanTrangNguoiDung(int trang, int sl) {
        Pageable pageable = PageRequest.of(trang, sl); // Tạo đối tượng Pageable với trang và số lượng phần tử

        // Truy xuất danh sách người dùng với phân trang
        Page<NguoiDung> nguoiDungPage = nguoiDungRepository.findAll(pageable);

        // Ánh xạ từng đối tượng NguoiDung thành NguoiDungResponse
        return nguoiDungPage.map(nguoiDungMapper::toNguoiDungResponse);
    }

    /*
     * @author: XuanHuynh
     * @since: 12/12/2024 12:27 PM
     * description: Lấy thông tin người dùng đang đăng nhập
     * update:
     */
    public NguoiDungResponse getCurrentLoggedInUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if (authentication == null || !authentication.isAuthenticated()) {
            throw new AppException(ErrorCode.UN_AUTHENTICATED); // hoặc bất kì Exception thích hợp
        }

        String username = authentication.getName(); // Tên đăng nhập người dùng hiện tại

        // Tìm người dùng theo tên đăng nhập
        NguoiDung nguoiDung = nguoiDungRepository
                .findByTenDangNhap(username)
                .orElseThrow(() -> new AppException(ErrorCode.NGUOIDUNG_NOT_EXISTED));

        // Ánh xạ sang response
        return nguoiDungMapper.toNguoiDungResponse(nguoiDung);
    }
}
