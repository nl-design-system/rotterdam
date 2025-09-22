package nl.rotterdam.design_system.wicket.components.component_state;

/**
 * Defines the state of an NLDS component, to make it clear for developers if it is ready to be used.
 */
public enum State {
    
    NEEDS_REFACTORING("Needs refactoring, do not use as API changes are expected"),
    UNSTABLE("Has been looked at, but needs tests, revision. Use with caution"),
    BETA("Has been verified, has tests and is reviewed by a peer"),
    STABLE("Has been used in production for a while, is considered stable");

    @SuppressWarnings({"FieldCanBeLocal", "unused"})
    private final String explanation;

    State(String explanation) {
        this.explanation = explanation;
    }
}
