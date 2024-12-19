package com.webservice.hethongchothuevesi.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;

@Getter
public enum ErrorCode {
	UNCATEGORIZED_EXCEPTION(9999, "Lỗi chưa được xác định", HttpStatus.INTERNAL_SERVER_ERROR),
	TENDANGNHAP_EXISTED(1001, "Tên đăng nhập đã tồn tại", HttpStatus.BAD_REQUEST),
	TENDANGNHAP_INVALID(1002, "Tên đăng nhập ít nhất {min} ký tự", HttpStatus.BAD_REQUEST),
	MATKHAU_INVALID(1003, "Mật khẩu ít nhất 8 ký tự", HttpStatus.BAD_REQUEST),
	NGUOIDUNG_NOT_EXISTED(1004, "Không tìm thấy người dùng", HttpStatus.NOT_FOUND),
	NGUOIDUNG_ID_NOT_EXISTED(1005, "Không tìm thấy ID người dùng", HttpStatus.NOT_FOUND),
	NGUOIDUNG_NOT_DELETED(1006, "Khách hàng chưa được xóa", HttpStatus.BAD_REQUEST),
	UN_AUTHENTICATED(1007, "Chưa xác thực", HttpStatus.UNAUTHORIZED),
	EMAIL_INVALID(1008, "Email không đúng định dạng", HttpStatus.BAD_REQUEST),
	VAITRO_NOT_EXISTED(1009, "Không tìm thấy vai trò", HttpStatus.NOT_FOUND),
	UN_AUTHORIZED(1010, "Không có quyền truy cập", HttpStatus.FORBIDDEN),
	TOKEN_EXPIRED(1011, "Token hết hạn", HttpStatus.UNAUTHORIZED),
	PASSERROR(1012, "Sai tài khoản mật khẩu", HttpStatus.UNAUTHORIZED),
	NGUOIDUNG_ALREADY_BLOCKED(1013, "Tài khoản đã bị khóa trước đó", HttpStatus.BAD_REQUEST),
	// **Specific Errors**
	INVALID_GOOGLE_TOKEN(1014, "Token Google không hợp lệ", HttpStatus.UNAUTHORIZED),
	EMAIL_NOT_VERIFIED(1015, "Email chưa được xác minh", HttpStatus.BAD_REQUEST),
	// **Authentication Errors**
	UNAUTHENTICATED(1000, "Chưa xác thực", HttpStatus.UNAUTHORIZED),
	INVALID_CREDENTIALS(1001, "Sai tên đăng nhập hoặc mật khẩu", HttpStatus.UNAUTHORIZED),
	INVALID_TOKEN(1003, "Token không hợp lệ", HttpStatus.UNAUTHORIZED),

	// **Authorization Errors**
	UNAUTHORIZED_ACCESS(2000, "Không có quyền truy cập", HttpStatus.FORBIDDEN),
	ACCESS_DENIED(2001, "Truy cập bị từ chối", HttpStatus.FORBIDDEN),

	// **User Management Errors**
	USER_NOT_FOUND(3000, "Không tìm thấy người dùng", HttpStatus.NOT_FOUND),
	USER_ALREADY_EXISTS(3001, "Người dùng đã tồn tại", HttpStatus.BAD_REQUEST),
	USER_DEACTIVATED(3002, "Người dùng đã bị khóa", HttpStatus.BAD_REQUEST),

	// **Validation Errors**
	VALIDATION_FAILED(4000, "Dữ liệu nhập không hợp lệ", HttpStatus.BAD_REQUEST),
	INVALID_EMAIL_FORMAT(4001, "Email không đúng định dạng", HttpStatus.BAD_REQUEST),
	PASSWORD_TOO_SHORT(4002, "Mật khẩu phải có ít nhất 8 ký tự", HttpStatus.BAD_REQUEST),
	USERNAME_TOO_SHORT(4003, "Tên đăng nhập phải có ít nhất {min} ký tự", HttpStatus.BAD_REQUEST),

	// **Database Errors**
	DATABASE_CONNECTION_FAILED(5000, "Kết nối cơ sở dữ liệu thất bại", HttpStatus.INTERNAL_SERVER_ERROR),
	DATABASE_OPERATION_FAILED(5001, "Thao tác cơ sở dữ liệu không thành công", HttpStatus.INTERNAL_SERVER_ERROR),

	// **External Service Errors**
	GOOGLE_OAUTH_FAILED(6000, "Xác thực Google OAuth thất bại", HttpStatus.BAD_REQUEST),
	EMAIL_SENDING_FAILED(7000, "Gửi email thất bại", HttpStatus.INTERNAL_SERVER_ERROR);
	private final int code;
	private final String message;
	private final HttpStatusCode httpStatusCode;

	ErrorCode(int code, String message, HttpStatusCode httpStatusCode) {
		this.code = code;
		this.message = message;
		this.httpStatusCode = httpStatusCode;
	}
}
