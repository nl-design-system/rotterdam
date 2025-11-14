package nl.rotterdam.nl_design_system.wicket.components.component_state;

/**
 * Annotates the state of a component in both Wicket and NL Design Estafette Model state terms.
 */
public @interface NlComponentState {
    /**
     * What is the state / quality of the Wicket implementation?
     */
    WicketState wicketState();

    /**
     * What is the NL Design System Estafette state?
     */
    EstafetteState estafetteState();

    /**
     * Who is in the lead for the component HTML/CSS?
     */
    Community htmlCssImplementedBy();
}
