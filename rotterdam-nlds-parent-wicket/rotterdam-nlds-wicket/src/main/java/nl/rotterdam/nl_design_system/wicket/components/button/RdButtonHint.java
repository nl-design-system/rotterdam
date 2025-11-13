package nl.rotterdam.nl_design_system.wicket.components.button;

/**
 * Button hint zoals gedefinieerd door Utrecht.
 * <a href="https://nl-design-system.github.io/utrecht/storybook/?path=/docs/css_css-button--docs">Documentatie hier</a>.
 * TODO: vraag na waarom appearance en hint op deze manier uit elkaar getrokken zijn.
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
