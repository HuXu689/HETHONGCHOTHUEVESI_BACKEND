package com.webservice.hethongchothuevesi.respository;

import java.util.List;
import java.util.Optional;

import com.webservice.hethongchothuevesi.entity.HopDong;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HopDongRepository extends JpaRepository<HopDong, Integer> {
	List<HopDong> findByNgayXoaIsNull();

	Optional<HopDong> findByIdHopDong(int idHopDong);

	Optional<HopDong> findByIdHopDongAndNgayXoaIsNull(int idHopDong);

	long countByNgayXoaIsNull();

	Page<HopDong> findByNgayXoaIsNull(Pageable pageable);
}
