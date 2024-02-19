package br.dev.joaoguilherme.validation.annotation;

import br.dev.joaoguilherme.validation.CEPValidator;
import br.dev.joaoguilherme.validation.RGValidator;
import br.dev.joaoguilherme.validation.annotation.RG.List;
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
@Constraint(validatedBy = RGValidator.class)
public @interface RG {

    String message() default "CEP inválido";

    String regexp() default "(\\d{1,2}\\.?)(\\d{3}\\.?)(\\d{3})(\\-?[0-9Xx]{1})";

    @Target({ METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER, TYPE_USE })
    @Retention(RUNTIME)
    @Documented
    @interface List {

        RG[] value();
    }
}
