package com.webservice.hethongchothuevesi.respository;

import com.webservice.hethongchothuevesi.entity.VaiTro;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface VaiTroRepository extends JpaRepository<VaiTro, Integer> {
    Optional<VaiTro> findByIdVaiTro(int idVaiTro);
}

