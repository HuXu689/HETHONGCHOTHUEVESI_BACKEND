package com.webservice.hethongchothuevesi.respository;

import java.util.List;
import java.util.Optional;

import com.webservice.hethongchothuevesi.entity.VeSi;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VeSiRepository extends JpaRepository<VeSi, Integer> {
	List<VeSi> findByNgayXoaIsNull();

	Optional<VeSi> findByIdVeSi(int idVeSi);

	Optional<VeSi> findByIdVeSiAndNgayXoaIsNull(int idVeSi);

	long countByNgayXoaIsNull();

	Page<VeSi> findByNgayXoaIsNull(Pageable pageable);
}
