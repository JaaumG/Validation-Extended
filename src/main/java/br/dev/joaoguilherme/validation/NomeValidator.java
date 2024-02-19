package br.dev.joaoguilherme.validation;


import br.dev.joaoguilherme.validation.annotation.Nome;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class NomeValidator implements ConstraintValidator<Nome, String> {

    private String regex;

    @Override
    public void initialize(Nome constraintAnnotation) {
        this.regex = constraintAnnotation.regexp();
    }

    @Override
    public boolean isValid(String nome, ConstraintValidatorContext context) {
        return nome == null || nome.matches(regex);
    }
}
