package nl.rotterdam.nl_design_system.wicket.components.button;

/**
 * Button hint as defined by Utrecht.
 * <a href="https://nl-design-system.github.io/utrecht/storybook/?path=/docs/css_css-button--docs">Documentation</a>.
 * TODO: ask why appearance and hint are separated this way.
 */
public enum RdButtonHint {
    /**
     * Gevaarlijke actie, zoals verwijderen.
     */
    DANGER("danger"),

    /**
     * Belangrijke actie, zoals het indienen van een aanvraag bij het einde van een wizard.
     */
    WARNING("warning"),

    /**
     * Onbekend
     * TODO vraag op Slack wat functionele betekenis is.
     */
    READY("ready");

    final String hint;

    RdButtonHint(String hint) {
        this.hint = hint;
    }
}
