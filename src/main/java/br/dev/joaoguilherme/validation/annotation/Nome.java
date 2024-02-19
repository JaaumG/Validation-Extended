package br.dev.joaoguilherme.validation.annotation;

import br.dev.joaoguilherme.validation.NomeValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = NomeValidator.class)
public @interface Nome {
    String message() default "Nome inválido";
    String regexp() default "^(?:[\\p{Lu}&&[\\p{IsLatin}]])(?:(?:')?(?:[\\p{Ll}&&[\\p{IsLatin}]]))+(?:\\-(?:[\\p{Lu}&&[\\p{IsLatin}]])(?:(?:')?(?:[\\p{Ll}&&[\\p{IsLatin}]]))+)*(?: (?:(?:e|y|de(?:(?: la| las| lo| los))?|do|dos|da|das|del|van|von|bin|le) )?(?:(?:(?:d'|D'|O'|Mc|Mac|al\\-))?(?:[\\p{Lu}&&[\\p{IsLatin}]])(?:(?:')?(?:[\\p{Ll}&&[\\p{IsLatin}]]))+|(?:[\\p{Lu}&&[\\p{IsLatin}]])(?:(?:')?(?:[\\p{Ll}&&[\\p{IsLatin}]]))+(?:\\-(?:[\\p{Lu}&&[\\p{IsLatin}]])(?:(?:')?(?:[\\p{Ll}&&[\\p{IsLatin}]]))+)*))+(?: (?:Jr\\.|II|III|IV))?$";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
