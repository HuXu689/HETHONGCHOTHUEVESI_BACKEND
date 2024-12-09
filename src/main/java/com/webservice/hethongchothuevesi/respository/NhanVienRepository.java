package com.webservice.hethongchothuevesi.respository;

import java.util.List;
import java.util.Optional;

import com.webservice.hethongchothuevesi.entity.NhanVien;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NhanVienRepository extends JpaRepository<NhanVien, Integer> {

	List<NhanVien> findByNgayXoaIsNull();

	Optional<NhanVien> findByIdNhanVien(int idNguoiDung);

	Optional<NhanVien> findByIdNhanVienAndNgayXoaIsNull(int idNguoiDung);

	long countByNgayXoaIsNull();

	Page<NhanVien> findByNgayXoaIsNull(Pageable pageable);
}
