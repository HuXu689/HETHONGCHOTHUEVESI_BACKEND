package com.webservice.hethongchothuevesi.controller;

import com.webservice.hethongchothuevesi.dto.request.ApiResponse;
import com.webservice.hethongchothuevesi.dto.request.ForgotPasswordRequest;
import com.webservice.hethongchothuevesi.dto.request.ResetPasswordRequest;
import com.webservice.hethongchothuevesi.service.PasswordResetService;
import jakarta.mail.MessagingException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.UnsupportedEncodingException;

@RestController
@RequestMapping("/Password")
@Slf4j
@RequiredArgsConstructor
public class PasswordResetController {
    private final PasswordResetService passwordResetService;

    /**
     * Yêu cầu đặt lại mật khẩu.
     *
     * @param request Yêu cầu chứa email.
     * @return Thông báo thành công hoặc lỗi.
     */
    @PostMapping("/Forgot")
    public ResponseEntity<?> forgotPassword(@RequestBody ForgotPasswordRequest request) {
        try {
            passwordResetService.initiatePasswordReset(request.getEmail());
            return ResponseEntity.ok(new ApiResponse<>(1000, "Link đặt lại mật khẩu đã được gửi tới email của bạn."));
        } catch (IllegalArgumentException e) {
            log.error("Lỗi: {}", e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ApiResponse<>(3000, e.getMessage()));
        } catch (MessagingException | UnsupportedEncodingException e) {
            log.error("Lỗi khi gửi email: {}", e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ApiResponse<>(3000, "Đã xảy ra lỗi khi gửi email."));
        }
    }

    /**
     * Đặt lại mật khẩu.
     *
     * @param request Yêu cầu chứa token và mật khẩu mới.
     * @return Thông báo thành công hoặc lỗi.
     */
    @PostMapping("/Reset")
    public ResponseEntity<?> resetPassword(@RequestBody ResetPasswordRequest request) {
        boolean isReset = passwordResetService.resetPassword(request.getToken(), request.getNewPassword());
        if (isReset) {
            return ResponseEntity.ok(new ApiResponse<>(1000, "Mật khẩu đã được đặt lại thành công."));
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ApiResponse<>(3000, "Token không hợp lệ hoặc đã hết hạn."));
        }
    }
}
