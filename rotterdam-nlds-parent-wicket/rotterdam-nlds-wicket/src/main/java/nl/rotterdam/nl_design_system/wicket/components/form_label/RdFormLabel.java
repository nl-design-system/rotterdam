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
 * Wordt niet overal gebruikt, vaak alleen het behavior
 */
@Deprecated(forRemoval = true)
@NlComponentState(wicketState = NEEDS_REFACTORING, estafetteState = COMMUNITY, htmlCssImplementedBy = UTRECHT)
public class RdFormLabel extends Panel {

    private static final String SLOT_ID = "slot";

    /**
     * Constructor with textContent
     * @param id Wicket Id
     * @param textContent text to be rendered
     */
    public RdFormLabel(String id, IModel<?> textContent) {
        this(id, textContent, RdFormLabelBehavior.INSTANCE_DEFAULT);
    }

    /**
     * Constructor with textContent
     * @param id Wicket Id
     * @param textContent text to be rendered
     * @param formLabelBehavior form field type specific behavior
     */
    public RdFormLabel(String id, IModel<?> textContent, RdFormLabelBehavior formLabelBehavior) {
        super(id);
        add(formLabelBehavior);
        add(new Label(SLOT_ID, textContent));
    }
}
