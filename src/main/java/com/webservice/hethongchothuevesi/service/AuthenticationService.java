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
import com.webservice.hethongchothuevesi.entity.NguoiDung;
import com.webservice.hethongchothuevesi.exception.AppException;
import com.webservice.hethongchothuevesi.exception.ErrorCode;
import com.webservice.hethongchothuevesi.respository.NguoiDungRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.experimental.NonFinal;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.StringJoiner;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class AuthenticationService {
    NguoiDungRepository nguoiDungRepository;
    PasswordEncoder passwordEncoder;

    private static final Logger log = LoggerFactory.getLogger(AuthenticationService.class);

    /*
     * @author: XuanHuynh
     * @since: 26/11/2024 10:03 PM
     * description: Dùng key random trên generate-random.org/encryption-key-generator
     * update:
     */
    @NonFinal
    @Value("${jwt.signerKey}")
    protected String SIGNER_KEY;

    public String encryption(String password) {
        return passwordEncoder.encode(password);
    }

    public boolean checkNguoiDungId(int id, String password) {
        var nguoiDung =
                nguoiDungRepository.findById(id).orElseThrow(() -> new AppException(ErrorCode.NGUOIDUNG_NOT_EXISTED));

        return passwordEncoder.matches(password, nguoiDung.getMatKhau());
    }

    /*
     * @author: XuanHuynh
     * @since: 26/11/2024 8:06 PM
     * description: Kiểm tra đăng nhập khách hàng
     * update:
     */
    public AuthenticationResponse checkNguoiDung(AuthenticationRequest request) {
        var nguoiDung = nguoiDungRepository
                .findByTenDangNhap(request.getTenDangNhap())
                .orElseThrow(() -> new AppException(ErrorCode.NGUOIDUNG_NOT_EXISTED));

        boolean authenticated = passwordEncoder.matches(request.getMatKhau(), nguoiDung.getMatKhau());

        if (!authenticated) throw new AppException(ErrorCode.UN_AUTHENTICATED);

        var token = generateToken(nguoiDung);
        return AuthenticationResponse.builder().token(token).authenticated(true).build();
    }

    /*
     * @author: XuanHuynh
     * @since: 26/11/2024 8:06 PM
     * description: Tạo token đăng nhập, truy cập jwt.io để xem nội dung token
     * update:
     */
    private String generateToken(NguoiDung nguoiDung) {
        JWSHeader header = new JWSHeader(JWSAlgorithm.HS512);

        JWTClaimsSet jwtClaimsSet = new JWTClaimsSet.Builder()
                .subject(nguoiDung.getTenDangNhap())
                .issuer("hethongchothuevesi.com")
                .issueTime(new Date())
                .expirationTime(new Date(Instant.now().plus(1, ChronoUnit.HOURS).toEpochMilli()))
                .claim("scope", buildScope(nguoiDung)) // Dòng thông tin thêm cho token tự tạo tùy ý
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

    public IntrospectResponse introspect(IntrospectRequest request) throws JOSEException, ParseException {
        var token = request.getToken();

        JWSVerifier verifier = new MACVerifier(SIGNER_KEY.getBytes());

        SignedJWT signedJWT = SignedJWT.parse(token);

        Date expityTime = signedJWT.getJWTClaimsSet().getExpirationTime();

        var verified = signedJWT.verify(verifier);

        return IntrospectResponse.builder()
                .valid(verified && expityTime.after(new Date()))
                .build();
    }

    public String buildScope(NguoiDung nguoiDung) {
        StringJoiner stringJoiner = new StringJoiner(" ");
        return "admin";
    }
}
