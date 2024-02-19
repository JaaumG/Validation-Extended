package br.dev.joaoguilherme.validation;

import br.dev.joaoguilherme.validation.annotation.CEP;
import br.dev.joaoguilherme.validation.annotation.CNJ;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;


public class CNJValidator implements ConstraintValidator<CNJ, String> {

    private String regex;
    @Override
    public void initialize(CNJ constraintAnnotation) {
        regex = constraintAnnotation.regexp();
    }

    @Override
    public boolean isValid(String cnj, ConstraintValidatorContext context) {
        return cnj == null || cnj.matches(regex);
    }
}
