package com.webservice.hethongchothuevesi.validator;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class DobValidator implements ConstraintValidator<DobConstraint, LocalDate> {

	private int min;

	@Override
	public void initialize(DobConstraint constraintAnnotation) {
		ConstraintValidator.super.initialize(constraintAnnotation);
		min = constraintAnnotation.min();
	}

	/*
	 * @author: XuanHuynh
	 * @since: 1/12/2024 11:23 AM
	 * description: Kiểm tra đủ tuổi theo ngày sinh
	 * update:
	 */
	@Override
	public boolean isValid(LocalDate value, ConstraintValidatorContext context) {
		long year = ChronoUnit.YEARS.between(value, LocalDate.now());

		return year >= min;
	}
}
