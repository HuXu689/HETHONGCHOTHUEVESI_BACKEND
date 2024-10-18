package com.webservice.hethongchothuevesi.respository;

import com.webservice.hethongchothuevesi.entity.KhachHang;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface KhachHangRepository extends JpaRepository<KhachHang, Integer> {
    // Tìm tất cả các khách hàng chưa bị xóa mềm (ngayXoa = null)
    List<KhachHang> findByNgayXoaIsNull();

    // Tìm khách hàng theo idKhachHang và chưa bị xóa mềm
    Optional<KhachHang> findByIdKhachHangAndNgayXoaIsNull(int idKhachHang);

    // Kiểm tra tên đăng nhập đã có hay có hay chưa
    Boolean existsByTenDangNhap(String tenDangNhap);

    //Đếm số lượng dữ liệu chưa bị xóa mềm
    long countByNgayXoaIsNull();

    // Tạo hàm để tìm kiếm khách hàng dựa trên tên đăng nhập hoặc email chứa từ khóa
    List<KhachHang> findByTenDangNhapContainingOrEmailContaining(String tenDangNhap, String email);

    //Tìm kiếm tất cả trả về danh sách List
    List<KhachHang> findAll();
    //Tìm kiếm phân trang
    Page<KhachHang> findAll(Pageable pageable);

    //Tìm kiếm tên đăng nhập có hay không
    Optional<KhachHang> findByTenDangNhap(String tenDangNhap);
}

