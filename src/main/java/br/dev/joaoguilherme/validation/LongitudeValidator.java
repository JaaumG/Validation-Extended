package br.dev.joaoguilherme.validation;

import br.dev.joaoguilherme.validation.annotation.Latitude;
import br.dev.joaoguilherme.validation.annotation.Longitude;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class LongitudeValidator implements ConstraintValidator<Longitude, String> {

    private String regex;

    @Override
    public void initialize(Longitude constraintAnnotation) {
        regex = constraintAnnotation.regexp();
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return value == null || (value.matches(regex)) && isValidLongitude(value);
    }

    private boolean isValidLongitude(String longitude) {
        try {
            double lon = Double.parseDouble(longitude);
            return !(lon < -180) && !(lon > 180);
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
