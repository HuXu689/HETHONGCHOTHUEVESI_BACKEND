package com.webservice.hethongchothuevesi.repository;

import java.util.List;
import java.util.Optional;

import com.webservice.hethongchothuevesi.entity.BaoCaoKhanNhiemVu;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BaoCaoKhanNhiemVuRepository extends JpaRepository<BaoCaoKhanNhiemVu, Integer> {
    List<BaoCaoKhanNhiemVu> findByNgayXoaIsNull();

    Optional<BaoCaoKhanNhiemVu> findByIdBaoCaoKhan(int idBaoCaoKhan);

    Optional<BaoCaoKhanNhiemVu> findByIdBaoCaoKhanAndNgayXoaIsNull(int idBaoCaoKhan);

    long countByNgayXoaIsNull();

    Page<BaoCaoKhanNhiemVu> findByNgayXoaIsNull(Pageable pageable);
}
