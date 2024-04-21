package br.dev.joaoguilherme.validation.annotation;

import br.dev.joaoguilherme.validation.validators.CoordenadaValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.Documented;
import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.ElementType.TYPE_USE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Repeatable(Coordenada.List.class)
@Target({METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER, TYPE_USE})
@Retention(RUNTIME)
@Constraint(validatedBy = CoordenadaValidator.class)
public @interface Coordenada {

    String message() default "Coordenada inválida";

    TipoCoordenada tipo() default TipoCoordenada.DD_COORDINATE_REGEX;

    enum TipoCoordenada {
        DD_COORDINATE_REGEX("^(-?\\d+\\.\\d+)(\\s*,\\s*)?(-?\\d+\\.\\d+)$") {
            @Override
            public boolean isValid(String coordenada) {
                try {
                    String[] parts = coordenada.split(",");
                    if (parts.length != 2) {
                        return false;
                    }

                    double latitude = Double.parseDouble(parts[0].trim());
                    double longitude = Double.parseDouble(parts[1].trim());
                    return !(latitude < -90) && !(latitude > 90) && !(longitude < -180) && !(longitude > 180);
                } catch (NumberFormatException e) {
                    return false;
                }
            }
        },
        DMS_COORDINATE_REGEX("^(\\d{1,3})°(\\d{1,2})'(\\d{1,2}(\\.\\d+)?)?\"?([NSns])(\\s*,\\s*)?(\\d{1,3})°(\\d{1,2})'(\\d{1,2}(\\.\\d+)?)?\"?([WEwe])$") {
            boolean isInvalidLatitude(int degrees, int minutes, double seconds, String hemisphere) {
                return degrees < 0 || degrees > 90 || minutes < 0 || minutes >= 60 || seconds < 0 || seconds >= 60 ||
                        (!hemisphere.equalsIgnoreCase("N") && !hemisphere.equalsIgnoreCase("S"));
            }

            boolean isInvalidLongitude(int degrees, int minutes, double seconds, String hemisphere) {
                return degrees < 0 || degrees > 180 || minutes < 0 || minutes >= 60 || seconds < 0 || seconds >= 60 ||
                        (!hemisphere.equalsIgnoreCase("E") && !hemisphere.equalsIgnoreCase("W"));
            }

            @Override
            public boolean isValid(String coordenada) {
                try {
                    String[] dmsParts = coordenada.split("[°',]");
                    if (dmsParts.length > 6) {
                        return false;
                    }

                    int degreesLatitude = Integer.parseInt(dmsParts[0].trim());
                    int minutesLatitude = Integer.parseInt(dmsParts[1].trim());
                    String[] secondPartsLatitude = dmsParts[2].split("\"");
                    double secondsLatitude = secondPartsLatitude.length > 1 ? Double.parseDouble(secondPartsLatitude[0].trim()) : 0.0;
                    String hemisphereLatitude = secondPartsLatitude.length > 1 ? secondPartsLatitude[1] : dmsParts[2];

                    int degreesLongitude = Integer.parseInt(dmsParts[3].trim());
                    int minutesLongitude = Integer.parseInt(dmsParts[4].trim());
                    String[] secondPartsLongitude = dmsParts[5].split("\"");
                    double secondsLongitude = secondPartsLongitude.length > 1 ? Double.parseDouble(secondPartsLongitude[0].trim()) : 0.0;
                    String hemisphereLongitude = secondPartsLongitude.length > 1 ? secondPartsLongitude[1] : dmsParts[5];

                    return !isInvalidLatitude(degreesLatitude, minutesLatitude, secondsLatitude, hemisphereLatitude) &&
                            !isInvalidLongitude(degreesLongitude, minutesLongitude, secondsLongitude, hemisphereLongitude);
                } catch (NumberFormatException e) {
                    return false;
                }
            }
        },
        MGRS_COORDINATE_REGEX("^\\d{1,2}[^IO]{3}(\\d{10}|\\d{8}|\\d{6}|\\d{4}|\\d{2})$") {
            @Override
            public boolean isValid(String coordenada) {
                return true;
            }
        };
        private final String regex;

        TipoCoordenada(String regex) {
            this.regex = regex;
        }

        public String getRegex() {
            return regex;
        }

        public abstract boolean isValid(String coordenada);
    }

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    @Target({METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER, TYPE_USE})
    @Retention(RUNTIME)
    @Documented
    @interface List {

        Coordenada[] value();
    }
}
