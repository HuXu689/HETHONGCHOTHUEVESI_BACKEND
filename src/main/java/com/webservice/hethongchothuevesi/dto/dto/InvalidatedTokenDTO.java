package com.webservice.hethongchothuevesi.dto.dto;

import java.time.LocalDateTime;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class InvalidatedTokenDTO {
	private String id;
	private LocalDateTime expiryTime;
}
