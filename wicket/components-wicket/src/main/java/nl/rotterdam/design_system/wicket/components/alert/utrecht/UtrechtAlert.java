package nl.rotterdam.design_system.wicket.components.alert.utrecht;

import nl.rotterdam.design_system.wicket.components.component_state.NlComponentState;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.IModel;

import static nl.rotterdam.design_system.wicket.components.component_state.EstafetteState.COMMUNITY;
import static nl.rotterdam.design_system.wicket.components.component_state.WicketState.UNSTABLE;


@NlComponentState(wicketState = UNSTABLE, estafetteState = COMMUNITY)
public class UtrechtAlert extends Panel {

    public static final String SLOT_ID = "slot";

    public UtrechtAlert(String id, IModel<String> textContent, UtrechtAlertType type) {
        super(id);
        add(UtrechtAlertBehavior.utrechtAlert(type));
        add(new Label(SLOT_ID, textContent));
    }
}
