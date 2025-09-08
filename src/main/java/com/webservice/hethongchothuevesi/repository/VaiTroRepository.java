package com.webservice.hethongchothuevesi.repository;

import java.util.Optional;

import com.webservice.hethongchothuevesi.entity.VaiTro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VaiTroRepository extends JpaRepository<VaiTro, Integer> {
    Optional<VaiTro> findByIdVaiTro(int idVaiTro);
}
