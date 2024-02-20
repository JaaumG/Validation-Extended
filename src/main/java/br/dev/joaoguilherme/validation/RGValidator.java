package br.dev.joaoguilherme.validation;

import br.dev.joaoguilherme.validation.annotation.RG;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;


public class RGValidator implements ConstraintValidator<RG, String> {

    private String regex;

    @Override
    public void initialize(RG constraintAnnotation) {
        regex = constraintAnnotation.regexp();
    }

    @Override
    public boolean isValid(String rg, ConstraintValidatorContext context) {
        return rg == null || rg.matches(regex);
    }
}
