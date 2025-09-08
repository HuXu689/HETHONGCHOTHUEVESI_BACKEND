package com.webservice.hethongchothuevesi.repository;

import java.util.List;
import java.util.Optional;

import com.webservice.hethongchothuevesi.entity.KhoaDaoTao;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KhoaDaoTaoRepository extends JpaRepository<KhoaDaoTao, Integer> {
    List<KhoaDaoTao> findByNgayXoaIsNull();

    Optional<KhoaDaoTao> findByIdKhoaDaoTao(int idKhoaDaoTao);

    Optional<KhoaDaoTao> findByIdKhoaDaoTaoAndNgayXoaIsNull(int idKhoaDaoTao);

    long countByNgayXoaIsNull();

    Page<KhoaDaoTao> findByNgayXoaIsNull(Pageable pageable);
}
