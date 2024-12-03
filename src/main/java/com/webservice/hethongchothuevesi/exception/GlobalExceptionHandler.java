package com.webservice.hethongchothuevesi.exception;

import com.webservice.hethongchothuevesi.dto.request.ApiResponse;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.nio.file.AccessDeniedException;
import java.util.Map;
import java.util.Objects;

@ControllerAdvice
public class GlobalExceptionHandler {

    private static final String MIN_ATTRIBUTE = "min";

    @ExceptionHandler(value = Exception.class)
    public ResponseEntity<ApiResponse<String>> runtimeExceptionHandler(Exception e) {
        ApiResponse<String> apiResponse = new ApiResponse<>();

        apiResponse.setCode(ErrorCode.UNCATEGORIZED_EXCEPTION.getCode());
        apiResponse.setMessage(ErrorCode.UNCATEGORIZED_EXCEPTION.getMessage());

        return ResponseEntity
                .status(ErrorCode.UNCATEGORIZED_EXCEPTION.getHttpStatusCode())
                .body(apiResponse);
    }

    @ExceptionHandler(value = AppException.class)
    ResponseEntity<ApiResponse<String>> runtimeAppExceptionHandler(AppException e) {
        ErrorCode errorCode = e.getErrorCode();
        ApiResponse<String> apiResponse = new ApiResponse<>();

        apiResponse.setCode(errorCode.getCode());
        apiResponse.setMessage(errorCode.getMessage());

        return ResponseEntity
                .status(errorCode.getHttpStatusCode())
                .body(apiResponse);
    }

    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public ResponseEntity<ApiResponse<String>> methodArgumentNotValidExceptionHandler(MethodArgumentNotValidException e) {
        ApiResponse<String> apiResponse = new ApiResponse<>();

        if (e.getFieldError() != null) {
            String enumKey = e.getFieldError().getDefaultMessage(); // Nhận chuỗi từ @Size

            Map<String, Object> attributes = null;
            try {
                // Sử dụng ErrorCode.valueOf(enumKey) để ánh xạ trực tiếp
                ErrorCode errorCode = ErrorCode.valueOf(enumKey);

                var constraintViolation = e.getBindingResult().getAllErrors().getFirst().unwrap(ConstraintViolation.class);
                attributes = constraintViolation.getConstraintDescriptor().getAttributes();

                apiResponse.setCode(errorCode.getCode());
                apiResponse.setMessage(Objects.nonNull(attributes) ?
                        mapAttribute(errorCode.getMessage(), attributes) :
                        errorCode.getMessage());
                return ResponseEntity
                        .status(errorCode.getHttpStatusCode())
                        .body(apiResponse);
            } catch (IllegalArgumentException ex) {
                // Nếu enumKey không hợp lệ, trả về lỗi không xác định
                apiResponse.setCode(2001);
                apiResponse.setMessage("Không phát hiện lỗi");
                return ResponseEntity
                        .status(HttpStatus.BAD_REQUEST)
                        .body(apiResponse);
            }
        } else {
            apiResponse.setCode(2002);
            apiResponse.setMessage("Không phát hiện lỗi");
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(apiResponse);
        }
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
                return ResponseEntity
                        .status(errorCode.getHttpStatusCode())
                        .body(apiResponse);
            } catch (IllegalArgumentException ex) {
                // Nếu enumKey không hợp lệ
                apiResponse.setCode(2003);
                apiResponse.setMessage("Không phát hiện lỗi");
                return ResponseEntity
                        .status(HttpStatus.BAD_REQUEST)
                        .body(apiResponse);
            }
        } else {
            apiResponse.setCode(2004);
            apiResponse.setMessage("Không phát hiện lỗi");
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(apiResponse);
        }
    }

    @ExceptionHandler(value = AccessDeniedException.class)
    ResponseEntity<ApiResponse<Object>> accessDeniedExceptionHandler(AccessDeniedException e) {
        ErrorCode errorCode = ErrorCode.UN_AUTHORIZED;

        return ResponseEntity.status(errorCode.getHttpStatusCode()).body(
                ApiResponse.builder()
                        .code(errorCode.getCode())
                        .message(errorCode.getMessage())
                        .build()
        );
    }

    private String mapAttribute(String message, Map<String, Object> attributes) {
        String minValue = String.valueOf(attributes.get(MIN_ATTRIBUTE));
        return message.replace("{" + MIN_ATTRIBUTE + "}", minValue);
    }
}
