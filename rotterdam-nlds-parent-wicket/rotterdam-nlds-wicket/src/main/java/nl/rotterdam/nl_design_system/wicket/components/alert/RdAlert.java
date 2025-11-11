package nl.rotterdam.nl_design_system.wicket.components.alert;

import static nl.rotterdam.nl_design_system.wicket.components.component_state.Community.UTRECHT;
import static nl.rotterdam.nl_design_system.wicket.components.component_state.EstafetteState.COMMUNITY;
import static nl.rotterdam.nl_design_system.wicket.components.component_state.WicketState.UNSTABLE;

import nl.rotterdam.nl_design_system.wicket.components.component_state.NlComponentState;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.IModel;

@NlComponentState(wicketState = UNSTABLE, estafetteState = COMMUNITY, htmlCssImplementedBy = UTRECHT)
public class RdAlert extends Panel {

    public static final String SLOT_ID = "slot";

    public RdAlert(String id, IModel<String> textContent, RdAlertType type) {
        super(id);
        add(RdAlertBehavior.alert(type));
        add(new Label(SLOT_ID, textContent));
    }
}
