package com.atv2.picpay.presentation.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class CPFValidator implements ConstraintValidator<CPF, String> {
    static final String CPF_PATTERN = "^\\d{11}$";

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return value == null || value.matches(CPF_PATTERN);
    }
}
