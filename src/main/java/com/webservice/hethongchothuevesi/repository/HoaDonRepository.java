package com.webservice.hethongchothuevesi.repository;

import java.util.List;
import java.util.Optional;

import com.webservice.hethongchothuevesi.entity.HoaDon;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HoaDonRepository extends JpaRepository<HoaDon, Integer> {
    List<HoaDon> findByNgayXoaIsNull();

    Optional<HoaDon> findByIdHoaDon(int idHoaDon);

    Optional<HoaDon> findByIdHoaDonAndNgayXoaIsNull(int idHoaDon);

    long countByNgayXoaIsNull();

    Page<HoaDon> findByNgayXoaIsNull(Pageable pageable);
}
