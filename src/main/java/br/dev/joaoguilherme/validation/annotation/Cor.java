package br.dev.joaoguilherme.validation.annotation;

import br.dev.joaoguilherme.validation.enums.TipoCor;
import br.dev.joaoguilherme.validation.validators.CorValidator;
import br.dev.joaoguilherme.validation.annotation.Cor.List;
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
@Constraint(validatedBy = CorValidator.class)
public @interface Cor {

    String message() default "Cor inválida";

    TipoCor tipo() default TipoCor.HEX;

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    @Target({METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER, TYPE_USE})
    @Retention(RUNTIME)
    @Documented
    @interface List {

        Cor[] value();
    }
}
