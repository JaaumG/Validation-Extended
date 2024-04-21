package br.dev.joaoguilherme.validation;

import br.dev.joaoguilherme.validation.annotation.Latitude;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class LatitudeValidator implements ConstraintValidator<Latitude, String> {

    private String regex;

    @Override
    public void initialize(Latitude constraintAnnotation) {
        regex = constraintAnnotation.regexp();
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return value == null || (value.matches(regex)) && isValidLatitude(value);
    }

    private boolean isValidLatitude(String latitude) {
        try {
            double lat = Double.parseDouble(latitude);
            return !(lat < -90) && !(lat > 90);
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
