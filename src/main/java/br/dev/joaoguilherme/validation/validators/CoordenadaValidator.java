package br.dev.joaoguilherme.validation.validators;

import br.dev.joaoguilherme.validation.annotation.Coordenada;
import br.dev.joaoguilherme.validation.enums.TipoCoordenada;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class CoordenadaValidator implements ConstraintValidator<Coordenada, String> {

    private TipoCoordenada tipoCoordenada;

    @Override
    public void initialize(Coordenada constraintAnnotation) {
        this.tipoCoordenada = constraintAnnotation.tipo();
    }


    @Override
    public boolean isValid(String coordenada, ConstraintValidatorContext context) {
        return coordenada == null || (coordenada.matches(tipoCoordenada.getRegex()) && tipoCoordenada.isValid(coordenada));
    }
}
