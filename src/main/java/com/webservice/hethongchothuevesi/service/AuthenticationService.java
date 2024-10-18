package com.webservice.hethongchothuevesi.service;

import com.webservice.hethongchothuevesi.dto.request.AuthenticationRequest;
import com.webservice.hethongchothuevesi.dto.response.KhachHangResponse;
import com.webservice.hethongchothuevesi.entity.KhachHang;
import com.webservice.hethongchothuevesi.exception.AppException;
import com.webservice.hethongchothuevesi.exception.ErrorCode;
import com.webservice.hethongchothuevesi.respository.KhachHangRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class AuthenticationService {
    KhachHangRepository khachHangRepository;

    public boolean checkKhachHang(AuthenticationRequest request) {
        var khachHang = khachHangRepository.findByTenDangNhap(request.getTenDangNhap()).orElseThrow(()-> new AppException(ErrorCode.KHACHHANG_NOTEXISTED));

        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder(7);
        return passwordEncoder.matches(request.getMatKhau(), khachHang.getMatKhau());
    }

}
