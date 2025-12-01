package nl.rotterdam.nl_design_system.docs.wicket.css;

import nl.rotterdam.nl_design_system.rotterdam_css.wicket.NldsRotterdamDesignSystemThemeBehavior;
import org.apache.wicket.behavior.Behavior;

public enum DesignSystemTheme {
    RODS("rods-theme", "Gemeente Rotterdam", NldsRotterdamDesignSystemThemeBehavior.INSTANCE),
    VOORBEELD_GEMEENTE("voorbeeld-theme", "Voorbeeld Gemeente", NldsVoorbeeldDesignSystemThemeBehavior.INSTANCE);

    private final String themeClassName;
    private final String displayLabel;
    private final Behavior behavior;

    DesignSystemTheme(String themeClassName, String displayLabel, Behavior behavior) {
        this.themeClassName = themeClassName;
        this.displayLabel = displayLabel;
        this.behavior = behavior;
    }

    public String getThemeClassName() {
        return themeClassName;
    }

    public String getDisplayName() {
        return displayLabel;
    }

    public Behavior getBehavior() {
        return behavior;
    }
}
