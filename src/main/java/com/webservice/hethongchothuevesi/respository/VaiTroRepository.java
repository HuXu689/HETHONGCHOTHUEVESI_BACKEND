package com.webservice.hethongchothuevesi.respository;

import java.util.Optional;

import com.webservice.hethongchothuevesi.entity.VaiTro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VaiTroRepository extends JpaRepository<VaiTro, Integer> {
	Optional<VaiTro> findByIdVaiTro(int idVaiTro);
}
