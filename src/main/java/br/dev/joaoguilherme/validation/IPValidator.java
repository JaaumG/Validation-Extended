package br.dev.joaoguilherme.validation;

import br.dev.joaoguilherme.validation.annotation.CEP;
import br.dev.joaoguilherme.validation.annotation.IP;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;


public class IPValidator implements ConstraintValidator<IP, String> {

    private String regex;
    @Override
    public void initialize(IP constraintAnnotation) {
        regex = constraintAnnotation.regexp();
    }

    @Override
    public boolean isValid(String ip, ConstraintValidatorContext context) {
        return ip == null || ip.matches(regex);
    }
}
