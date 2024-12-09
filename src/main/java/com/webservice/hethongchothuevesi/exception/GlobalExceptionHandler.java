package com.webservice.hethongchothuevesi.exception;

import java.nio.file.AccessDeniedException;
import java.util.Map;

import com.webservice.hethongchothuevesi.dto.request.ApiResponse;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.oauth2.jwt.BadJwtException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

	private static final String MIN_ATTRIBUTE = "min";

	// Xử lý ngoại lệ BadJwtException khi token không hợp lệ hoặc sai định dạng
	@ExceptionHandler(value = BadJwtException.class)
	public ResponseEntity<ApiResponse<String>> badJwtExceptionHandler(BadJwtException e) {
		ApiResponse<String> apiResponse = new ApiResponse<>();
		apiResponse.setCode(1009); // Mã lỗi ví dụ cho BadJwtException
		apiResponse.setMessage("Token không hợp lệ hoặc sai định dạng");

		return ResponseEntity.status(HttpStatus.UNAUTHORIZED) // Trả về HTTP status 401 (Unauthorized)
				.body(apiResponse);
	}

	@ExceptionHandler(value = Exception.class)
	public ResponseEntity<ApiResponse<String>> runtimeExceptionHandler(Exception e) {

		ApiResponse<String> apiResponse = new ApiResponse<>();

		// Nếu muốn trả về thông tin chi tiết lỗi trong giai đoạn phát triển
		String detailedMessage = e.getMessage() != null ? e.getMessage() : "Không có thông tin chi tiết";

		apiResponse.setCode(ErrorCode.UNCATEGORIZED_EXCEPTION.getCode());
		apiResponse.setMessage(ErrorCode.UNCATEGORIZED_EXCEPTION.getMessage() + ": " + detailedMessage);

		return ResponseEntity.status(ErrorCode.UNCATEGORIZED_EXCEPTION.getHttpStatusCode())
				.body(apiResponse);
	}

	// Xử lý các ngoại lệ tùy chỉnh AppException
	@ExceptionHandler(value = AppException.class)
	public ResponseEntity<ApiResponse<String>> runtimeAppExceptionHandler(AppException e) {
		ErrorCode errorCode = e.getErrorCode();
		ApiResponse<String> apiResponse = new ApiResponse<>();

		apiResponse.setCode(errorCode.getCode());
		apiResponse.setMessage(errorCode.getMessage());

		return ResponseEntity.status(errorCode.getHttpStatusCode()).body(apiResponse);
	}

	// Xử lý ngoại lệ khi tham số không hợp lệ
	@ExceptionHandler(value = MethodArgumentNotValidException.class)
	public ResponseEntity<ApiResponse<String>> methodArgumentNotValidExceptionHandler(
			MethodArgumentNotValidException e) {
		ApiResponse<String> apiResponse = new ApiResponse<>();

		if (e.getFieldError() != null) {
			String enumKey = e.getFieldError().getDefaultMessage();

			try {
				// Ánh xạ enumKey tới ErrorCode
				ErrorCode errorCode = ErrorCode.valueOf(enumKey);

				// Không thể unwrap thành ConstraintViolation, nên bỏ qua phần attributes
				apiResponse.setCode(errorCode.getCode());
				apiResponse.setMessage(errorCode.getMessage());

				return ResponseEntity.status(errorCode.getHttpStatusCode()).body(apiResponse);
			} catch (IllegalArgumentException ex) {
				// Nếu enumKey không hợp lệ, trả về lỗi không xác định
				apiResponse.setCode(2001);
				apiResponse.setMessage("Không phát hiện lỗi");
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(apiResponse);
			}
		} else {
			apiResponse.setCode(2002);
			apiResponse.setMessage("Không phát hiện lỗi");
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(apiResponse);
		}
	}

	// Xử lý ngoại lệ vi phạm ràng buộc
	@ExceptionHandler(value = ConstraintViolationException.class)
	public ResponseEntity<ApiResponse<String>> constraintViolationExceptionHandler(ConstraintViolationException e) {
		ApiResponse<String> apiResponse = new ApiResponse<>();

		// Lấy một lỗi vi phạm đầu tiên nếu có
		ConstraintViolation<?> violation =
				e.getConstraintViolations().iterator().next();
		if (violation != null) {
			String enumKey = violation.getMessage(); // Lấy thông báo từ ConstraintViolation

			try {
				// Ánh xạ enumKey trực tiếp tới ErrorCode
				ErrorCode errorCode = ErrorCode.valueOf(enumKey);
				apiResponse.setCode(errorCode.getCode());
				apiResponse.setMessage(errorCode.getMessage());
				return ResponseEntity.status(errorCode.getHttpStatusCode()).body(apiResponse);
			} catch (IllegalArgumentException ex) {
				// Nếu enumKey không hợp lệ
				apiResponse.setCode(2003);
				apiResponse.setMessage("Không phát hiện lỗi");
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(apiResponse);
			}
		} else {
			apiResponse.setCode(2004);
			apiResponse.setMessage("Không phát hiện lỗi");
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(apiResponse);
		}
	}

	// Xử lý ngoại lệ khi truy cập bị từ chối
	@ExceptionHandler(value = AccessDeniedException.class)
	public ResponseEntity<ApiResponse<Object>> accessDeniedExceptionHandler(AccessDeniedException e) {
		ErrorCode errorCode = ErrorCode.UN_AUTHORIZED;

		return ResponseEntity.status(errorCode.getHttpStatusCode())
				.body(ApiResponse.builder()
						.code(errorCode.getCode())
						.message(errorCode.getMessage())
						.build());
	}

	// Hàm hỗ trợ ánh xạ thông điệp với các thuộc tính
	private String mapAttribute(String message, Map<String, Object> attributes) {
		String minValue = String.valueOf(attributes.get(MIN_ATTRIBUTE));
		return message.replace("{" + MIN_ATTRIBUTE + "}", minValue);
	}
}
