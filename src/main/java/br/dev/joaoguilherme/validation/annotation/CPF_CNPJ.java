package br.dev.joaoguilherme.validation.annotation;

import br.dev.joaoguilherme.validation.CEPValidator;
import br.dev.joaoguilherme.validation.CPFCNPJValidator;
import br.dev.joaoguilherme.validation.annotation.CPF_CNPJ.List;
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
@Constraint(validatedBy = CPFCNPJValidator.class)
public @interface CPF_CNPJ {

    String message() default "CPF ou CNPJ inválido";

    String regexp() default "^(([0-9]{2}[\\.]?[0-9]{3}[\\.]?[0-9]{3}[\\/]?[0-9]{4}[-]?[0-9]{2})|([0-9]{3}[\\.]?[0-9]{3}[\\.]?[0-9]{3}[-]?[0-9]{2})|[0-9]{3}\\.?[0-9]{3}\\.?[0-9]{3}\\-?[0-9]{2})$";

    @Target({ METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER, TYPE_USE })
    @Retention(RUNTIME)
    @Documented
    @interface List {

        CPF_CNPJ[] value();
    }
}
