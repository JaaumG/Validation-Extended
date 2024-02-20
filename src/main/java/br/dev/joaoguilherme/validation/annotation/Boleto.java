package br.dev.joaoguilherme.validation.annotation;

import br.dev.joaoguilherme.validation.BoletoValidator;
import br.dev.joaoguilherme.validation.annotation.Boleto.List;
import jakarta.validation.Constraint;

import java.lang.annotation.Documented;
import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Repeatable(List.class)
@Target({METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER, TYPE_USE})
@Retention(RUNTIME)
@Constraint(validatedBy = BoletoValidator.class)
public @interface Boleto {

    String message() default "Boleto ou Linha Digitável inválidos";

    String regexp() default "(\\d{5}[\\.]\\d{5}[\\s]\\d{5}[\\.]\\d{6}[\\s]\\d{5}[\\.]\\d{6}[\\s]\\d[\\s]\\d{14})|(\\d{47,48})|(\\d{12} \\d{12} \\d{12} \\d{12})";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    @Target({METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER, TYPE_USE})
    @Retention(RUNTIME)
    @Documented
    @interface List {

        Boleto[] value();
    }
}
