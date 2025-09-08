package com.webservice.hethongchothuevesi.repository;

import java.util.Optional;

import com.webservice.hethongchothuevesi.entity.TepHopDong;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TepHopDongRepository extends JpaRepository<TepHopDong, Integer> {
    Optional<TepHopDong> findByIdTepHopDong(int idTepHopDong);
}
