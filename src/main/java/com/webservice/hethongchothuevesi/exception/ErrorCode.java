package com.webservice.hethongchothuevesi.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;

@Getter
public enum ErrorCode {
    UNCATEGORIZED_EXCEPTION(9999, "Lỗi chưa được xác định", HttpStatus.INTERNAL_SERVER_ERROR),
    TENDANGNHAP_EXISTED(1001, "Tên đăng nhập đã tồn tại", HttpStatus.BAD_REQUEST),
    TENDANGNHAP_INVALID(1002, "Tên đăng nhập ít nhất {min} ký tự", HttpStatus.BAD_REQUEST),
    MATKHAU_INVALID(1003, "Mật khẩu ít nhất {min} ký tự", HttpStatus.BAD_REQUEST),
    NGUOIDUNG_NOT_EXISTED(1004, "Không tìm thấy người dùng", HttpStatus.NOT_FOUND),
    NGUOIDUNG_ID_NOT_EXISTED(1005, "Không tìm thấy ID người dùng", HttpStatus.NOT_FOUND),
    NGUOIDUNG_NOT_DELETED(1006, "Khách hàng chưa được xóa", HttpStatus.BAD_REQUEST),
    UN_AUTHENTICATED(1007, "Chưa xác thực", HttpStatus.UNAUTHORIZED),
    EMAIL_INVALID(1008, "Email không đúng định dạng", HttpStatus.BAD_REQUEST),
    VAITRO_NOT_EXISTED(1009, "Không tìm thấy vai trò", HttpStatus.NOT_FOUND),
    UN_AUTHORIZED(1010, "Không có quyền truy cập", HttpStatus.FORBIDDEN),
    TOKEN_EXPIRED(1011, "Token hết hạn", HttpStatus.UNAUTHORIZED),
    PASSERROR(1012, "Sai tài khoản mật khẩu", HttpStatus.UNAUTHORIZED),
    NGUOIDUNG_ALREADY_BLOCKED(1013, "Tài khoản đã bị khóa trước đó", HttpStatus.BAD_REQUEST);
    private final int code;
    private final String message;
    private final HttpStatusCode httpStatusCode;

    ErrorCode(int code, String message, HttpStatusCode httpStatusCode) {
        this.code = code;
        this.message = message;
        this.httpStatusCode = httpStatusCode;
    }
}
