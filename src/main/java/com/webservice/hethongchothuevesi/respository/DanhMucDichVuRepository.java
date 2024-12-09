package com.webservice.hethongchothuevesi.respository;

import com.webservice.hethongchothuevesi.entity.DanhMucDichVu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DanhMucDichVuRepository extends JpaRepository<DanhMucDichVu, Integer> {}
