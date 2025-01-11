package com.webservice.hethongchothuevesi.service;

import com.webservice.hethongchothuevesi.dto.request.NguoiDungChangePasswordRequest;
import com.webservice.hethongchothuevesi.entity.NguoiDung;
import com.webservice.hethongchothuevesi.entity.PasswordResetToken;
import com.webservice.hethongchothuevesi.respository.NguoiDungRepository;
import com.webservice.hethongchothuevesi.respository.PasswordResetTokenRepository;
import jakarta.mail.MessagingException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;
import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

@Service
@Slf4j
@RequiredArgsConstructor
public class PasswordResetService {
    private final EmailService emailService;
    private final PasswordResetTokenRepository passwordResetTokenRepository;
    private final NguoiDungRepository nguoiDungRepository;
    private final NguoiDungService nguoiDungService;

    private static final int TOKEN_EXPIRATION_MINUTES = 30;

    /**
     * Khởi tạo quá trình đặt lại mật khẩu bằng cách gửi email chứa token.
     *
     * @param email Email của người dùng.
     */
    public void initiatePasswordReset(String email) throws MessagingException, UnsupportedEncodingException {
        Optional<NguoiDung> userOptional = nguoiDungRepository.findByEmail(email);
        if (userOptional.isEmpty()) {
            throw new IllegalArgumentException("Email không tồn tại");
        }

        // Tạo token duy nhất
        String token = UUID.randomUUID().toString();

        // Tạo và lưu token vào cơ sở dữ liệu
        PasswordResetToken resetToken = new PasswordResetToken();
        resetToken.setEmail(email);
        resetToken.setToken(token);
        resetToken.setExpirationTime(LocalDateTime.now().plusMinutes(TOKEN_EXPIRATION_MINUTES));
        passwordResetTokenRepository.save(resetToken);

        // Gửi email chứa link đặt lại mật khẩu
        emailService.sendPasswordResetLink(email, token);
        log.info("Đã gửi liên kết đặt lại mật khẩu tới email: {}", email);
    }

    /**
     * Đặt lại mật khẩu người dùng dựa trên token.
     *
     * @param token       Token nhận được từ email.
     * @param newPassword Mật khẩu mới.
     * @return `true` nếu thành công, ngược lại `false`.
     */
    public boolean resetPassword(String token, String newPassword) {
        Optional<PasswordResetToken> optionalToken = passwordResetTokenRepository.findByToken(token);
        if (optionalToken.isEmpty()) {
            log.warn("Token không hợp lệ: {}", token);
            return false;
        }

        PasswordResetToken resetToken = optionalToken.get();

        // Kiểm tra thời gian hết hạn
        if (resetToken.getExpirationTime().isBefore(LocalDateTime.now())) {
            log.warn("Token đã hết hạn: {}", token);
            passwordResetTokenRepository.delete(resetToken);
            return false;
        }

        // Tìm người dùng và cập nhật mật khẩu mới
        Optional<NguoiDung> userOptional = nguoiDungRepository.findByEmail(resetToken.getEmail());
        if (userOptional.isEmpty()) {
            log.warn("Không tìm thấy người dùng với email: {}", resetToken.getEmail());
            return false;
        }

        NguoiDung nguoiDung = userOptional.get();
        // Sử dụng NguoiDungService để thay đổi mật khẩu
        NguoiDungChangePasswordRequest changePasswordRequest = new NguoiDungChangePasswordRequest();
        changePasswordRequest.setMatKhauCu(""); // Không cần kiểm tra mật khẩu cũ khi reset từ link
        changePasswordRequest.setMatKhauMoi(newPassword);
        nguoiDungService.changePasswordByEmail(nguoiDung.getIdNguoiDung(), changePasswordRequest);

        // Xóa token sau khi sử dụng
        passwordResetTokenRepository.delete(resetToken);

        log.info("Mật khẩu đã được đặt lại thành công cho email: {}", resetToken.getEmail());
        return true;
    }
}
