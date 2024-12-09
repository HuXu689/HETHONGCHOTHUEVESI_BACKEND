package com.webservice.hethongchothuevesi.respository;

import java.util.List;
import java.util.Optional;

import com.webservice.hethongchothuevesi.entity.ThongBaoNguoiDung;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ThongBaoNguoiDungRepository extends JpaRepository<ThongBaoNguoiDung, Integer> {
	List<ThongBaoNguoiDung> findByNgayXoaIsNull();

	Optional<ThongBaoNguoiDung> findByIdThongBaoNguoiDung(int idThongBaoNguoiDung);

	Optional<ThongBaoNguoiDung> findByIdThongBaoNguoiDungAndNgayXoaIsNull(int idThongBaoNguoiDung);

	long countByNgayXoaIsNull();

	Page<ThongBaoNguoiDung> findByNgayXoaIsNull(Pageable pageable);
}
