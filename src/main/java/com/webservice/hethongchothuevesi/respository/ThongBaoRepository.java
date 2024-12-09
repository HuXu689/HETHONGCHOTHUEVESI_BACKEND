package com.webservice.hethongchothuevesi.respository;

import java.util.List;
import java.util.Optional;

import com.webservice.hethongchothuevesi.entity.ThongBao;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ThongBaoRepository extends JpaRepository<ThongBao, Integer> {
	List<ThongBao> findByNgayXoaIsNull();

	Optional<ThongBao> findByIdThongBao(int idThongBao);

	Optional<ThongBao> findByIdThongBaoAndNgayXoaIsNull(int idThongBao);

	long countByNgayXoaIsNull();

	Page<ThongBao> findByNgayXoaIsNull(Pageable pageable);
}
