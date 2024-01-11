package br.dev.joaoguilherme.validation;

import br.dev.joaoguilherme.validation.annotation.IdadeMinima;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.time.temporal.Temporal;

public class IdadeMinimaValidator implements ConstraintValidator<IdadeMinima, Temporal> {

    private int minAge;

    @Override
    public void initialize(IdadeMinima constraintAnnotation) {
        this.minAge = constraintAnnotation.minAge();
    }

    @Override
    public boolean isValid(Temporal birthDate, ConstraintValidatorContext context) {
        if (birthDate == null) return false;
        return ChronoUnit.YEARS.between(birthDate, LocalDate.now()) >= minAge;
    }

}
