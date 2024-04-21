package br.dev.joaoguilherme.validation.annotation;

import br.dev.joaoguilherme.validation.validators.CNJValidator;
import br.dev.joaoguilherme.validation.annotation.CNJ.List;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.Documented;
import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Repeatable(List.class)
@Target({METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER, TYPE_USE})
@Retention(RUNTIME)
@Constraint(validatedBy = CNJValidator.class)
public @interface CNJ {

    String message() default "CNJ inválido";

    String regexp() default "[0-9]{7}\\-?[0-9]{2}\\.?[0-9]{4}\\.?[4-8]\\.?[0-9]{2}\\.?[0-9]{4}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    @Target({METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER, TYPE_USE})
    @Retention(RUNTIME)
    @Documented
    @interface List {

        CNJ[] value();
    }
}
