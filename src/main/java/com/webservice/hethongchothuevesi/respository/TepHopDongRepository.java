package com.webservice.hethongchothuevesi.respository;

import com.webservice.hethongchothuevesi.entity.TepHopDong;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TepHopDongRepository extends JpaRepository<TepHopDong, Integer> {}
