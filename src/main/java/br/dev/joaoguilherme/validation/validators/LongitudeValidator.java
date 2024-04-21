package br.dev.joaoguilherme.validation.validators;

import br.dev.joaoguilherme.validation.annotation.Longitude;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class LongitudeValidator implements ConstraintValidator<Longitude, Double> {

    @Override
    public boolean isValid(Double value, ConstraintValidatorContext context) {
        return value == null || isValidLongitude(value);
    }

    private boolean isValidLongitude(Double longitude) {
        return !(longitude < -180) && !(longitude > 180);
    }
}
