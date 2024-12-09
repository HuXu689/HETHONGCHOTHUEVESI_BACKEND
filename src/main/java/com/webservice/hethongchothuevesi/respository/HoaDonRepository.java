package com.webservice.hethongchothuevesi.respository;

import com.webservice.hethongchothuevesi.entity.HoaDon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HoaDonRepository extends JpaRepository<HoaDon, Integer> {}
