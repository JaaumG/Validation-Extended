package br.dev.joaoguilherme.validation.annotation;

import br.dev.joaoguilherme.validation.TelefoneValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = TelefoneValidator.class)
public @interface Telefone {
    String message() default "O telefone é inválido";

    String regexp() default "^(?:(?:\\+|00)?(55)\\s?)?(?:\\(?([1-9][0-9])\\)?\\s?)?(?:((?:9\\d|[2-9])\\d{3})\\-?(\\d{4}))$";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
