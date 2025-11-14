package nl.rotterdam.nl_design_system.wicket.components.component_state;

/**
 * Defines the state of an NL Design System component, to make it clear for developers if it is ready to be used.
 */
public enum WicketState {
    /**
     * Needs refactoring.
     */
    NEEDS_REFACTORING("Needs refactoring, do not use as API changes are expected"),
    /**
     * Not stable.
     */
    UNSTABLE("Has been looked at, but needs tests, revision. Use with caution"),
    /**
     * Expect only minor changes.
     */
    BETA("Has been verified, has tests and is reviewed by a peer"),
    /**
     * Stable. We try to remain backwads compatible.
     */
    STABLE("Has been used in production for a while, at least two teams use it and are satisfied.");

    @SuppressWarnings({ "FieldCanBeLocal", "unused" })
    private final String explanation;

    WicketState(String explanation) {
        this.explanation = explanation;
    }
}
