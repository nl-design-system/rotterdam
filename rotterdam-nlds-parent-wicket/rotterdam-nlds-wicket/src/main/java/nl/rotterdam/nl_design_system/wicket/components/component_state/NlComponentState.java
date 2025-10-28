package nl.rotterdam.nl_design_system.wicket.components.component_state;

/**
 * Annotates the state of a component in both Wicket and NL Design Estafette Model state terms.
 */
public @interface NlComponentState {
    WicketState wicketState();

    EstafetteState estafetteState();

    Community htmlCssImplementedBy();
}
