package nl.rotterdam.nl_design_system.wicket.components.button;

/**
 * Sets <a href="https://developer.mozilla.org/en-US/docs/Web/CSS/Reference/Properties/appearance">appearance</a>
 * for buttons.
 *
 * <p>Details documented on
 * <a href="https://nl-design-system.github.io/utrecht/storybook/?path=/docs/css_css-button--docs">Utrecht button docs
 * </a>.</p>
 */
public enum RdButtonAppearance {

    /**
     * Check Utrecht button docs.
     */
    PRIMARY_ACTION("primary-action"),
    /**
     * Check Utrecht button docs.
     */
    SECONDARY_ACTION("secondary-action"),
    /**
     * Check Utrecht button docs.
     */
    SUBTLE("subtle"),
    /**
     * None, utrecht default button appearance.
     */
    DEFAULT("");

    final String appearance;

    RdButtonAppearance(String appearance) {
        this.appearance = appearance;
    }
}
