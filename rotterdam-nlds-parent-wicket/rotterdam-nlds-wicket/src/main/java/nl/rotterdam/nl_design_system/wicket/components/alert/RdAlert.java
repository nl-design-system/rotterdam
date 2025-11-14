package nl.rotterdam.nl_design_system.wicket.components.alert;

import static nl.rotterdam.nl_design_system.wicket.components.component_state.Community.UTRECHT;
import static nl.rotterdam.nl_design_system.wicket.components.component_state.EstafetteState.COMMUNITY;
import static nl.rotterdam.nl_design_system.wicket.components.component_state.WicketState.UNSTABLE;

import nl.rotterdam.nl_design_system.wicket.components.component_state.NlComponentState;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.IModel;

/**
 * <a href="https://nldesignsystem.nl/alert/">NL Design System Alert component</a>.
 */
@NlComponentState(wicketState = UNSTABLE, estafetteState = COMMUNITY, htmlCssImplementedBy = UTRECHT)
public class RdAlert extends Panel {

    static final String SLOT_ID = "slot";

    /**
     * render alert with given type and tex content.
     * @param id the Wicket ID
     * @param textContent text of the alert
     * @param type the type
     */
    public RdAlert(String id, IModel<String> textContent, RdAlertType type) {
        super(id);
        add(RdAlertBehavior.alert(type));
        add(new Label(SLOT_ID, textContent));
    }
}
