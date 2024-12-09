package com.webservice.hethongchothuevesi.respository;

import com.webservice.hethongchothuevesi.entity.DanhMucKhoaDaoTao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DanhMucKhoaDaoTaoRepository extends JpaRepository<DanhMucKhoaDaoTao, Integer> {}
