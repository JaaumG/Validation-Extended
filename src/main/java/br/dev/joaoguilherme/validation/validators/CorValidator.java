package br.dev.joaoguilherme.validation.validators;

import br.dev.joaoguilherme.validation.annotation.Cor;
import br.dev.joaoguilherme.validation.enums.TipoCor;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;


public class CorValidator implements ConstraintValidator<Cor, String> {

    private TipoCor tipoCor;

    @Override
    public void initialize(Cor constraintAnnotation) {
        this.tipoCor = constraintAnnotation.tipo();
    }

    @Override
    public boolean isValid(String cor, ConstraintValidatorContext context) {
        return cor == null || cor.matches(tipoCor.getRegex());
    }
}
