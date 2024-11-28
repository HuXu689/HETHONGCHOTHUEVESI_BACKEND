package com.webservice.hethongchothuevesi.service;

import java.time.LocalDateTime;
import java.util.List;

import com.webservice.hethongchothuevesi.dto.request.KhachHangChangePasswordRequest;
import com.webservice.hethongchothuevesi.dto.request.KhachHangCreationRequest;
import com.webservice.hethongchothuevesi.dto.request.KhachHangUpdateRequest;
import com.webservice.hethongchothuevesi.dto.response.KhachHangResponse;
import com.webservice.hethongchothuevesi.entity.KhachHang;
import com.webservice.hethongchothuevesi.enums.Role;
import com.webservice.hethongchothuevesi.exception.AppException;
import com.webservice.hethongchothuevesi.exception.ErrorCode;
import com.webservice.hethongchothuevesi.mapper.KhachHangMapper;
import com.webservice.hethongchothuevesi.respository.KhachHangRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class KhachHangService {
	KhachHangRepository khachHangRepository;
	KhachHangMapper khachHangMapper;
	AuthenticationService authenticationService;

	/*
	 * @author: XuanHuynh
	 * @since: 13/10/2024 12:07 SA
	 * description: Tạo tài khoản khách hàng mới
	 * update:
	 */
	public KhachHangResponse createRequest(KhachHangCreationRequest request) {
		if (khachHangRepository.existsByTenDangNhap(request.getTenDangNhap())) {
			throw new AppException(ErrorCode.TENDANGNHAP_EXISTED);
		}

		KhachHang khachHang = khachHangMapper.toKhachHang(request);
		khachHang.setMatKhau(authenticationService.encryption(request.getMatKhau()));

		khachHang.setRole(Role.USER.name());

		return khachHangMapper.toKhachHangResponse(khachHangRepository.save(khachHang));
	}

	/*
	 * @author: XuanHuynh
	 * @since: 10/14/2024 12:27 PM
	 * description: Cập nhật thông tin khách hàng
	 * update:
	 */
	public KhachHangResponse updateRequest(int id, KhachHangUpdateRequest request) {
		KhachHang khachHang = findKhachHangById(id);
		khachHangMapper.updateKhachHang(khachHang, request);
		return khachHangMapper.toKhachHangResponse(khachHangRepository.save(khachHang));
	}

	/*
	 * @author: XuanHuynh
	 * @since: 10/14/2024 12:27 PM
	 * description: Thay đổi mật khẩu khách hàng
	 * update:
	 */
	public boolean changePasswordRequest(int id, KhachHangChangePasswordRequest request) {
		KhachHang khachHang = findKhachHangById(id);
		if (authenticationService.checkKhachHangId(id, request.getMatKhauCu())) {
			khachHang.setMatKhau(authenticationService.encryption(request.getMatKhauMoi()));
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
		KhachHang khachHang = findKhachHangById(id);
		khachHang.setNgayXoa(LocalDateTime.now());
		khachHangRepository.save(khachHang); // Lưu trạng thái xóa mềm
	}

	/*
	 * @author: XuanHuynh
	 * @since: 10/14/2024 12:27 PM
	 * description: Xóa vĩnh viễn khách hàng
	 * update:
	 */
	public void deleteRequest(int id) {
		KhachHang khachHang = findKhachHangById(id);
		if (khachHang.getNgayXoa() == null) {
			throw new AppException(ErrorCode.KHACHHANG_NOT_DELETED);
		}
		khachHangRepository.delete(khachHang);
	}

	/*
	 * @author: XuanHuynh
	 * @since: 16/10/2024 1:05 AM
	 * description: Khôi phục khách hàng đã xóa mềm
	 * update:
	 */
	public KhachHangResponse restoreSoftDeletedRequest(int id) {
		KhachHang khachHang = findKhachHangById(id);
		if (khachHang.getNgayXoa() == null) {
			throw new AppException(ErrorCode.KHACHHANG_NOT_DELETED); // Nếu chưa bị xóa mềm
		}
		khachHang.setNgayXoa(null); // Khôi phục trạng thái
		khachHangRepository.save(khachHang);
		return khachHangMapper.toKhachHangResponse(khachHang);
	}

	/*
	 * @author: XuanHuynh
	 * @since: 10/14/2024 6:56 PM
	 * description: Lấy dữ liệu của tất cả khách hàng chưa bị xóa mềm
	 * update:
	 */
	public List<KhachHangResponse> getAllSoftRequest() {
		return khachHangMapper.toKhachHangResponse(khachHangRepository.findByNgayXoaIsNull());
	}

	/*
	 * @author: XuanHuynh
	 * @since: 13/10/2024 12:07 SA
	 * description: Lấy dữ liệu của tất cả khách hàng
	 * update:
	 */
	public List<KhachHangResponse> getAllRequest() {
		return khachHangMapper.toKhachHangResponse(khachHangRepository.findAll());
	}

	/*
	 * @author: XuanHuynh
	 * @since: 13/10/2024 12:08 SA
	 * description: Lấy dữ liệu của khách hàng theo ID chưa bị xóa mềm
	 * update:
	 */
	public KhachHangResponse getSoftRequestById(int id) {
		return khachHangMapper.toKhachHangResponse(khachHangRepository
				.findByIdKhachHangAndNgayXoaIsNull(id)
				.orElseThrow(() -> new AppException(ErrorCode.KHACHHANG_NOT_EXISTED)));
	}

	/*
	 * @author: XuanHuynh
	 * @since: 13/10/2024 12:08 SA
	 * description: Lấy dữ liệu của khách hàng theo ID
	 * update:
	 */
	public KhachHangResponse getRequestById(int id) {
		return khachHangMapper.toKhachHangResponse(findKhachHangById(id));
	}

	/*
	 * @author: XuanHuynh
	 * @since: 16/10/2024 1:05 AM
	 * description: Tìm kiếm khách hàng theo tên đăng nhập hoặc email
	 * update:
	 */
	public List<KhachHangResponse> searchKhachHang(String keyword) {
		List<KhachHang> khachHangList =
				khachHangRepository.findByTenDangNhapContainingOrEmailContaining(keyword, keyword);
		return khachHangMapper.toKhachHangResponse(khachHangList);
	}

	/*
	 * @author: XuanHuynh
	 * @since: 16/10/2024 1:05 AM
	 * description: Tìm khách hàng theo ID
	 * update:
	 */
	private KhachHang findKhachHangById(int id) {
		return khachHangRepository.findById(id).orElseThrow(() -> new AppException(ErrorCode.KHACHHANG_NOT_EXISTED));
	}

	/*
	 * @author: XuanHuynh
	 * @since: 16/10/2024 1:05 AM
	 * description: Đếm tổng số khách hàng
	 * update:
	 */
	public long countAllKhachHang() {
		return khachHangRepository.count();
	}

	/*
	 * @author: XuanHuynh
	 * @since: 16/10/2024 1:05 AM
	 * description: Đếm số khách hàng chưa bị xóa mềm
	 * update:
	 */
	public long countSoftKhachHang() {
		return khachHangRepository.countByNgayXoaIsNull();
	}

	/*
	 * @author: XuanHuynh
	 * @since: 16/10/2024 10:12 PM
	 * description: Phân trang gồm số trang, số lượng
	 * update:
	 */
	public Page<KhachHangResponse> getPhanTrangKhachHang(int trang, int sl) {
		Pageable pageable = PageRequest.of(trang, sl); // Tạo đối tượng Pageable với trang và số lượng phần tử

		// Truy xuất danh sách khách hàng với phân trang
		Page<KhachHang> khachHangPage = khachHangRepository.findAll(pageable);

		// Ánh xạ từng đối tượng KhachHang thành KhachHangResponse
		return khachHangPage.map(khachHangMapper::toKhachHangResponse);
	}
}
