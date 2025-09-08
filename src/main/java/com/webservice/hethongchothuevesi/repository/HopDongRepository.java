package com.webservice.hethongchothuevesi.repository;

import com.webservice.hethongchothuevesi.dto.dto.HopDongDTO;
import com.webservice.hethongchothuevesi.entity.HopDong;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface HopDongRepository extends JpaRepository<HopDong, Integer> {
    List<HopDong> findByNgayXoaIsNull();

    Optional<HopDong> findByIdHopDong(int idHopDong);

    Optional<HopDong> findByIdHopDongAndNgayXoaIsNull(int idHopDong);

    @Query("SELECT new com.webservice.hethongchothuevesi.dto.dto.HopDongDTO("
            + "h.idHopDong, h.idYeuCauDichVu, d.tenDichVu, h.hoTenKhachHang, h.soDienThoai, h.idAnh, h.anh, h.soCccd, "
            + "h.diaDiem, h.soLuongVeSi, h.thoiGianBatDau, h.thoiGianKetThuc, h.tongChiPhi, h.ghiChu, "
            + "h.soSaoDanhGia, h.thongTinDanhGia, h.trangThai, h.ngayXoa) "
            + "FROM HopDong h "
            + "JOIN YeuCauDichVu y ON h.idYeuCauDichVu = y.idYeuCauDichVu "
            + "JOIN DanhMucDichVu d ON y.idDanhMucDichVu = d.idDanhMucDichVu "
            + "WHERE h.idHopDong = :idHopDong AND h.ngayXoa IS NULL")
    HopDongDTO findHopDongWithTenDichVuByIdHopDongAndNgayXoaIsNull(@Param("idHopDong") int idHopDong);

    long countByNgayXoaIsNull();

    Page<HopDong> findByNgayXoaIsNull(Pageable pageable);

    @Query("SELECT new com.webservice.hethongchothuevesi.dto.dto.HopDongDTO("
            + "h.idHopDong, h.idYeuCauDichVu, d.tenDichVu, h.hoTenKhachHang, h.soDienThoai, h.idAnh, h.anh, h.soCccd, "
            + "h.diaDiem, h.soLuongVeSi, h.thoiGianBatDau, h.thoiGianKetThuc, h.tongChiPhi, h.ghiChu, "
            + "h.soSaoDanhGia, h.thongTinDanhGia, h.trangThai, h.ngayXoa) "
            + "FROM HopDong h "
            + "JOIN YeuCauDichVu y ON h.idYeuCauDichVu = y.idYeuCauDichVu "
            + "JOIN DanhMucDichVu d ON y.idDanhMucDichVu = d.idDanhMucDichVu "
            + "WHERE y.idNguoiDung = :idNguoiDung "
            + "AND h.ngayXoa IS NULL "
            + "AND y.ngayXoa IS NULL")
    List<HopDongDTO> findAllHopDongWithTenDichVuByIdNguoiDungAndNgayXoaIsNull(
            @Param("idNguoiDung") Integer idNguoiDung);

    @Query("SELECT new com.webservice.hethongchothuevesi.dto.dto.HopDongDTO("
            + "h.idHopDong, h.idYeuCauDichVu, d.tenDichVu, h.hoTenKhachHang, h.soDienThoai, h.idAnh, h.anh, h.soCccd, "
            + "h.diaDiem, h.soLuongVeSi, h.thoiGianBatDau, h.thoiGianKetThuc, h.tongChiPhi, h.ghiChu, "
            + "h.soSaoDanhGia, h.thongTinDanhGia, h.trangThai, h.ngayXoa) "
            + "FROM HopDong h "
            + "JOIN YeuCauDichVu y ON h.idYeuCauDichVu = y.idYeuCauDichVu "
            + "JOIN DanhMucDichVu d ON y.idDanhMucDichVu = d.idDanhMucDichVu "
            + "WHERE h.ngayXoa IS NULL")
    List<HopDongDTO> findAllHopDongWithTenDichVuAndNgayXoaIsNull();
}
