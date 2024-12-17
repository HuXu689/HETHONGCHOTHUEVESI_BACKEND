package com.webservice.hethongchothuevesi.respository;

import com.webservice.hethongchothuevesi.entity.OTP;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface OTPRepository extends JpaRepository<OTP, Long> {

    // Tìm OTP mới nhất theo email
    Optional<OTP> findTopByEmailOrderByCreatedAtDesc(String email);
}
