package com.webservice.hethongchothuevesi.respository;

import java.util.List;
import java.util.Optional;

import com.webservice.hethongchothuevesi.entity.YeuCauDichVu;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface YeuCauDichVuRepository extends JpaRepository<YeuCauDichVu, Integer> {
	List<YeuCauDichVu> findByNgayXoaIsNull();

	Optional<YeuCauDichVu> findByIdYeuCauDichVu(int idYeuCauDichVu);

	Optional<YeuCauDichVu> findByIdYeuCauDichVuAndNgayXoaIsNull(int idYeuCauDichVu);

	long countByNgayXoaIsNull();

	Page<YeuCauDichVu> findByNgayXoaIsNull(Pageable pageable);
}
