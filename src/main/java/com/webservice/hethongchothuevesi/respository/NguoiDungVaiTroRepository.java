package com.webservice.hethongchothuevesi.respository;

import com.webservice.hethongchothuevesi.entity.NguoiDungVaiTro;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface NguoiDungVaiTroRepository extends JpaRepository<NguoiDungVaiTro, Integer> {
    List<NguoiDungVaiTro> findByIdNguoiDung(int idNguoiDung);

    List<NguoiDungVaiTro> findByIdVaiTro(int idVaiTro);
}


