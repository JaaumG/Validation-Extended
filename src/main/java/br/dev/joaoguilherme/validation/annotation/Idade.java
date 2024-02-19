package br.dev.joaoguilherme.validation.annotation;

import br.dev.joaoguilherme.validation.IdadeValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = IdadeValidator.class)
public @interface Idade {
    String message() default "A idade mínima é de %s anos";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    int minAge();
}
