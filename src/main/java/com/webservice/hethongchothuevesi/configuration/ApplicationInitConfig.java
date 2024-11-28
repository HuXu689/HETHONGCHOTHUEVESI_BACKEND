package com.webservice.hethongchothuevesi.configuration;

import com.webservice.hethongchothuevesi.entity.KhachHang;
import com.webservice.hethongchothuevesi.enums.Role;
import com.webservice.hethongchothuevesi.respository.KhachHangRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Slf4j
public class ApplicationInitConfig {
    PasswordEncoder passwordEncoder;

    @Bean
    ApplicationRunner applicationRunner(KhachHangRepository khachHangRepository) {
        return args -> {
            if (khachHangRepository.findByTenDangNhap("admin1234").isEmpty()) {
                var role = Role.ADMIN.name();
                KhachHang khachHang = KhachHang.builder()
                        .tenDangNhap("admin1234")
                        .matKhau(passwordEncoder.encode("admin1234"))
                        .role(role)
                        .build();
                khachHangRepository.save(khachHang);
                log.warn("Đã tạo tài khoản admin với tài khoản và mật khẩu là: admin1234");
            }
        };
    }
}
