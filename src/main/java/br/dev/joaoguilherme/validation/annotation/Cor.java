package br.dev.joaoguilherme.validation.annotation;

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


    enum TipoCor {
        HEX("^#([0-9a-fA-F]{3}|[0-9a-fA-F]{6}|[0-9a-fA-F]{8})$"),
        RGB("^rgb\\((\\d{1,3}),\\s*(\\d{1,3}),\\s*(\\d{1,3})\\)$"),
        HSL("^hsl\\((\\d{1,3}),\\s*(\\d{1,3})%,\\s*(\\d{1,3})%\\)$"),
        HSV("^hsv\\((\\d{1,3}),\\s*(\\d{1,3})%,\\s*(\\d{1,3})%\\)$"),
        CMYK("^cmyk\\((\\d{1,3})%,\\s*(\\d{1,3})%,\\s*(\\d{1,3})%,\\s*(\\d{1,3})%\\)$"),
        RGBA("^rgba\\((\\d{1,3}),\\s*(\\d{1,3}),\\s*(\\d{1,3}),\\s*(0|1|0?\\.\\d+)\\)$"),
        HSLA("^hsla\\((\\d{1,3}),\\s*(\\d{1,3})%,\\s*(\\d{1,3})%,\\s*(0|1|0?\\.\\d+)\\)$"),
        HSVA("^hsva\\((\\d{1,3}),\\s*(\\d{1,3})%,\\s*(\\d{1,3})%,\\s*(0|1|0?\\.\\d+)\\)$"),
        CMYKA("^cmyka\\((\\d{1,3})%,\\s*(\\d{1,3})%,\\s*(\\d{1,3})%,\\s*(\\d{1,3})%,\\s*(0|1|0?\\.\\d+)\\)$");

        private final String regex;

        TipoCor(String regex) {
            this.regex = regex;
        }

        public String getRegex() {
            return regex;
        }
    }

    @Target({METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER, TYPE_USE})
    @Retention(RUNTIME)
    @Documented
    @interface List {

        Cor[] value();
    }
}
