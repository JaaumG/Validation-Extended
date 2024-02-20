package br.dev.joaoguilherme.validation;

import br.dev.joaoguilherme.validation.annotation.Boleto;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;


public class BoletoValidator implements ConstraintValidator<Boleto, String> {

    private String regex;

    @Override
    public void initialize(Boleto constraintAnnotation) {
        regex = constraintAnnotation.regexp();
    }

    @Override
    public boolean isValid(String boleto, ConstraintValidatorContext context) {
        return boleto == null || boleto.matches(regex);
    }
}
