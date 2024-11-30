package com.webservice.hethongchothuevesi.configuration;

import com.webservice.hethongchothuevesi.entity.NguoiDung;
import com.webservice.hethongchothuevesi.enums.Role;
import com.webservice.hethongchothuevesi.respository.NguoiDungRepository;
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
    ApplicationRunner applicationRunner(NguoiDungRepository nguoiDungRepository) {
        return args -> {
            if (nguoiDungRepository.findByTenDangNhap("admin1234").isEmpty()) {
                var role = Role.ADMIN.name();
                NguoiDung nguoiDung = NguoiDung.builder()
                        .tenDangNhap("admin1234")
                        .matKhau(passwordEncoder.encode("admin1234"))
                        .role(role)
                        .build();
                nguoiDungRepository.save(nguoiDung);
                log.warn("Đã tạo tài khoản admin với tài khoản và mật khẩu là: admin1234");
            }
        };
    }
}
