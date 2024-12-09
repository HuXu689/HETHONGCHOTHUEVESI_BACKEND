package com.webservice.hethongchothuevesi.respository;

import com.webservice.hethongchothuevesi.entity.VeSiKhoaDaoTao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VeSiKhoaDaoTaoRepository extends JpaRepository<VeSiKhoaDaoTao, Integer> {}
