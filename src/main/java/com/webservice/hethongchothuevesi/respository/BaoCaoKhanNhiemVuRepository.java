package com.webservice.hethongchothuevesi.respository;

import com.webservice.hethongchothuevesi.entity.BaoCaoKhanNhiemVu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BaoCaoKhanNhiemVuRepository extends JpaRepository<BaoCaoKhanNhiemVu, Integer> {}
