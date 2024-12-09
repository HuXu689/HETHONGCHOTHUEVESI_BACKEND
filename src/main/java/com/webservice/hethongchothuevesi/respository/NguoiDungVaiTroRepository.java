package com.webservice.hethongchothuevesi.respository;

import java.util.List;

import com.webservice.hethongchothuevesi.entity.NguoiDungVaiTro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NguoiDungVaiTroRepository extends JpaRepository<NguoiDungVaiTro, Integer> {
	List<NguoiDungVaiTro> findByIdNguoiDung(int idNguoiDung);

	List<NguoiDungVaiTro> findByIdVaiTro(int idVaiTro);
}
