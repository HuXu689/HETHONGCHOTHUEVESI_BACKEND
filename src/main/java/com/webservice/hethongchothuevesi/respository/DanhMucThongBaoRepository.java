package com.webservice.hethongchothuevesi.respository;

import java.util.List;
import java.util.Optional;

import com.webservice.hethongchothuevesi.entity.DanhMucThongBao;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DanhMucThongBaoRepository extends JpaRepository<DanhMucThongBao, Integer> {
	List<DanhMucThongBao> findByNgayXoaIsNull();

	Optional<DanhMucThongBao> findByIdDanhMucThongBao(int idDanhMucThongBao);

	Optional<DanhMucThongBao> findByIdDanhMucThongBaoAndNgayXoaIsNull(int idDanhMucThongBao);

	long countByNgayXoaIsNull();

	Page<DanhMucThongBao> findByNgayXoaIsNull(Pageable pageable);
}
