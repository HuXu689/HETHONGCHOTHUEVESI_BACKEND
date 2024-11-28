package com.webservice.hethongchothuevesi.exception;

import lombok.Getter;

@Getter
public enum ErrorCode {
	UNCATEGORIZED_EXCEPTION(9999, "Lỗi chưa được xác định"),
	TENDANGNHAP_EXISTED(1001, "Tên đăng nhập đã tồn tại"),
	TENDANGNHAP_INVALID(1002, "Tên đăng nhập ít nhất 6 ký tự"),
	MATKHAU_INVALID(1003, "Mật khẩu ít nhất 8 ký tự"),
	KHACHHANG_NOT_EXISTED(1004, "Không tìm thấy khách hàng"),
	KHACHHANG_ID_NOT_EXISTED(1004, "Không tìm thấy ID khách hàng"),
	KHACHHANG_NOT_DELETED(1005, "Khách hàng chưa được xóa"),
	UN_AUTHENTICATED(1006, "Sai mật khẩu"),
	EMAIL_INVALID(1007, "Email không đúng định dạng");
	private final int code;
	private final String message;

	ErrorCode(int code, String message) {
		this.code = code;
		this.message = message;
	}
}
