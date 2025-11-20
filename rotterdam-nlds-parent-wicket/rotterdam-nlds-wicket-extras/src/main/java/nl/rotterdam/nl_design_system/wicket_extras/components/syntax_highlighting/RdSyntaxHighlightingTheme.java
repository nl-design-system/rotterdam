package nl.rotterdam.nl_design_system.wicket_extras.components.syntax_highlighting;

import java.util.Locale;

public enum RdSyntaxHighlightingTheme {
    COY,
    DARK,
    FUNKY,
    OKAIDIA,
    SOLARIZEDLIGHT,
    TOMORROW,
    TWILIGHT;

    private final String suffix = '-' + name().toLowerCase(Locale.ROOT);

    public String getSuffix() {
        return suffix;
    }
}
