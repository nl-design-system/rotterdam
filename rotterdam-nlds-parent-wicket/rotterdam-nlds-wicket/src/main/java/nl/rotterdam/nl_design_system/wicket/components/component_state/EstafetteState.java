package nl.rotterdam.nl_design_system.wicket.components.component_state;

/**
 * State as defined in the <a href="https://nldesignsystem.nl/handboek/estafettemodel/">Design System documentation</a>.
 */
public enum EstafetteState {
    /**
     * Not in <a href="https://nldesignsystem.nl/componenten/">Componenten</a>.
     */
    NOT_LISTED,
    /**
     * Listed, but no implementation in community state yet.
     */
    HELP_WANTED,
    /**
     * Is a community component.
     */
    COMMUNITY,
    /**
     * Is a release candidate.
     */
    CANDIDATE,
    /**
     * Is released by kernteam.
     */
    HALL_OF_FAME,
}
