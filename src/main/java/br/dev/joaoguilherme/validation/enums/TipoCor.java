package br.dev.joaoguilherme.validation.enums;

public enum TipoCor {
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
