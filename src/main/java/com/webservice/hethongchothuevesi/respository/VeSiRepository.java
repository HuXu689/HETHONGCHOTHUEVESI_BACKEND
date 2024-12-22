package com.webservice.hethongchothuevesi.respository;

import com.webservice.hethongchothuevesi.dto.dto.VeSiDTO;
import com.webservice.hethongchothuevesi.entity.VeSi;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface VeSiRepository extends JpaRepository<VeSi, Integer> {
    List<VeSi> findByNgayXoaIsNull();

    Optional<VeSi> findByIdVeSi(int idVeSi);

    Optional<VeSi> findByIdVeSiAndNgayXoaIsNull(int idVeSi);

    long countByNgayXoaIsNull();

    Page<VeSi> findByNgayXoaIsNull(Pageable pageable);

    // Lấy thêm thông tin từ NguoiDung sang VeSiDTO
    @Query("SELECT new com.webservice.hethongchothuevesi.dto.dto.VeSiDTO("
            + "v.idVeSi, v.idNguoiDung,n.hoTen, v.kinhNghiem, v.thongTinDanhGiaChung, "
            + "n.email, n.ngaySinh, n.gioiTinh, n.soDienThoai, "
            + "v.ngayBatDauLam, v.capBac, v.ngayLenCap, v.luong, v.trangThai, v.ngayXoa) "
            + "FROM VeSi v "
            + "JOIN NguoiDung n ON v.idNguoiDung = n.idNguoiDung "
            + "WHERE v.ngayXoa IS NULL")
    List<VeSiDTO> findAllWithNguoiDungInfo();

    // Lấy thêm thông tin từ NguoiDung sang VeSiDTO theo idVeSi
    @Query("SELECT new com.webservice.hethongchothuevesi.dto.dto.VeSiDTO("
            + "v.idVeSi, v.idNguoiDung, n.hoTen, v.kinhNghiem, v.thongTinDanhGiaChung, "
            + "n.email, n.ngaySinh, n.gioiTinh, n.soDienThoai, "
            + "v.ngayBatDauLam, v.capBac, v.ngayLenCap, v.luong, v.trangThai, v.ngayXoa) "
            + "FROM VeSi v "
            + "JOIN NguoiDung n ON v.idNguoiDung = n.idNguoiDung "
            + "WHERE v.idVeSi = :id AND v.ngayXoa IS NULL")
    VeSiDTO findVeSiWithNguoiDungInfoById(@Param("id") Integer id);

    // Thêm phương thức để lấy VeSiDTO với các giá trị trung bình đánh giá
    @Query("SELECT new com.webservice.hethongchothuevesi.dto.dto.VeSiDTO("
            + "v.idVeSi, v.idNguoiDung, nd.hoTen, v.kinhNghiem, v.thongTinDanhGiaChung, "
            + "nd.email, nd.ngaySinh, nd.gioiTinh, nd.soDienThoai, "
            + "v.ngayBatDauLam, v.capBac, v.ngayLenCap, v.luong, v.trangThai, v.ngayXoa, "
            + "AVG(nv.danhGiaKyNangChuyenMon), "
            + "AVG(nv.danhGiaXuLyTinhHuong), "
            + "AVG(nv.danhGiaThaiDoDaoDuc), "
            + "AVG(nv.danhGiaGiaoTiep), "
            + "AVG(nv.danhGiaNgoaiHinh)) "
            + "FROM VeSi v "
            + "JOIN NguoiDung nd ON v.idNguoiDung = nd.idNguoiDung "
            + "LEFT JOIN NhiemVu nv ON v.idVeSi = nv.idVeSi AND nv.ngayXoa IS NULL "
            + "WHERE v.idVeSi = :idVeSi AND v.ngayXoa IS NULL "
            + "GROUP BY v.idVeSi, v.idNguoiDung, nd.hoTen, v.kinhNghiem, v.thongTinDanhGiaChung, "
            + "nd.email, nd.ngaySinh, nd.gioiTinh, nd.soDienThoai, "
            + "v.ngayBatDauLam, v.capBac, v.ngayLenCap, v.luong, v.trangThai, v.ngayXoa")
    VeSiDTO findVeSiDTOWithAverageRatingsByIdVeSi(@Param("idVeSi") Integer idVeSi);

    @Query("SELECT new com.webservice.hethongchothuevesi.dto.dto.VeSiDTO("
            + "v.idVeSi, v.idNguoiDung, nd.hoTen, v.kinhNghiem, v.thongTinDanhGiaChung, "
            + "nd.email, nd.ngaySinh, nd.gioiTinh, nd.soDienThoai, "
            + "v.ngayBatDauLam, v.capBac, v.ngayLenCap, v.luong, v.trangThai, v.ngayXoa, "
            + "AVG(nv.danhGiaKyNangChuyenMon), "
            + "AVG(nv.danhGiaXuLyTinhHuong), "
            + "AVG(nv.danhGiaThaiDoDaoDuc), "
            + "AVG(nv.danhGiaGiaoTiep), "
            + "AVG(nv.danhGiaNgoaiHinh)) "
            + "FROM VeSi v "
            + "JOIN NguoiDung nd ON v.idNguoiDung = nd.idNguoiDung "
            + "JOIN NhiemVu nv ON v.idVeSi = nv.idVeSi "
            + "WHERE nv.idHopDong = :idHopDong AND v.ngayXoa IS NULL AND nv.ngayXoa IS NULL "
            + "GROUP BY v.idVeSi, v.idNguoiDung, nd.hoTen, v.kinhNghiem, v.thongTinDanhGiaChung, "
            + "nd.email, nd.ngaySinh, nd.gioiTinh, nd.soDienThoai, "
            + "v.ngayBatDauLam, v.capBac, v.ngayLenCap, v.luong, v.trangThai, v.ngayXoa")
    List<VeSiDTO> findVeSiDTOsByIdHopDong(@Param("idHopDong") Integer idHopDong);

}
