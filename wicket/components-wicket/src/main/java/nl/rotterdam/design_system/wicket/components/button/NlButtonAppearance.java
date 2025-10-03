package nl.rotterdam.design_system.wicket.components.button;

public enum NlButtonAppearance {
    PRIMARY_ACTION("primary-action"),
    SECONDARY_ACTION("secondary-action"),
    SUBTLE("subtle"),
    DEFAULT("");

    final String appearance;

    NlButtonAppearance(String appearance) {
        this.appearance = appearance;
    }
}
