package br.dev.joaoguilherme.validation;

import br.dev.joaoguilherme.validation.annotation.URL;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;


public class URLValidator implements ConstraintValidator<URL, String> {

    private String regex;

    @Override
    public void initialize(URL constraintAnnotation) {
        regex = constraintAnnotation.regexp();
    }

    @Override
    public boolean isValid(String url, ConstraintValidatorContext context) {
        return url == null || url.matches(regex);
    }
}
