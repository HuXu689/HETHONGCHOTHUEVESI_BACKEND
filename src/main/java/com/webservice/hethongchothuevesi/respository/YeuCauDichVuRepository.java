package com.webservice.hethongchothuevesi.respository;

import com.webservice.hethongchothuevesi.dto.dto.YeuCauDichVuDTO;
import com.webservice.hethongchothuevesi.entity.YeuCauDichVu;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface YeuCauDichVuRepository extends JpaRepository<YeuCauDichVu, Integer> {
    List<YeuCauDichVu> findByNgayXoaIsNull();

    List<YeuCauDichVu> findByIdNguoiDungAndNgayXoaIsNull(int idNguoiDung);

    Optional<YeuCauDichVu> findByIdYeuCauDichVu(int idYeuCauDichVu);

    Optional<YeuCauDichVu> findByIdYeuCauDichVuAndNgayXoaIsNull(int idYeuCauDichVu);

    long countByNgayXoaIsNull();

    Page<YeuCauDichVu> findByNgayXoaIsNull(Pageable pageable);

    @Query("SELECT new com.webservice.hethongchothuevesi.dto.dto.YeuCauDichVuDTO(" +
            "y.idYeuCauDichVu, y.idNguoiDung, y.idDanhMucDichVu, d.tenDichVu, y.hoTenKhachHang, y.soDienThoai, " +
            "y.anh, y.soCccd, y.diaDiem, y.soLuongVeSi, y.ngayBatDau, y.ngayKetThuc, y.giaTienDuKien, " +
            "y.ghiChu, y.noiDungTraLoi, y.trangThai, y.ngayXoa) " +
            "FROM YeuCauDichVu y " +
            "JOIN DanhMucDichVu d ON y.idDanhMucDichVu = d.idDanhMucDichVu " +
            "WHERE y.idYeuCauDichVu = :id AND y.ngayXoa IS NULL")
    YeuCauDichVuDTO findYeuCauDichVuWithCategoryName(@Param("id") Integer id);
}
