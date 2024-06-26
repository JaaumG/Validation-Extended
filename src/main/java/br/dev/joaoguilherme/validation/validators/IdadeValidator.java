package br.dev.joaoguilherme.validation.validators;

import br.dev.joaoguilherme.validation.annotation.Idade;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.time.temporal.Temporal;

public class IdadeValidator implements ConstraintValidator<Idade, Temporal> {

    private int minAge;

    @Override
    public void initialize(Idade constraintAnnotation) {
        this.minAge = constraintAnnotation.minAge();
    }

    @Override
    public boolean isValid(Temporal birthDate, ConstraintValidatorContext context) {
        return birthDate == null || ChronoUnit.YEARS.between(birthDate, LocalDate.now()) >= minAge;
    }

}
