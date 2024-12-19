package com.webservice.hethongchothuevesi.configuration;

import java.util.Arrays;
import java.util.List;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationConverter;
import org.springframework.security.oauth2.server.resource.authentication.JwtGrantedAuthoritiesConverter;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity(prePostEnabled = true)
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class SecurityConfig {

	// Danh sách API public
	final String[] PUBLIC_ENDPOINTS = {
		"/NguoiDung/Create", "/Auth/Introspect", "/Auth/LoginNguoiDung", "/Auth/LogoutNguoiDung"
	};

	//    @Value("${jwt.signerKey}")
	//    String signerKey;

	@Autowired
	CustomJwtDecoder customJwtDecoder;

	/*
	 * @author: XuanHuynh
	 * @since: 1/12/2024 10:12 AM
	 * description: Cài đặt quyền truy cập api
	 * update:
	 */
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http
				// Cho phép tất cả các request không cần xác thực
				.authorizeHttpRequests(auth -> auth.anyRequest().permitAll())
				// Tắt hẳn việc xác thực OAuth2/JWT resource server nếu đang sử dụng
				.oauth2ResourceServer(AbstractHttpConfigurer::disable)
				// Tắt CSRF nếu muốn
				.csrf(AbstractHttpConfigurer::disable)
				.oauth2ResourceServer(oauth2 -> oauth2.jwt(
						jwtConfigurer -> jwtConfigurer.jwtAuthenticationConverter(jwtAuthenticationConverter())))
				.cors(cors -> cors.configurationSource(corsConfigurationSource()));

		return http.build();
	}
	//	@Bean
	//	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
	//		http.authorizeHttpRequests(auth -> auth
	//						// Cho phép truy cập swagger UI, v3/api-docs mà không cần xác thực
	//						.requestMatchers(
	//								"/swagger-ui.html",
	//								"/swagger-ui/**",
	//								"/v3/api-docs/**",
	//								"/HuXu/swagger-ui/**",
	//								"/HuXu/v3/api-docs/**")
	//						.permitAll()
	//
	//						// Các API public khác
	//						.requestMatchers(HttpMethod.POST, PUBLIC_ENDPOINTS)
	//						.permitAll()
	//
	//						// Các endpoint còn lại yêu cầu xác thực
	//						.anyRequest()
	//						.authenticated())
	//				.csrf(AbstractHttpConfigurer::disable)
	//				.oauth2ResourceServer(oauth2 -> oauth2.jwt(
	//						jwtConfigurer -> jwtConfigurer.jwtAuthenticationConverter(jwtAuthenticationConverter())))
	//				.cors(cors -> cors.configurationSource(corsConfigurationSource()));
	//
	//		return http.build();
	//	}

	@Bean
	public CorsConfigurationSource corsConfigurationSource() {
		CorsConfiguration corsConfiguration = new CorsConfiguration();

		// Cấu hình các thuộc tính CORS
		corsConfiguration.setAllowedOrigins(List.of("http://localhost:3000")); // Cho phép frontend từ localhost:3000
		corsConfiguration.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "DELETE")); // Các phương thức được phép
		corsConfiguration.setAllowedHeaders(List.of("*")); // Cho phép tất cả các headers
		corsConfiguration.setAllowCredentials(true); // Cho phép gửi thông tin xác thực (credentials)

		// Đăng ký cấu hình CORS
		UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		source.registerCorsConfiguration("/**", corsConfiguration);

		return source;
	}

	/*
	 * @author: XuanHuynh
	 * @since: 30/11/2024 11:27 PM
	 * description: Chuyển đổi từ ngữ code thay vì SCOPE_Admin thành ROLE_Admin
	 * update:
	 */
	@Bean
	JwtAuthenticationConverter jwtAuthenticationConverter() {
		JwtGrantedAuthoritiesConverter jwtGrantedAuthoritiesConverter = new JwtGrantedAuthoritiesConverter();
		jwtGrantedAuthoritiesConverter.setAuthorityPrefix("ROLE_");

		JwtAuthenticationConverter jwtAuthenticationConverter = new JwtAuthenticationConverter();
		jwtAuthenticationConverter.setJwtGrantedAuthoritiesConverter(jwtGrantedAuthoritiesConverter);

		return jwtAuthenticationConverter;
	}

	//    @Bean
	//    JwtDecoder jwtDecoder() {
	//        SecretKeySpec secretKeySpec = new SecretKeySpec(signerKey.getBytes(), "HS512");
	//        return NimbusJwtDecoder.withSecretKey(secretKeySpec)
	//                .macAlgorithm(MacAlgorithm.HS512)
	//                .build();
	//    }

	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder(7);
	}
}
