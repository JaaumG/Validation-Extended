package br.dev.joaoguilherme.validation;

import br.dev.joaoguilherme.validation.annotation.CPF_CNPJ;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;


public class CPFCNPJValidator implements ConstraintValidator<CPF_CNPJ, String> {

    private String regex;

    @Override
    public void initialize(CPF_CNPJ constraintAnnotation) {
        regex = constraintAnnotation.regexp();
    }

    @Override
    public boolean isValid(String cpfCnpj, ConstraintValidatorContext context) {
        return cpfCnpj == null || cpfCnpj.matches(regex);
    }
}
