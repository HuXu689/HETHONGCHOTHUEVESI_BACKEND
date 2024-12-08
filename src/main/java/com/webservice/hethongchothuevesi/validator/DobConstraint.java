package com.webservice.hethongchothuevesi.validator;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

@Target({FIELD})
@Retention(RUNTIME)
@Constraint(validatedBy = {DobValidator.class})
public @interface DobConstraint {
	String message() default "Ngày sinh không hợp lệ";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};

	int min();
}
