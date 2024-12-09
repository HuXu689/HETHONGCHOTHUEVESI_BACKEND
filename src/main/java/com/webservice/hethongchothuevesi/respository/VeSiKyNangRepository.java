package com.webservice.hethongchothuevesi.respository;

import com.webservice.hethongchothuevesi.entity.VeSiKyNang;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VeSiKyNangRepository extends JpaRepository<VeSiKyNang, Integer> {}
