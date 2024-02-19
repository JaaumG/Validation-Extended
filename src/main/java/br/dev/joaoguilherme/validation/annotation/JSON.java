package br.dev.joaoguilherme.validation.annotation;

import br.dev.joaoguilherme.validation.JSONValidator;
import br.dev.joaoguilherme.validation.annotation.JSON.List;
import jakarta.validation.Constraint;

import java.lang.annotation.Documented;
import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Repeatable(List.class)
@Target({ METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER, TYPE_USE })
@Retention(RUNTIME)
@Constraint(validatedBy = JSONValidator.class)
public @interface JSON {

    String message() default "JSON inválido";


    @Target({ METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER, TYPE_USE })
    @Retention(RUNTIME)
    @Documented
    @interface List {

        JSON[] value();
    }
}
