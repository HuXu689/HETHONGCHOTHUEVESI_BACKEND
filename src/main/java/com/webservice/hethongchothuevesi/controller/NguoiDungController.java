package com.webservice.hethongchothuevesi.controller;

import java.util.List;

import com.webservice.hethongchothuevesi.dto.request.ApiResponse;
import com.webservice.hethongchothuevesi.dto.request.NguoiDungChangePasswordRequest;
import com.webservice.hethongchothuevesi.dto.request.NguoiDungCreationRequest;
import com.webservice.hethongchothuevesi.dto.request.NguoiDungUpdateRequest;
import com.webservice.hethongchothuevesi.dto.response.NguoiDungResponse;
import com.webservice.hethongchothuevesi.service.NguoiDungService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/NguoiDung")
public class NguoiDungController {
	@Autowired
	private NguoiDungService NguoiDungService;

	/*
	 * @author: XuanHuynh
	 * @since: 13/10/2024 12:07 SA
	 * description: Tạo tài khoản NguoiDung mới
	 * update:
	 */
	@PostMapping("/Create")
	public ApiResponse<NguoiDungResponse> createNguoiDung(@RequestBody @Valid NguoiDungCreationRequest request) {
		ApiResponse<NguoiDungResponse> apiResponse = new ApiResponse();

		apiResponse.setResult(NguoiDungService.createRequest(request));

		return apiResponse;
	}

	/*
	 * @author: XuanHuynh
	 * @since: 10/14/2024 12:33 PM
	 * description: Cập nhật thông tin NguoiDung theo ID
	 * update:
	 */
	@PutMapping("/Update/{id}")
	@PreAuthorize("hasRole('Admin') or #id == authentication.principal.id")
	public ApiResponse<NguoiDungResponse> updateNguoiDung(
			@PathVariable("id") int id, @RequestBody @Valid NguoiDungUpdateRequest request) {
		ApiResponse<NguoiDungResponse> apiResponse = new ApiResponse();

		apiResponse.setResult(NguoiDungService.updateRequest(id, request));

		return apiResponse;
	}

	@PutMapping("/ChangePassword/{id}")
	@PreAuthorize("hasRole('Admin') or #id == authentication.principal.id")
	public boolean changePassword(
			@PathVariable("id") int id, @RequestBody @Valid NguoiDungChangePasswordRequest request) {
		return NguoiDungService.changePasswordRequest(id, request);
	}

	/*
	 * @author: XuanHuynh
	 * @since: 10/14/2024 6:46 PM
	 * description: Xóa mềm dữ liệu NguoiDung theo ID
	 * update:
	 */
	@PatchMapping("/Delete/{id}")
	@PreAuthorize("hasRole('Admin')")
	public boolean deleteSoftNguoiDung(@PathVariable("id") int id) {
		NguoiDungService.deleteSoftRequest(id);
		return true;
	}

	/*
	 * @author: XuanHuynh
	 * @since: 13/10/2024 12:07 SA
	 * description: Lấy dữ liệu của tất cả NguoiDung chưa xóa mềm
	 * update:
	 */
	@GetMapping("/GetAll")
	public List<NguoiDungResponse> getAllSoftNguoiDung() {
		return NguoiDungService.getAllSoftRequest();
	}

	/*
	 * @author: XuanHuynh
	 * @since: 13/10/2024 12:08 SA
	 * description: Lấy dữ liệu của NguoiDung theo ID chưa xóa mềm
	 * update:
	 */
	@GetMapping("/GetById/{id}")
	public NguoiDungResponse getSoftRequestById(@PathVariable("id") int id) {
		return NguoiDungService.getSoftRequestById(id);
	}

	/*
	 * @author: XuanHuynh
	 * @since: 16/10/2024 1:10 AM
	 * description: Tìm kiếm NguoiDung chưa xóa mềm theo tên đăng nhập hoặc email
	 * update:
	 */
	@GetMapping("/Search")
	public List<NguoiDungResponse> searchSoftNguoiDung(@RequestParam("keyword") String keyword) {
		return NguoiDungService.searchSoftNguoiDung(keyword);
	}

	/*
	 * @author: XuanHuynh
	 * @since: 16/10/2024 1:10 AM
	 * description: Đếm tổng số NguoiDung chưa xóa mềm
	 * update:
	 */
	@GetMapping("/CountAll")
	public long countAllSoftNguoiDung() {
		return NguoiDungService.countSoftNguoiDung();
	}

	/*
	 * @author: XuanHuynh
	 * @since: 16/10/2024 1:10 AM
	 * description: Đếm số NguoiDung chưa bị xóa mềm
	 * update:
	 */
	//    @GetMapping("/CountSoft")
	//    public long countSoftNguoiDung() {
	//        return NguoiDungService.countSoftNguoiDung();
	//    }

	/*
	 * @author: XuanHuynh
	 * @since: 16/10/2024 10:15 PM
	 * description: Phân trang NguoiDung với số trang và số lượng phần tử
	 * update:
	 */
	@GetMapping("/GetPaged")
	public Page<NguoiDungResponse> getPagedNguoiDung(@RequestParam("trang") int trang, @RequestParam("sl") int sl) {
		return NguoiDungService.getPhanTrangNguoiDung(trang - 1, sl);
	}
	/*
	 * @author: XuanHuynh
	 * @since: 10/14/2024 6:46 PM
	 * description: Xóa cứng dữ liệu NguoiDung theo ID
	 * update:
	 */
	//	@DeleteMapping("/Delete/{id}/HardDelete")
	//	public boolean deleteHardNguoiDung(@PathVariable("id") int id) {
	//		NguoiDungService.deleteRequest(id);
	//		return true;
	//	}

	/*
	 * @author: XuanHuynh
	 * @since: 16/10/2024 1:10 AM
	 * description: Khôi phục NguoiDung đã xóa mềm theo ID
	 * update:
	 */
	//    @PatchMapping("/Restore/{id}")
	//    public ApiResponse<NguoiDungResponse> restoreNguoiDung(@PathVariable("id") int id) {
	//        ApiResponse<NguoiDungResponse> apiResponse = new ApiResponse();
	//
	//        apiResponse.setResult(NguoiDungService.restoreSoftDeletedRequest(id));
	//
	//        return apiResponse;
	//    }

	/*
	 * @author: XuanHuynh
	 * @since: 16/10/2024 1:10 AM
	 * description: Lấy danh sách NguoiDung chưa bị xóa mềm
	 * update:
	 */
	//    @GetMapping("/GetAll/Soft")
	//    public List<NguoiDungResponse> getAllSoftNguoiDung() {
	//        return NguoiDungService.getAllSoftRequest();
	//    }

	/*
	 * @author: XuanHuynh
	 * @since: 16/10/2024 1:10 AM
	 * description: Lấy dữ liệu NguoiDung theo ID nếu chưa bị xóa mềm
	 * update:
	 */
	//    @GetMapping("/GetById/Soft/{id}")
	//    public NguoiDungResponse getSoftNguoiDungById(@PathVariable("id") int id) {
	//        return NguoiDungService.getSoftRequestById(id);
	//    }
}
