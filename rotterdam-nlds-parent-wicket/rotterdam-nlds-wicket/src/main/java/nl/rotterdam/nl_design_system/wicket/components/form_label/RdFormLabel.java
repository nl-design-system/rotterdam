package nl.rotterdam.nl_design_system.wicket.components.form_label;

import static nl.rotterdam.nl_design_system.wicket.components.component_state.Community.UTRECHT;
import static nl.rotterdam.nl_design_system.wicket.components.component_state.EstafetteState.COMMUNITY;
import static nl.rotterdam.nl_design_system.wicket.components.component_state.WicketState.NEEDS_REFACTORING;

import nl.rotterdam.nl_design_system.wicket.components.component_state.NlComponentState;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.IModel;

/**
 * Een label voor een formulier element.
 * Wordt nog niet overal gebruikt.
 * <p/>
 */
@NlComponentState(wicketState = NEEDS_REFACTORING, estafetteState = COMMUNITY, htmlCssImplementedBy = UTRECHT)
public class RdFormLabel extends Panel {

    public static final String SLOT_ID = "slot";

    public RdFormLabel(String id, IModel<?> textContent) {
        this(id, textContent, RdFormLabelBehavior.INSTANCE_DEFAULT);
    }

    public RdFormLabel(String id, IModel<?> textContent, RdFormLabelBehavior behavior) {
        super(id);
        add(behavior);
        add(new Label(SLOT_ID, textContent));
    }
}
