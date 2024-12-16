package com.webservice.hethongchothuevesi.controller;

import com.webservice.hethongchothuevesi.dto.request.ApiResponse;
import com.webservice.hethongchothuevesi.service.EmailService;
import jakarta.mail.MessagingException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.UnsupportedEncodingException;

@Slf4j
@RestController
@RequestMapping("/Email")
public record EmailController(EmailService mailService) {

    @PostMapping("/send-email")
    public ApiResponse<?> sendEmail(@RequestParam String recipients, @RequestParam String subject,
                                    @RequestParam String content, @RequestParam(required = false) MultipartFile[] files) {
        log.info("Request POST /Email/send-email");
        try {
            return new ApiResponse(1000, mailService.sendEmail(recipients, subject, content, files));
        } catch (UnsupportedEncodingException | MessagingException e) {
            log.error("Gửi email không thành công, message={}", e.getMessage(), e);
            return new ApiResponse(3000, "Gửi email không thành công");
        }
    }

    // API gửi OTP qua email
    @PostMapping("/send-otp")
    public String sendOTP(@RequestParam String email) {
        mailService.sendOTPToEmail(email);
        return "OTP đã được gửi tới email: " + email;
    }

    // API kiểm tra OTP với email
    @PostMapping("/verify-otp")
    public String verifyOTP(@RequestParam String email, @RequestParam String otp) {
        boolean isValid = mailService.verifyOTP(email, otp);
        if (isValid) {
            return "Xác thực OTP thành công!";
        } else {
            return "Mã OTP hoặc email không hợp lệ!";
        }
    }
}