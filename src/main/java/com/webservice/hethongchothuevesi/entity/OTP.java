package com.webservice.hethongchothuevesi.entity;

import java.time.LocalDateTime;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name = "otp_store")
public class OTP {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;

	@Column(nullable = false)
	String email;

	@Column(nullable = false, length = 6)
	String otp;

	@Column(nullable = false)
	LocalDateTime createdAt;

	@Column(nullable = false)
	LocalDateTime expiresAt;
}
