package com.webservice.hethongchothuevesi.respository;

import java.util.List;
import java.util.Optional;

import com.webservice.hethongchothuevesi.entity.DanhMucDichVu;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DanhMucDichVuRepository extends JpaRepository<DanhMucDichVu, Integer> {
	List<DanhMucDichVu> findByNgayXoaIsNull();

	Optional<DanhMucDichVu> findByIdDanhMucDichVu(int idDanhMucDichVu);

	Optional<DanhMucDichVu> findByIdDanhMucDichVuAndNgayXoaIsNull(int idDanhMucDichVu);

	long countByNgayXoaIsNull();

	Page<DanhMucDichVu> findByNgayXoaIsNull(Pageable pageable);
}
