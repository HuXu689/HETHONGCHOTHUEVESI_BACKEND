package com.webservice.hethongchothuevesi.respository;

import java.util.List;
import java.util.Optional;

import com.webservice.hethongchothuevesi.entity.HoSo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HoSoRepository extends JpaRepository<HoSo, Integer> {
	List<HoSo> findByNgayXoaIsNull();

	Optional<HoSo> findByIdHoSo(int idHoSo);

	Optional<HoSo> findByIdHoSoAndNgayXoaIsNull(int idHoSo);

	long countByNgayXoaIsNull();

	Page<HoSo> findByNgayXoaIsNull(Pageable pageable);
}
