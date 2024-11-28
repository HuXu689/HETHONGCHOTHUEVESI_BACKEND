package com.webservice.hethongchothuevesi.dto.request;

import jakarta.validation.constraints.Size;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class KhachHangChangePasswordRequest {
	@Size(min = 8, message = "MATKHAU_INVALID")
	String matKhauCu;

	@Size(min = 8, message = "MATKHAU_INVALID")
	String matKhauMoi;
}
