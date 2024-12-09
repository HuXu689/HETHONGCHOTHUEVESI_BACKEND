package com.webservice.hethongchothuevesi.respository;

import com.webservice.hethongchothuevesi.entity.HoSo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HoSoRepository extends JpaRepository<HoSo, Integer> {}
