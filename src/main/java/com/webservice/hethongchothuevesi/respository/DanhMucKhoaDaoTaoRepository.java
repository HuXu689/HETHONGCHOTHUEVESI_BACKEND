package com.webservice.hethongchothuevesi.respository;

import java.util.List;
import java.util.Optional;

import com.webservice.hethongchothuevesi.entity.DanhMucKhoaDaoTao;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DanhMucKhoaDaoTaoRepository extends JpaRepository<DanhMucKhoaDaoTao, Integer> {
	List<DanhMucKhoaDaoTao> findByNgayXoaIsNull();

	Optional<DanhMucKhoaDaoTao> findByIdDanhMucKhoaDaoTao(int idDanhMucKhoaDaoTao);

	Optional<DanhMucKhoaDaoTao> findByIdDanhMucKhoaDaoTaoAndNgayXoaIsNull(int idDanhMucKhoaDaoTao);

	long countByNgayXoaIsNull();

	Page<DanhMucKhoaDaoTao> findByNgayXoaIsNull(Pageable pageable);
}
