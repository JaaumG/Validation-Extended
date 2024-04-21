package br.dev.joaoguilherme.validation;

import br.dev.joaoguilherme.validation.annotation.Latitude;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class LatitudeValidator implements ConstraintValidator<Latitude, Double> {
    @Override
    public boolean isValid(Double value, ConstraintValidatorContext context) {
        return value == null || isValidLatitude(value);
    }

    private boolean isValidLatitude(Double latitude) {
        return !(latitude < -90) && !(latitude > 90);
    }
}
