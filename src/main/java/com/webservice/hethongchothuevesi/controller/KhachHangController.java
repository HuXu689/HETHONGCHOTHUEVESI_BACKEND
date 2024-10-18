package com.webservice.hethongchothuevesi.controller;

import com.webservice.hethongchothuevesi.dto.request.ApiResponse;
import com.webservice.hethongchothuevesi.dto.request.KhachHangCreationRequest;
import com.webservice.hethongchothuevesi.dto.request.KhachHangUpdateRequest;
import com.webservice.hethongchothuevesi.dto.response.KhachHangResponse;
import com.webservice.hethongchothuevesi.service.KhachHangService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/KhachHang")
public class KhachHangController {
    @Autowired
    private KhachHangService khachHangService;

    /*
    * @author: XuanHuynh
    * @since: 13/10/2024 12:07 SA
    * description: Tạo tài khoản khách hàng mới
    * update:
    */
    @PostMapping("/Create")
    ApiResponse createKhachHang(@RequestBody @Valid KhachHangCreationRequest request) {
        ApiResponse apiResponse = new ApiResponse();

        apiResponse.setResult(khachHangService.createRequest(request));

        return apiResponse;
    }

    /*
    * @author: XuanHuynh
    * @since: 10/14/2024 12:33 PM
    * description: Cập nhật thông tin khách hàng theo ID
    * update:
    */
    @PutMapping("/Update/{id}")
    ApiResponse updateKhachHang(@PathVariable("id") int id, @RequestBody @Valid KhachHangUpdateRequest request) {
        ApiResponse apiResponse = new ApiResponse();

        apiResponse.setResult(khachHangService.updateRequest(id, request));

        return apiResponse;
    }

    /*
    * @author: XuanHuynh
    * @since: 10/14/2024 6:46 PM
    * description: Xóa mềm dữ liệu khách hàng theo ID
    * update:
    */
    @PatchMapping("/Delete/{id}/SoftDelete")
    boolean deleteSoftKhachHang(@PathVariable("id") int id) {
        khachHangService.deleteSoftRequest(id);
        return true;
    }

    /*
    * @author: XuanHuynh
    * @since: 10/14/2024 6:46 PM
    * description: Xóa cứng dữ liệu khách hàng theo ID
    * update:
    */
    @DeleteMapping("/Delete/{id}/HardDelete")
    boolean deleteHardKhachHang(@PathVariable("id") int id) {
        khachHangService.deleteRequest(id);
        return true;
    }

    /*
    * @author: XuanHuynh
    * @since: 13/10/2024 12:07 SA
    * description: Lấy dữ liệu của tất cả khách hàng
    * update:
    */
    @GetMapping("/GetAll")
    List<KhachHangResponse> getAllKhachHang() {
        return khachHangService.getAllRequest();
    }

    /*
    * @author: XuanHuynh
    * @since: 13/10/2024 12:08 SA
    * description: Lấy dữ liệu của khách hàng theo ID
    * update:
    */
    @GetMapping("/GetById/{id}")
    KhachHangResponse getKhachHangById(@PathVariable("id") int id) {
        return khachHangService.getRequestById(id);
    }

    /*
     * @author: XuanHuynh
     * @since: 16/10/2024 1:10 AM
     * description: Khôi phục khách hàng đã xóa mềm theo ID
     * update:
     */
    @PatchMapping("/Restore/{id}")
    ApiResponse restoreKhachHang(@PathVariable("id") int id) {
        ApiResponse apiResponse = new ApiResponse();

        apiResponse.setResult(khachHangService.restoreSoftDeletedRequest(id));

        return apiResponse;
    }

    /*
     * @author: XuanHuynh
     * @since: 16/10/2024 1:10 AM
     * description: Lấy danh sách khách hàng chưa bị xóa mềm
     * update:
     */
    @GetMapping("/GetAll/Soft")
    List<KhachHangResponse> getAllSoftKhachHang() {
        return khachHangService.getAllSoftRequest();
    }

    /*
     * @author: XuanHuynh
     * @since: 16/10/2024 1:10 AM
     * description: Lấy dữ liệu khách hàng theo ID nếu chưa bị xóa mềm
     * update:
     */
    @GetMapping("/GetById/Soft/{id}")
    KhachHangResponse getSoftKhachHangById(@PathVariable("id") int id) {
        return khachHangService.getSoftRequestById(id);
    }

    /*
     * @author: XuanHuynh
     * @since: 16/10/2024 1:10 AM
     * description: Tìm kiếm khách hàng theo tên đăng nhập hoặc email
     * update:
     */
    @GetMapping("/Search")
    List<KhachHangResponse> searchKhachHang(@RequestParam("keyword") String keyword) {
        return khachHangService.searchKhachHang(keyword);
    }

    /*
     * @author: XuanHuynh
     * @since: 16/10/2024 1:10 AM
     * description: Đếm tổng số khách hàng
     * update:
     */
    @GetMapping("/CountAll")
    long countAllKhachHang() {
        return khachHangService.countAllKhachHang();
    }

    /*
     * @author: XuanHuynh
     * @since: 16/10/2024 1:10 AM
     * description: Đếm số khách hàng chưa bị xóa mềm
     * update:
     */
    @GetMapping("/CountSoft")
    long countSoftKhachHang() {
        return khachHangService.countSoftKhachHang();
    }

    /*
     * @author: XuanHuynh
     * @since: 16/10/2024 10:15 PM
     * description: Phân trang khách hàng với số trang và số lượng phần tử
     * update:
     */
    @GetMapping("/GetPaged")
    Page<KhachHangResponse> getPagedKhachHang(@RequestParam("trang") int trang, @RequestParam("sl") int sl) {
        return khachHangService.getPhanTrangKhachHang(trang, sl);
    }

}
