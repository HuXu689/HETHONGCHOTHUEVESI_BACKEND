package com.webservice.hethongchothuevesi.respository;

import java.util.List;
import java.util.Optional;

import com.webservice.hethongchothuevesi.entity.HopDong;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface HopDongRepository extends JpaRepository<HopDong, Integer> {
	List<HopDong> findByNgayXoaIsNull();

	Optional<HopDong> findByIdHopDong(int idHopDong);

	Optional<HopDong> findByIdHopDongAndNgayXoaIsNull(int idHopDong);

	long countByNgayXoaIsNull();

	Page<HopDong> findByNgayXoaIsNull(Pageable pageable);

	@Query(
			value = "SELECT h.* " + "FROM HopDong h "
					+ "JOIN YeuCauDichVu y ON h.idYeuCauDichVu = y.idYeuCauDichVu "
					+ "WHERE y.idNguoiDung = :idNguoiDung "
					+ "AND h.ngayXoa IS NULL "
					+ "AND y.ngayXoa IS NULL",
			nativeQuery = true)
	List<HopDong> findAllHopDongByIdNguoiDungAndNgayXoaIsNull(@Param("idNguoiDung") Integer idNguoiDung);
}
