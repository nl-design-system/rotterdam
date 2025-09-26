package nl.rotterdam.design_system.wicket.components.form_label.utrecht;

import nl.rotterdam.design_system.wicket.components.component_state.NlComponentState;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.IModel;

import static nl.rotterdam.design_system.wicket.components.component_state.EstafetteState.COMMUNITY;
import static nl.rotterdam.design_system.wicket.components.component_state.WicketState.NEEDS_REFACTORING;

/**
 * Een label voor een formulier element.
 * Wordt nog niet overal gebruikt.
 * <p/>
 */
@NlComponentState(wicketState = NEEDS_REFACTORING, estafetteState = COMMUNITY)
public class UtrechtFormLabel extends Panel {

    public static final String SLOT_ID = "slot";

    public UtrechtFormLabel(String id, IModel<?> textContent) {
        this(id, textContent, UtrechtFormLabelBehavior.INSTANCE_DEFAULT);
    }

    public UtrechtFormLabel(String id, IModel<?> textContent, UtrechtFormLabelBehavior behavior) {
        super(id);
        add(behavior);
        add(new Label(SLOT_ID, textContent));
    }

}
