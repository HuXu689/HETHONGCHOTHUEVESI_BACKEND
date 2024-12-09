package com.webservice.hethongchothuevesi.respository;

import java.util.List;
import java.util.Optional;

import com.webservice.hethongchothuevesi.entity.VeSiKyNang;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VeSiKyNangRepository extends JpaRepository<VeSiKyNang, Integer> {
	List<VeSiKyNang> findByNgayXoaIsNull();

	Optional<VeSiKyNang> findByIdVeSiKyNang(int idVeSiKyNang);

	Optional<VeSiKyNang> findByIdVeSiKyNangAndNgayXoaIsNull(int idVeSiKyNang);

	long countByNgayXoaIsNull();

	Page<VeSiKyNang> findByNgayXoaIsNull(Pageable pageable);
}
