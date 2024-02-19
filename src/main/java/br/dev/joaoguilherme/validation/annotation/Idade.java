package br.dev.joaoguilherme.validation.annotation;

import br.dev.joaoguilherme.validation.IdadeValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

import br.dev.joaoguilherme.validation.annotation.Idade.List;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.ElementType.TYPE_USE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Repeatable(List.class)
@Target({ METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER, TYPE_USE })
@Retention(RUNTIME)
@Constraint(validatedBy = IdadeValidator.class)
public @interface Idade {
    String message() default "A idade mínima é de %s anos";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    int minAge();

    @Target({ METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER, TYPE_USE })
    @Retention(RUNTIME)
    @Documented
    @interface List {

        Idade[] value();
    }
}
