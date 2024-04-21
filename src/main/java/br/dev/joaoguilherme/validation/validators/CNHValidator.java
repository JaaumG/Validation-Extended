package br.dev.joaoguilherme.validation.validators;

import br.dev.joaoguilherme.validation.annotation.CNH;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;


public class CNHValidator implements ConstraintValidator<CNH, String> {

    private String regex;

    @Override
    public void initialize(CNH constraintAnnotation) {
        regex = constraintAnnotation.regexp();
    }

    @Override
    public boolean isValid(String cnh, ConstraintValidatorContext context) {
        return cnh == null || cnh.matches(regex);
    }
}
