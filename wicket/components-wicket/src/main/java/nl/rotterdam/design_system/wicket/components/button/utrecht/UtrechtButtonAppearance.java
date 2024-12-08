package nl.rotterdam.design_system.wicket.components.button.utrecht;

public enum UtrechtButtonAppearance {
    PRIMARY_ACTION("primary-action"),
    SECONDARY_ACTION("secondary-action"),
    SUBTLE("subtle"),
    DEFAULT("");

    final String appearance;

    UtrechtButtonAppearance(String appearance) {
        this.appearance = appearance;
    }
}
