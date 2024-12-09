package com.webservice.hethongchothuevesi.respository;

import java.util.List;
import java.util.Optional;

import com.webservice.hethongchothuevesi.entity.NhiemVu;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NhiemVuRepository extends JpaRepository<NhiemVu, Integer> {
	List<NhiemVu> findByNgayXoaIsNull();

	Optional<NhiemVu> findByIdNhiemVu(int idNhiemVu);

	Optional<NhiemVu> findByIdNhiemVuAndNgayXoaIsNull(int idNhiemVu);

	long countByNgayXoaIsNull();

	Page<NhiemVu> findByNgayXoaIsNull(Pageable pageable);
}
