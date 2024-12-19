package com.webservice.hethongchothuevesi.controller;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.text.ParseException;
import java.util.Collections;
import java.util.Optional;

import com.google.api.client.googleapis.auth.oauth2.GoogleIdToken;
import com.google.api.client.googleapis.auth.oauth2.GoogleIdTokenVerifier;
import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.json.gson.GsonFactory;
import com.nimbusds.jose.JOSEException;
import com.webservice.hethongchothuevesi.dto.request.*;
import com.webservice.hethongchothuevesi.dto.response.AuthenticationResponse;
import com.webservice.hethongchothuevesi.dto.response.IntrospectResponse;
import com.webservice.hethongchothuevesi.entity.NguoiDung;
import com.webservice.hethongchothuevesi.entity.NguoiDungVaiTro;
import com.webservice.hethongchothuevesi.exception.AppException;
import com.webservice.hethongchothuevesi.exception.ErrorCode;
import com.webservice.hethongchothuevesi.respository.NguoiDungRepository;
import com.webservice.hethongchothuevesi.respository.NguoiDungVaiTroRepository;
import com.webservice.hethongchothuevesi.service.AuthenticationService;
import jakarta.servlet.http.PushBuilder;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.experimental.NonFinal;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/Auth")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class AuthenticationController {
	AuthenticationService authenticationService;

	@NonFinal
	@Value("${spring.security.oauth2.client.registration.google.client-id}")
	String clientId;

	@PostMapping("/LoginNguoiDung")
	public ApiResponse<AuthenticationResponse> checkNguoiDung(
			@RequestBody AuthenticationRequest request, PushBuilder pushBuilder) {
		var result = authenticationService.checkNguoiDung(request);
		return ApiResponse.<AuthenticationResponse>builder().result(result).build();
	}

	@PostMapping("/Introspect")
	public ApiResponse<IntrospectResponse> introspect(@RequestBody IntrospectRequest request, PushBuilder pushBuilder)
			throws ParseException, JOSEException {
		var result = authenticationService.introspect(request);
		return ApiResponse.<IntrospectResponse>builder().result(result).build();
	}

	@PostMapping("/LogoutNguoiDung")
	public ApiResponse<Void> logout(@RequestBody LogoutRequest request, PushBuilder pushBuilder)
			throws ParseException, JOSEException {
		authenticationService.logout(request);
		return ApiResponse.<Void>builder().build();
	}

	private final NguoiDungRepository nguoiDungRepository;
	private final NguoiDungVaiTroRepository nguoiDungVaiTroRepository;
	private static final GsonFactory GSON_FACTORY = GsonFactory.getDefaultInstance();

	@PostMapping("/LoginGoogle")
	public ApiResponse<AuthenticationResponse> loginWithGoogle(@RequestBody GoogleLoginRequest googleLoginRequest) {
		String idTokenString = googleLoginRequest.getToken();

		try {
			GoogleIdTokenVerifier verifier = new GoogleIdTokenVerifier.Builder(
							GoogleNetHttpTransport.newTrustedTransport(), GSON_FACTORY)
					.setAudience(Collections.singletonList(clientId)) // clientId từ Google OAuth
					.build();

			GoogleIdToken idToken = verifier.verify(idTokenString);
			if (idToken == null) {
				throw new AppException(ErrorCode.INVALID_GOOGLE_TOKEN);
			}

			GoogleIdToken.Payload payload = idToken.getPayload();

			// Lấy thông tin người dùng từ token
			String email = payload.getEmail();
			boolean emailVerified = Boolean.valueOf(payload.getEmailVerified());
			String name = (String) payload.get("name");

			if (!emailVerified) {
				throw new AppException(ErrorCode.EMAIL_NOT_VERIFIED);
			}

			// Kiểm tra xem người dùng đã tồn tại trong hệ thống chưa
			Optional<NguoiDung> nguoiDungOptional = nguoiDungRepository.findByEmail(email);
			NguoiDung nguoiDung;

			if (nguoiDungOptional.isPresent()) {
				nguoiDung = nguoiDungOptional.get();
			} else {
				// Tạo người dùng mới nếu chưa tồn tại
				nguoiDung = new NguoiDung();
				nguoiDung.setTenDangNhap(email); // Sử dụng email làm tên đăng nhập
				nguoiDung.setEmail(email);
				nguoiDung.setHoTen(name != null ? name : ""); // Đảm bảo không null
				// Đặt mật khẩu mặc định hoặc sử dụng mã hóa tùy chọn
				nguoiDung.setMatKhau(authenticationService.encryption("admin123")); // Bạn có thể thay đổi logic này
				nguoiDung.setTrangThai("Hoạt động");
				nguoiDungRepository.save(nguoiDung); // Lưu người dùng trước để có ID

				// Đặt vai trò là Khách hàng
				NguoiDungVaiTro nguoiDungVaiTro = NguoiDungVaiTro.builder()
						.idNguoiDung(nguoiDung.getIdNguoiDung())
						.idVaiTro(1) // 1 là ID của vai trò "Khách hàng" trong bảng VaiTro
						.build();
				nguoiDungVaiTroRepository.save(nguoiDungVaiTro);
			}

			// Tạo JWT token cho người dùng
			String jwtToken = authenticationService.generateToken(nguoiDung);

			AuthenticationResponse authResponse = AuthenticationResponse.builder()
					.token(jwtToken)
					.authenticated(true)
					.build();

			return ApiResponse.<AuthenticationResponse>builder()
					.result(authResponse)
					.code(0) // Thêm trường code
					.build();

		} catch (GeneralSecurityException | IOException e) {
			log.error("Lỗi xác thực Google ID: {}", e.getMessage());
			throw new AppException(ErrorCode.INVALID_GOOGLE_TOKEN);
		}
	}
}
