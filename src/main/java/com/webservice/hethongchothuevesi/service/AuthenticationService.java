package com.webservice.hethongchothuevesi.service;

import com.nimbusds.jose.*;
import com.nimbusds.jose.crypto.MACSigner;
import com.nimbusds.jose.crypto.MACVerifier;
import com.nimbusds.jwt.JWTClaimsSet;
import com.nimbusds.jwt.SignedJWT;
import com.webservice.hethongchothuevesi.dto.request.AuthenticationRequest;
import com.webservice.hethongchothuevesi.dto.request.IntrospectRequest;
import com.webservice.hethongchothuevesi.dto.response.AuthenticationResponse;
import com.webservice.hethongchothuevesi.dto.response.IntrospectResponse;
import com.webservice.hethongchothuevesi.exception.AppException;
import com.webservice.hethongchothuevesi.exception.ErrorCode;
import com.webservice.hethongchothuevesi.respository.KhachHangRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.experimental.NonFinal;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Date;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class AuthenticationService {
    KhachHangRepository khachHangRepository;

    private static final Logger log = LoggerFactory.getLogger(AuthenticationService.class);

    //Key random trên generate-random.org/encryption-key-generator
    @NonFinal
    @Value("${jwt.signerKey}")
    protected String SIGNER_KEY;

    public String encryption(String password) {
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder(7);
        return passwordEncoder.encode(password);
    }

    public boolean checkKhachHangId(int id, String password) {
        var khachHang = khachHangRepository.findById(id).orElseThrow(()-> new AppException(ErrorCode.KHACHHANG_NOT_EXISTED));

        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder(7);

        return passwordEncoder.matches(password, khachHang.getMatKhau());
    }

    public AuthenticationResponse checkKhachHang(AuthenticationRequest request) {
        var khachHang = khachHangRepository.findByTenDangNhap(request.getTenDangNhap()).orElseThrow(()-> new AppException(ErrorCode.KHACHHANG_NOT_EXISTED));

        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder(7);

        boolean authenticated = passwordEncoder.matches(request.getMatKhau(), khachHang.getMatKhau());

        if (!authenticated)
            throw new AppException(ErrorCode.UN_AUTHENTICATED);

        var token = generateToken(request.getTenDangNhap());

        return AuthenticationResponse.builder()
                .token(token)
                .authenticated(true)
                .build();
    }

    //Tạo token đăng nhập, truy cập jwt.io để xem nội dung token
    private String generateToken(String username) {
        JWSHeader header = new JWSHeader(JWSAlgorithm.HS512);

        JWTClaimsSet jwtClaimsSet = new JWTClaimsSet.Builder()
                .subject(username)
                .issuer("hethongchothuevesi.com")
                .issueTime(new Date())
                .expirationTime(new Date(
                        Instant.now().plus(1, ChronoUnit.HOURS).toEpochMilli()
                ))
                .claim("userId", "Custom") //Dòng thông tin thêm cho token tự tạo tùy ý
                .build();

        Payload payload = new Payload(jwtClaimsSet.toJSONObject());

        JWSObject jwsObject = new JWSObject(header, payload);

        try {
            jwsObject.sign(new MACSigner(SIGNER_KEY.getBytes()));
            return jwsObject.serialize();
        } catch (JOSEException e) {
            log.error("Không thể tạo token", e);
            throw new RuntimeException(e);
        }
    }

    public IntrospectResponse introspect(IntrospectRequest request)
            throws JOSEException, ParseException {
        var token = request.getToken();

        JWSVerifier verifier = new MACVerifier(SIGNER_KEY.getBytes());

        SignedJWT signedJWT= SignedJWT.parse(token);

        Date expityTime = signedJWT.getJWTClaimsSet().getExpirationTime();

        var verified = signedJWT.verify(verifier);

        return IntrospectResponse.builder()
                .valid(verified &&expityTime.after(new Date()))
                .build();
    }
}
