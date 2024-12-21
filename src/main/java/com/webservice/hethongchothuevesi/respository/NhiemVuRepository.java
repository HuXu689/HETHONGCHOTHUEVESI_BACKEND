package com.webservice.hethongchothuevesi.respository;

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

    // Lấy tất cả nhiệm vụ theo idVeSi chưa bị xóa mềm
    @Query("SELECT n FROM NhiemVu n WHERE n.idVeSi = :idVeSi AND n.ngayXoa IS NULL")
    List<NhiemVu> findAllByIdVeSiAndNgayXoaIsNull(@Param("idVeSi") Integer idVeSi);

    // Lấy tất cả nhiệm vụ theo idVeSi và trạng thái chưa bị xóa mềm
    @Query("SELECT n FROM NhiemVu n WHERE n.idVeSi = :idVeSi AND n.trangThai = :trangThai AND n.ngayXoa IS NULL")
    List<NhiemVu> findAllByIdVeSiAndTrangThaiAndNgayXoaIsNull(@Param("idVeSi") Integer idVeSi, @Param("trangThai") String trangThai);

    // Lấy tất cả nhiệm vụ theo trạng thái chưa bị xóa mềm
    @Query("SELECT n FROM NhiemVu n WHERE n.trangThai = :trangThai AND n.ngayXoa IS NULL")
    List<NhiemVu> findAllByTrangThaiAndNgayXoaIsNull(@Param("trangThai") String trangThai);

    // Lấy tất cả nhiệm vụ theo idVeSi (bao gồm đã xóa mềm)
    @Query("SELECT n FROM NhiemVu n WHERE n.idVeSi = :idVeSi")
    List<NhiemVu> findAllByIdVeSi(@Param("idVeSi") Integer idVeSi);

    // Lấy tất cả nhiệm vụ theo idVeSi và trạng thái (bao gồm đã xóa mềm)
    @Query("SELECT n FROM NhiemVu n WHERE n.idVeSi = :idVeSi AND n.trangThai = :trangThai")
    List<NhiemVu> findAllByIdVeSiAndTrangThai(@Param("idVeSi") Integer idVeSi, @Param("trangThai") String trangThai);

    // Lấy tất cả nhiệm vụ theo trạng thái (bao gồm đã xóa mềm)
    @Query("SELECT n FROM NhiemVu n WHERE n.trangThai = :trangThai")
    List<NhiemVu> findAllByTrangThai(@Param("trangThai") String trangThai);
}
