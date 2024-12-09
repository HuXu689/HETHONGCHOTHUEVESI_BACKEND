package com.webservice.hethongchothuevesi.respository;

import java.util.List;
import java.util.Optional;

import com.webservice.hethongchothuevesi.entity.DanhMucKyNang;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DanhMucKyNangRepository extends JpaRepository<DanhMucKyNang, Integer> {
	List<DanhMucKyNang> findByNgayXoaIsNull();

	Optional<DanhMucKyNang> findByIdDanhMucKyNang(int idDanhMucKyNang);

	Optional<DanhMucKyNang> findByIdDanhMucKyNangAndNgayXoaIsNull(int idDanhMucKyNang);

	long countByNgayXoaIsNull();

	Page<DanhMucKyNang> findByNgayXoaIsNull(Pageable pageable);
}
