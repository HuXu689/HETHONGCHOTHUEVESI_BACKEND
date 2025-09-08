package com.webservice.hethongchothuevesi.repository;

import com.webservice.hethongchothuevesi.dto.dto.NhiemVuDTO;
import com.webservice.hethongchothuevesi.entity.NhiemVu;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface NhiemVuRepository extends JpaRepository<NhiemVu, Integer> {

    // Lấy tất cả nhiệm vụ chưa bị xóa mềm
    List<NhiemVu> findByNgayXoaIsNull();

    // Lấy tất cả nhiệm vụ (kể cả đã xóa mềm)
    List<NhiemVu> findAll();

    // Tìm tất cả nhiệm vụ theo idHopDong và chưa bị xóa mềm
    List<NhiemVu> findByIdHopDongAndNgayXoaIsNull(Integer idHopDong);

    // Xóa tất cả các nhiệm vụ theo idHopDong
    @Modifying
    @Transactional
    @Query("DELETE FROM NhiemVu n WHERE n.idHopDong = :idHopDong")
    void deleteByIdHopDong(@Param("idHopDong") Integer idHopDong);

    // Tìm nhiệm vụ theo ID
    Optional<NhiemVu> findByIdNhiemVu(int idNhiemVu);

    // Tìm nhiệm vụ chưa bị xóa theo ID
    Optional<NhiemVu> findByIdNhiemVuAndNgayXoaIsNull(int idNhiemVu);

    // Đếm số lượng nhiệm vụ chưa bị xóa mềm
    long countByNgayXoaIsNull();

    // Lấy danh sách nhiệm vụ chưa bị xóa với phân trang
    Page<NhiemVu> findByNgayXoaIsNull(Pageable pageable);

    // Lấy tất cả nhiệm vụ theo idVeSi chưa bị xóa mềm và trả về NhiemVuDTO kèm hoTen
    @Query("SELECT new com.webservice.hethongchothuevesi.dto.dto.NhiemVuDTO("
            + "n.idNhiemVu, n.idHopDong, n.idVeSi, n.ngayBatDau, n.ngayKetThuc, n.capBac, "
            + "n.noiDung, n.danhGiaKyNangChuyenMon, n.danhGiaXuLyTinhHuong, n.danhGiaThaiDoDaoDuc, "
            + "n.danhGiaGiaoTiep, n.danhGiaNgoaiHinh, n.thongTinDanhGia, n.trangThai, n.ngayXoa, u.hoTen) "
            + "FROM NhiemVu n "
            + "JOIN HopDong h ON n.idHopDong = h.idHopDong "
            + "JOIN YeuCauDichVu y ON h.idYeuCauDichVu = y.idYeuCauDichVu "
            + "JOIN NguoiDung u ON y.idNguoiDung = u.idNguoiDung "
            + "WHERE n.idVeSi = :idVeSi AND n.ngayXoa IS NULL")
    List<NhiemVuDTO> findAllByIdVeSiAndNgayXoaIsNull(@Param("idVeSi") Integer idVeSi);

    // Lấy tất cả nhiệm vụ theo idVeSi và trạng thái chưa bị xóa mềm
    @Query("SELECT new com.webservice.hethongchothuevesi.dto.dto.NhiemVuDTO("
            + "n.idNhiemVu, n.idHopDong, n.idVeSi, n.ngayBatDau, n.ngayKetThuc, n.capBac, "
            + "n.noiDung, n.danhGiaKyNangChuyenMon, n.danhGiaXuLyTinhHuong, n.danhGiaThaiDoDaoDuc, "
            + "n.danhGiaGiaoTiep, n.danhGiaNgoaiHinh, n.thongTinDanhGia, n.trangThai, n.ngayXoa) "
            + "FROM NhiemVu n WHERE n.idVeSi = :idVeSi AND n.trangThai = :trangThai AND n.ngayXoa IS NULL")
    List<NhiemVuDTO> findAllByIdVeSiAndTrangThaiAndNgayXoaIsNull(
            @Param("idVeSi") Integer idVeSi, @Param("trangThai") String trangThai);

    // Lấy tất cả nhiệm vụ theo trạng thái chưa bị xóa mềm
    @Query("SELECT new com.webservice.hethongchothuevesi.dto.dto.NhiemVuDTO("
            + "n.idNhiemVu, n.idHopDong, n.idVeSi, n.ngayBatDau, n.ngayKetThuc, n.capBac, "
            + "n.noiDung, n.danhGiaKyNangChuyenMon, n.danhGiaXuLyTinhHuong, n.danhGiaThaiDoDaoDuc, "
            + "n.danhGiaGiaoTiep, n.danhGiaNgoaiHinh, n.thongTinDanhGia, n.trangThai, n.ngayXoa) "
            + "FROM NhiemVu n WHERE n.trangThai = :trangThai AND n.ngayXoa IS NULL")
    List<NhiemVuDTO> findAllByTrangThaiAndNgayXoaIsNull(@Param("trangThai") String trangThai);

    // Nếu bạn cần tìm một nhiệm vụ cụ thể theo idHopDong và idVeSi
    @Query("SELECT new com.webservice.hethongchothuevesi.dto.dto.NhiemVuDTO("
            + "n.idNhiemVu, n.idHopDong, n.idVeSi, n.ngayBatDau, n.ngayKetThuc, n.capBac, "
            + "n.noiDung, n.danhGiaKyNangChuyenMon, n.danhGiaXuLyTinhHuong, n.danhGiaThaiDoDaoDuc, "
            + "n.danhGiaGiaoTiep, n.danhGiaNgoaiHinh, n.thongTinDanhGia, n.trangThai, n.ngayXoa) "
            + "FROM NhiemVu n WHERE n.idHopDong = :idHopDong AND n.idVeSi = :idVeSi AND n.ngayXoa IS NULL")
    Optional<NhiemVuDTO> findByIdHopDongAndIdVeSiAndNgayXoaIsNull(
            @Param("idHopDong") Integer idHopDong, @Param("idVeSi") Integer idVeSi);
}
