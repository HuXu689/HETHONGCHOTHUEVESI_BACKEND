package com.webservice.hethongchothuevesi.respository;

import com.webservice.hethongchothuevesi.entity.NguoiDung;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface NguoiDungRepository extends JpaRepository<NguoiDung, Integer> {
    // Tìm tất cả các khách hàng chưa bị xóa mềm (ngayXoa = null)
    List<NguoiDung> findByNgayXoaIsNull();

    // Tìm khách hàng theo idNguoiDung
    Optional<NguoiDung> findByIdNguoiDung(int idNguoiDung);

    // Tìm khách hàng theo idNguoiDung và chưa bị xóa mềm
    Optional<NguoiDung> findByIdNguoiDungAndNgayXoaIsNull(int idNguoiDung);

    // Kiểm tra tên đăng nhập đã có hay có hay chưa
    Boolean existsByTenDangNhap(String tenDangNhap);

    // Đếm số lượng dữ liệu chưa bị xóa mềm
    long countByNgayXoaIsNull();

    // Tạo hàm để tìm kiếm khách hàng dựa trên tên đăng nhập hoặc email chứa từ khóa
    List<NguoiDung> findByTenDangNhapContainingOrEmailContaining(String tenDangNhap, String email);

    // Tìm kiếm tất cả trả về danh sách List
    List<NguoiDung> findAll();

    // Tìm kiếm phân trang
    Page<NguoiDung> findAll(Pageable pageable);

    // Tìm kiếm phân trang chưa xóa mềm
    Page<NguoiDung> findByNgayXoaIsNull(Pageable pageable);

    // Tìm kiếm tên đăng nhập có hay không
    Optional<NguoiDung> findByTenDangNhap(String tenDangNhap);

    // Phương thức tìm kiếm người dùng chưa bị xóa mềm
    List<NguoiDung> findByTenDangNhapContainingOrEmailContainingAndNgayXoaIsNull(String keywordTenDangNhap, String keywordEmail);
}
