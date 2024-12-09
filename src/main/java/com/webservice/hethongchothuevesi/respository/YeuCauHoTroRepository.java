package com.webservice.hethongchothuevesi.respository;

import com.webservice.hethongchothuevesi.entity.YeuCauHoTro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface YeuCauHoTroRepository extends JpaRepository<YeuCauHoTro, Integer> {}
