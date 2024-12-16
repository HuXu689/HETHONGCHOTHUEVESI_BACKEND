package com.webservice.hethongchothuevesi.service;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;
import jakarta.servlet.http.HttpSession;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring6.SpringTemplateEngine;

import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Random;

@Slf4j
@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class EmailService {

    private final JavaMailSender mailSender;
    private final SpringTemplateEngine templateEngine;

    @Value("${spring.mail.mail-from}")
    private String emailFrom;

    @Value("${spring.application.serverName}")
    private String serverName;

    @Autowired
    private HttpSession session;

    /**
     * Send email by Google SMTP
     *
     * @param recipients
     * @param subject
     * @param content
     * @param files
     * @return
     * @throws UnsupportedEncodingException
     * @throws MessagingException
     */
    public String sendEmail(String recipients, String subject, String content, MultipartFile[] files) throws UnsupportedEncodingException, MessagingException {
        log.info("Đang gửi email ...");

        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true, "UTF-8");
        helper.setFrom(emailFrom, "BODYGUARD Hệ thống cho thuê vệ sĩ");

        if (recipients.contains(",")) { // send to multiple users
            helper.setTo(InternetAddress.parse(recipients));
        } else { // send to single user
            helper.setTo(recipients);
        }

        // Send attach files
        if (files != null) {
            for (MultipartFile file : files) {
                helper.addAttachment(Objects.requireNonNull(file.getOriginalFilename()), file);
            }
        }

        helper.setSubject(subject);
        helper.setText(content, true);
        mailSender.send(message);

        log.info("Đã gửi mail thành công, recipients: {}", recipients);

        return "Đã gửi mail";
    }

    /**
     * Send link confirm to email register.
     *
     * @param emailTo
     * @param resetToken
     * @throws MessagingException
     * @throws UnsupportedEncodingException
     */
    public void sendConfirmLink(String emailTo, String resetToken) throws MessagingException, UnsupportedEncodingException {
        log.info("Liên kết xác thực đang được gửi đến người dùng, email={}", emailTo);

        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, MimeMessageHelper.MULTIPART_MODE_MIXED_RELATED, StandardCharsets.UTF_8.name());
        Context context = new Context();

        String linkConfirm = String.format("%s/auth/reset-password?secretKey=%s", serverName, resetToken);

        Map<String, Object> properties = new HashMap<>();
        properties.put("linkConfirm", linkConfirm);
        context.setVariables(properties);

        helper.setFrom(emailFrom, "BODYGUARD Hệ thống cho thuê vệ sĩ");
        helper.setTo(emailTo);
        helper.setSubject("Vui lòng xác nhận tài khoản của bạn");
        String html = templateEngine.process("confirm-email.html", context);
        helper.setText(html, true);

        mailSender.send(message);
        log.info("Liên kết xác thực đã được gửi đến người dùng, email={}, linkConfirm={}", emailTo, linkConfirm);
    }


    private static final long OTP_EXPIRATION_TIME = 300 * 1000; // 5 phút (thời gian hết hạn của OTP)

    // Hàm tạo OTP 6 chữ số
    public String generateOTP() {
        Random random = new Random();
        int otp = 100000 + random.nextInt(900000); // OTP 6 chữ số
        return String.valueOf(otp);
    }

    // Hàm gửi OTP qua email và lưu OTP + email + thời gian tạo OTP vào session
    public void sendOTPToEmail(String email) {
        String otp = generateOTP();
        long currentTime = System.currentTimeMillis(); // Lấy thời gian hiện tại

        // Lưu OTP, email và thời gian tạo OTP vào session
        session.setAttribute("OTP", otp);
        session.setAttribute("email", email);
        session.setAttribute("otpCreationTime", currentTime); // Lưu thời gian tạo OTP

        // Gửi email chứa OTP
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(email);
        message.setSubject("Mã OTP xác thực");
        message.setText("Mã OTP của bạn là: " + otp);
        mailSender.send(message);
    }

    // Hàm kiểm tra OTP và đối chiếu với email
    public boolean verifyOTP(String email, String otp) {
        String sessionOtp = (String) session.getAttribute("OTP");
        String sessionEmail = (String) session.getAttribute("email");
        Long otpCreationTime = (Long) session.getAttribute("otpCreationTime");

        // Kiểm tra OTP và email, đồng thời kiểm tra thời gian hết hạn
        if (sessionOtp != null && sessionEmail != null && sessionEmail.equals(email) && sessionOtp.equals(otp)) {
            long currentTime = System.currentTimeMillis();
            if (currentTime - otpCreationTime <= OTP_EXPIRATION_TIME) {
                return true; // OTP hợp lệ và chưa hết hạn
            } else {
                session.removeAttribute("OTP"); // OTP hết hạn, xóa khỏi session
                session.removeAttribute("otpCreationTime");
                return false; // OTP đã hết hạn
            }
        } else {
            return false; // OTP hoặc email không hợp lệ
        }
    }
}
