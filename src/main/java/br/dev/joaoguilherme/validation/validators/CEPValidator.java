package br.dev.joaoguilherme.validation.validators;

import br.dev.joaoguilherme.validation.annotation.CEP;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;


public class CEPValidator implements ConstraintValidator<CEP, String> {

    private String regex;

    @Override
    public void initialize(CEP constraintAnnotation) {
        regex = constraintAnnotation.regexp();
    }

    @Override
    public boolean isValid(String cep, ConstraintValidatorContext context) {
        return cep == null || cep.matches(regex);
    }
}
