package com.webservice.hethongchothuevesi.respository;

import com.webservice.hethongchothuevesi.entity.NhiemVu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NhiemVuRepository extends JpaRepository<NhiemVu, Integer> {}
