package br.dev.joaoguilherme.validation;

import br.dev.joaoguilherme.validation.annotation.Telefone;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class TelefoneValidator implements ConstraintValidator<Telefone, String> {

    private String regex;

    @Override
    public void initialize(Telefone constraintAnnotation) {
        this.regex = constraintAnnotation.regexp();
    }

    @Override
    public boolean isValid(String telefone, ConstraintValidatorContext context) {
        if (telefone == null) return true;
        return telefone.matches(regex);
    }
}