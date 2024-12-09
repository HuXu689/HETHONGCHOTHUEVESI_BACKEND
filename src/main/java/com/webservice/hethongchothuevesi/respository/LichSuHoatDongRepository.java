package com.webservice.hethongchothuevesi.respository;

import com.webservice.hethongchothuevesi.entity.LichSuHoatDong;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LichSuHoatDongRepository extends JpaRepository<LichSuHoatDong, Integer> {}
