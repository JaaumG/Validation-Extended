package br.dev.joaoguilherme.validation.annotation;

import br.dev.joaoguilherme.validation.TelefoneValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

import br.dev.joaoguilherme.validation.annotation.Telefone.List;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.ElementType.TYPE_USE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Repeatable(List.class)
@Target({ METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER, TYPE_USE })
@Retention(RUNTIME)
@Constraint(validatedBy = TelefoneValidator.class)
public @interface Telefone {
    String message() default "O telefone é inválido";

    String regexp() default "^(?:(?:\\+|00)?(55)\\s?)?(?:\\(?([1-9][0-9])\\)?\\s?)?(?:((?:9\\d|[2-9])\\d{3})\\-?(\\d{4}))$";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};


    @Target({ METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER, TYPE_USE })
    @Retention(RUNTIME)
    @Documented
    @interface List {

        Telefone[] value();
    }
}
