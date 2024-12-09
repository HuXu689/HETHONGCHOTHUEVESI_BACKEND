package com.webservice.hethongchothuevesi.respository;

import java.util.List;
import java.util.Optional;

import com.webservice.hethongchothuevesi.entity.YeuCauHoTro;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface YeuCauHoTroRepository extends JpaRepository<YeuCauHoTro, Integer> {
	List<YeuCauHoTro> findByNgayXoaIsNull();

	Optional<YeuCauHoTro> findByIdYeuCauHoTro(int idYeuCauHoTro);

	Optional<YeuCauHoTro> findByIdYeuCauHoTroAndNgayXoaIsNull(int idYeuCauHoTro);

	long countByNgayXoaIsNull();

	Page<YeuCauHoTro> findByNgayXoaIsNull(Pageable pageable);
}
