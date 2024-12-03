package com.webservice.hethongchothuevesi.configuration;

import com.webservice.hethongchothuevesi.entity.NguoiDung;
import com.webservice.hethongchothuevesi.entity.NguoiDungVaiTro;
import com.webservice.hethongchothuevesi.respository.NguoiDungRepository;
import com.webservice.hethongchothuevesi.respository.NguoiDungVaiTroRepository;
import com.webservice.hethongchothuevesi.respository.VaiTroRepository;
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
    NguoiDungRepository nguoiDungRepository;
    VaiTroRepository vaiTroRepository;
    NguoiDungVaiTroRepository nguoiDungVaiTroRepository;  // Inject repository NguoiDungVaiTro

    @Bean
    ApplicationRunner applicationRunner() {
        return args -> {
            // Kiểm tra nếu tài khoản admin đã tồn tại
            if (nguoiDungRepository.findByTenDangNhap("admin1234").isEmpty()) {
                // Tạo tài khoản admin
                NguoiDung nguoiDung = NguoiDung.builder()
                        .tenDangNhap("admin1234")
                        .matKhau(passwordEncoder.encode("admin1234"))
                        .build();

                // Lưu tài khoản người dùng admin
                nguoiDungRepository.save(nguoiDung);

                // Tạo các bản ghi trong bảng NguoiDungVaiTro
                NguoiDungVaiTro nguoiDungVaiTroKhachHang = NguoiDungVaiTro.builder()
                        .idNguoiDung(nguoiDung.getIdNguoiDung())
                        .idVaiTro(1)
                        .build();

                NguoiDungVaiTro nguoiDungVaiTroAdmin = NguoiDungVaiTro.builder()
                        .idNguoiDung(nguoiDung.getIdNguoiDung())
                        .idVaiTro(4)
                        .build();

                // Lưu các vai trò vào bảng NguoiDungVaiTro
                nguoiDungVaiTroRepository.save(nguoiDungVaiTroKhachHang);
                nguoiDungVaiTroRepository.save(nguoiDungVaiTroAdmin);

                log.warn("Đã tạo tài khoản admin với tài khoản và mật khẩu là: admin1234");
            }
        };
    }

}
