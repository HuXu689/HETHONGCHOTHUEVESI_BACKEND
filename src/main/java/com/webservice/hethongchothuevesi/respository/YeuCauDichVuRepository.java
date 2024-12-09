package com.webservice.hethongchothuevesi.respository;

import com.webservice.hethongchothuevesi.entity.YeuCauDichVu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface YeuCauDichVuRepository extends JpaRepository<YeuCauDichVu, Integer> {}
