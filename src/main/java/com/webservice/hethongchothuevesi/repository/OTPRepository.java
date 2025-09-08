package com.webservice.hethongchothuevesi.repository;

import java.util.Optional;

import com.webservice.hethongchothuevesi.entity.OTP;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OTPRepository extends JpaRepository<OTP, Long> {

    // Tìm OTP mới nhất theo email
    Optional<OTP> findTopByEmailOrderByCreatedAtDesc(String email);
}
