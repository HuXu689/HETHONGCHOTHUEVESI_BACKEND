package com.webservice.hethongchothuevesi.controller;

import java.text.ParseException;

import com.nimbusds.jose.JOSEException;
import com.webservice.hethongchothuevesi.dto.request.ApiResponse;
import com.webservice.hethongchothuevesi.dto.request.AuthenticationRequest;
import com.webservice.hethongchothuevesi.dto.request.IntrospectRequest;
import com.webservice.hethongchothuevesi.dto.request.LogoutRequest;
import com.webservice.hethongchothuevesi.dto.response.AuthenticationResponse;
import com.webservice.hethongchothuevesi.dto.response.IntrospectResponse;
import com.webservice.hethongchothuevesi.service.AuthenticationService;
import jakarta.servlet.http.PushBuilder;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Auth")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class AuthenticationController {
	AuthenticationService authenticationService;

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
}
