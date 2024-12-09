package com.webservice.hethongchothuevesi.respository;

import com.webservice.hethongchothuevesi.entity.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ThongBaoRepository extends JpaRepository<ThongBao, Integer> {}
