package com.webservice.hethongchothuevesi.respository;

import com.webservice.hethongchothuevesi.entity.DanhMucKyNang;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DanhMucKyNangRepository extends JpaRepository<DanhMucKyNang, Integer> {}
