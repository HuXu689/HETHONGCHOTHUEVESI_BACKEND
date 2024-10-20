package com.webservice.hethongchothuevesi.controller;

import com.nimbusds.jose.JOSEException;
import com.webservice.hethongchothuevesi.dto.request.ApiResponse;
import com.webservice.hethongchothuevesi.dto.request.AuthenticationRequest;
import com.webservice.hethongchothuevesi.dto.request.IntrospectRequest;
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

import java.text.ParseException;

@RestController
@RequestMapping("/Auth")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class AuthenticationController {
    AuthenticationService authenticationService;

    @PostMapping("/LoginKhachHang")
    public ApiResponse<AuthenticationResponse> checkKhachHang(@RequestBody AuthenticationRequest request, PushBuilder pushBuilder) {
        var result = authenticationService.checkKhachHang(request);
        return ApiResponse.<AuthenticationResponse>builder()
                .result(result)
                .build();
    }

    @PostMapping("/Introspect")
    public ApiResponse<IntrospectResponse> introspect(@RequestBody IntrospectRequest request, PushBuilder pushBuilder)
            throws ParseException, JOSEException {
        var result = authenticationService.introspect(request);
        return ApiResponse.<IntrospectResponse>builder()
                .result(result)
                .build();
    }
}
