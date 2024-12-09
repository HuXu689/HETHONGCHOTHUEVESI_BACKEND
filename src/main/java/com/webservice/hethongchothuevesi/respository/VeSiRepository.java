package com.webservice.hethongchothuevesi.respository;

import com.webservice.hethongchothuevesi.entity.VeSi;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VeSiRepository extends JpaRepository<VeSi, Integer> {}
