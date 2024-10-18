package com.webservice.hethongchothuevesi.exception;

import com.webservice.hethongchothuevesi.dto.request.ApiResponse;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Set;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(value = Exception.class)
    public ResponseEntity<ApiResponse<String>> runtimeExceptionHandler(Exception e) {
        ApiResponse<String> apiResponse = new ApiResponse<>();

        apiResponse.setCode(ErrorCode.UNCATEGORIZED_EXCEPTION.getCode());
        apiResponse.setMessage(ErrorCode.UNCATEGORIZED_EXCEPTION.getMessage());

        return ResponseEntity.badRequest().body(apiResponse);
    }


    @ExceptionHandler(value = AppException.class)
    ResponseEntity<ApiResponse<String>> runtimeAppExceptionHandler(AppException e) {
        ErrorCode errorCode = e.getErrorCode();
        ApiResponse<String> apiResponse = new ApiResponse<String>();

        apiResponse.setCode(errorCode.getCode());
        apiResponse.setMessage(errorCode.getMessage());

        return ResponseEntity.badRequest().body(apiResponse);
    }

    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public ResponseEntity<ApiResponse<String>> methodArgumentNotValidExceptionHandler(MethodArgumentNotValidException e) {
        ApiResponse<String> apiResponse = new ApiResponse<>();

        if (e.getFieldError() != null) {
            String enumKey = e.getFieldError().getDefaultMessage(); // Nhận chuỗi từ @Size

            try {
                // Sử dụng ErrorCode.valueOf(enumKey) để ánh xạ trực tiếp
                ErrorCode errorCode = ErrorCode.valueOf(enumKey);
                apiResponse.setCode(errorCode.getCode());
                apiResponse.setMessage(errorCode.getMessage());
            } catch (IllegalArgumentException ex) {
                // Nếu enumKey không hợp lệ, trả về lỗi không xác định
                apiResponse.setCode(2001);
                apiResponse.setMessage("Không phát hiện lỗi");
            }
        } else {
            apiResponse.setCode(2002);
            apiResponse.setMessage("Không phát hiện lỗi");
        }

        return ResponseEntity.badRequest().body(apiResponse);
    }


    @ExceptionHandler(value = ConstraintViolationException.class)
    public ResponseEntity<ApiResponse<String>> constraintViolationExceptionHandler(ConstraintViolationException e) {
        ApiResponse<String> apiResponse = new ApiResponse<>();

        // Lấy một lỗi vi phạm đầu tiên nếu có
        ConstraintViolation<?> violation = e.getConstraintViolations().iterator().next();
        if (violation != null) {
            String enumKey = violation.getMessage(); // Lấy thông báo từ ConstraintViolation

            try {
                // Ánh xạ enumKey trực tiếp tới ErrorCode
                ErrorCode errorCode = ErrorCode.valueOf(enumKey);
                apiResponse.setCode(errorCode.getCode());
                apiResponse.setMessage(errorCode.getMessage());
            } catch (IllegalArgumentException ex) {
                // Nếu enumKey không hợp lệ
                apiResponse.setCode(2003);
                apiResponse.setMessage("Không phát hiện lỗi");
            }
        } else {
            apiResponse.setCode(2004);
            apiResponse.setMessage("Không phát hiện lỗi");
        }

        return ResponseEntity.badRequest().body(apiResponse);
    }

}
