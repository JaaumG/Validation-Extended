package br.dev.joaoguilherme.validation;

import br.dev.joaoguilherme.validation.annotation.CollectionNotEmpty;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.Collection;

public class CollectionValidator implements ConstraintValidator<CollectionNotEmpty, Collection<?>> {
    @Override
    public void initialize(CollectionNotEmpty constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(Collection value, ConstraintValidatorContext context) {
        if (value == null) return false;
        return !value.isEmpty();
    }
}
