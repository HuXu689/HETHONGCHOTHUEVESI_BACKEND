package com.webservice.hethongchothuevesi.service;

import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.util.*;

import com.webservice.hethongchothuevesi.entity.OTP;
import com.webservice.hethongchothuevesi.respository.OTPRepository;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;
import jakarta.servlet.http.HttpSession;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring6.SpringTemplateEngine;

@Slf4j
@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class EmailService {

	private final JavaMailSender mailSender;
	private final SpringTemplateEngine templateEngine;
	private final HttpSession session;
	private final OTPRepository otpRepository;

	@Value("${spring.mail.mail-from}")
	private String emailFrom;

	@Value("${spring.application.serverName}")
	private String serverName;

	@Value("${spring.application.serverLocal}")
	private String serverLocal;

	/*
	 * @author: XuanHuynh
	 * @since: 17/12/2024 4:27 PM
	 * description: Gửi email tới người dùng
	 * update:
	 */
	public String sendEmail(String recipients, String subject, String content, MultipartFile[] files)
			throws UnsupportedEncodingException, MessagingException {
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
	public void sendConfirmLink(String emailTo, String resetToken)
			throws MessagingException, UnsupportedEncodingException {
		log.info("Liên kết xác thực đang được gửi đến người dùng, email={}", emailTo);

		MimeMessage message = mailSender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(
				message, MimeMessageHelper.MULTIPART_MODE_MIXED_RELATED, StandardCharsets.UTF_8.name());
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

	private static final int OTP_EXPIRATION_MINUTES = 5;

	/*
	 * @author: XuanHuynh
	 * @since: 17/12/2024 4:26 PM
	 * description: Tạo OTP 6 số ngẫu nhiên
	 * update:
	 */
	private String generateOTP() {
		Random random = new Random();
		int otp = 100000 + random.nextInt(900000); // Tạo OTP 6 chữ số
		return String.valueOf(otp);
	}

	/*
	 * @author: XuanHuynh
	 * @since: 17/12/2024 4:26 PM
	 * description: Gửi OTP qua email và lưu vào database
	 * update:
	 */
	public void sendOTPToEmail(String email) {
		String otp = generateOTP();
		LocalDateTime now = LocalDateTime.now();
		LocalDateTime expiresAt = now.plusMinutes(OTP_EXPIRATION_MINUTES);

		// Lưu OTP vào database
		OTP otpEntity = new OTP();
		otpEntity.setEmail(email);
		otpEntity.setOtp(otp);
		otpEntity.setCreatedAt(now);
		otpEntity.setExpiresAt(expiresAt);
		otpRepository.save(otpEntity);

		// Gửi OTP qua email
		SimpleMailMessage message = new SimpleMailMessage();
		message.setTo(email);
		message.setSubject("Mã OTP xác thực");
		message.setText("Mã OTP của bạn là: " + otp);
		mailSender.send(message);

		log.info("Đã gửi OTP đến email: {}, OTP: {}", email, otp);
	}

	/*
	 * @author: XuanHuynh
	 * @since: 17/12/2024 4:26 PM
	 * description: Xác thực OTP từ database
	 * update:
	 */
	public boolean verifyOTP(String email, String otp) {
		Optional<OTP> optionalOtp = otpRepository.findTopByEmailOrderByCreatedAtDesc(email);

		if (optionalOtp.isPresent()) {
			OTP otpEntity = optionalOtp.get();

			// Kiểm tra OTP và thời gian hết hạn
			if (otpEntity.getOtp().equals(otp) && otpEntity.getExpiresAt().isAfter(LocalDateTime.now())) {
				log.info("OTP hợp lệ cho email: {}", email);
				return true;
			} else {
				log.warn("OTP không hợp lệ hoặc đã hết hạn cho email: {}", email);
				return false;
			}
		}

		log.warn("Không tìm thấy OTP cho email: {}", email);
		return false;
	}

	/*
	 * @author: XuanHuynh
	 * @since: 17/12/2024 4:25 PM
	 * description: Gửi link đặt lại mật khẩu tới người dùng.
	 * update:
	 */

	public void sendPasswordResetLink(String emailTo, String resetToken)
			throws MessagingException, UnsupportedEncodingException {
		log.info("Đang gửi link đặt lại mật khẩu tới email: {}", emailTo);

		MimeMessage message = mailSender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(
				message, MimeMessageHelper.MULTIPART_MODE_MIXED_RELATED, StandardCharsets.UTF_8.name());
		Context context = new Context();

		// Tạo liên kết đặt lại mật khẩu trỏ tới frontend React
		String resetLink = String.format("%s/reset-password?token=%s", serverLocal, resetToken);

		Map<String, Object> properties = new HashMap<>();
		properties.put("resetLink", resetLink);
		context.setVariables(properties);

		helper.setFrom(new InternetAddress(emailFrom, "BODYGUARD Hệ thống cho thuê vệ sĩ"));
		helper.setTo(emailTo);
		helper.setSubject("Yêu cầu đặt lại mật khẩu");
		String html = templateEngine.process("reset-password-email.html", context);
		helper.setText(html, true);

		mailSender.send(message);
		log.info("Link đặt lại mật khẩu đã được gửi tới email: {}", emailTo);
	}
}
