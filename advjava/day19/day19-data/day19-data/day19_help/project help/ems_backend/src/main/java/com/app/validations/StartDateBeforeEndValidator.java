package com.app.validations;

import com.app.dto.ProjectDTO;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class StartDateBeforeEndValidator implements ConstraintValidator<StartDateBeforeEnd, ProjectDTO> {	@Override
	public boolean isValid(ProjectDTO dto, ConstraintValidatorContext context) {
		System.out.println("in custom validation " + dto + " " + context);
		if (dto.getStartDate() != null && dto.getEndDate() != null)
			return dto.getStartDate().isBefore(dto.getEndDate());
		return false;
	}

}
