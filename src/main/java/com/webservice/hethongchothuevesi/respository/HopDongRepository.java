package com.webservice.hethongchothuevesi.respository;

import com.webservice.hethongchothuevesi.entity.HopDong;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HopDongRepository extends JpaRepository<HopDong, Integer> {}
