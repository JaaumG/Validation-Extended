package br.dev.joaoguilherme.validation.validators;

import br.dev.joaoguilherme.validation.annotation.JSON;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;


public class JSONValidator implements ConstraintValidator<JSON, String> {

    @Override
    public boolean isValid(String json, ConstraintValidatorContext context) {
        if (json == null) return true;
        try {
            ObjectMapper mapper = new ObjectMapper();
            mapper.readTree(json);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
