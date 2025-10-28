package nl.rotterdam.wicket.docs.css;

public enum DesignSystemTheme {
    RODS("rods-theme", "Gemeente Rotterdam"),
    VOORBEELD_GEMEENTE("voorbeeld-theme", "Voorbeeld Gemeente");

    private final String themeClassName;
    private final String displayLabel;

    DesignSystemTheme(String themeClassName, String displayLabel) {
        this.themeClassName = themeClassName;
        this.displayLabel = displayLabel;
    }

    public String getThemeClassName() {
        return themeClassName;
    }

    public String getDisplayName() {
        return displayLabel;
    }
}
