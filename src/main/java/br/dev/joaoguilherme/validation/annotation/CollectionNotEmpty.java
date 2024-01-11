package br.dev.joaoguilherme.validation.annotation;

import br.dev.joaoguilherme.validation.CollectionValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = CollectionValidator.class)
public @interface CollectionNotEmpty {

    String message() default "A collection não pode ser vazia";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
