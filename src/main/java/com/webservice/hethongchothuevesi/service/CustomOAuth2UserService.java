package com.webservice.hethongchothuevesi.service;

import com.webservice.hethongchothuevesi.entity.NguoiDung;
import com.webservice.hethongchothuevesi.entity.NguoiDungVaiTro;
import com.webservice.hethongchothuevesi.exception.AppException;
import com.webservice.hethongchothuevesi.exception.ErrorCode;
import com.webservice.hethongchothuevesi.respository.NguoiDungRepository;
import com.webservice.hethongchothuevesi.respository.NguoiDungVaiTroRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserService;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class CustomOAuth2UserService implements OAuth2UserService<OAuth2UserRequest, OAuth2User> {

    NguoiDungRepository nguoiDungRepository;
    NguoiDungVaiTroRepository nguoiDungVaiTroRepository;

    @Override
    public OAuth2User loadUser(OAuth2UserRequest userRequest) {
        OAuth2UserService<OAuth2UserRequest, OAuth2User> delegate = new org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService();
        OAuth2User oAuth2User = delegate.loadUser(userRequest);

        String email = oAuth2User.getAttribute("email");
        String name = oAuth2User.getAttribute("name");

        if (email == null || email.isEmpty()) {
            throw new AppException(ErrorCode.INVALID_GOOGLE_TOKEN);
        }

        Optional<NguoiDung> nguoiDungOptional = nguoiDungRepository.findByEmail(email);
        NguoiDung nguoiDung;

        if (nguoiDungOptional.isPresent()) {
            nguoiDung = nguoiDungOptional.get();
        } else {
            // Tạo người dùng mới nếu chưa tồn tại
            nguoiDung = new NguoiDung();
            nguoiDung.setTenDangNhap(email);
            nguoiDung.setEmail(email);
            nguoiDung.setHoTen(name != null ? name : ""); // Đảm bảo không null
            nguoiDung.setMatKhau(""); // Không cần mật khẩu khi đăng nhập qua OAuth
            nguoiDung.setTrangThai("Hoạt động");
            nguoiDungRepository.save(nguoiDung); // Lưu người dùng trước để có ID

            // Đặt vai trò là Khách hàng
            NguoiDungVaiTro nguoiDungVaiTro = NguoiDungVaiTro.builder()
                    .idNguoiDung(nguoiDung.getIdNguoiDung())
                    .idVaiTro(1) // 1 là ID của vai trò "Khách hàng" trong bảng VaiTro
                    .build();
            nguoiDungVaiTroRepository.save(nguoiDungVaiTro);
        }

        return oAuth2User;
    }
}