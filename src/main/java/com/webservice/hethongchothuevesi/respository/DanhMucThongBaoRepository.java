package com.webservice.hethongchothuevesi.respository;

import com.webservice.hethongchothuevesi.entity.DanhMucThongBao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DanhMucThongBaoRepository extends JpaRepository<DanhMucThongBao, Integer> {}
