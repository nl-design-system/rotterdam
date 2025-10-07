package nl.rotterdam.design_system.wicket.components.button;

public enum RdButtonAppearance {
    PRIMARY_ACTION("primary-action"),
    SECONDARY_ACTION("secondary-action"),
    SUBTLE("subtle"),
    DEFAULT("");

    final String appearance;

    RdButtonAppearance(String appearance) {
        this.appearance = appearance;
    }
}
