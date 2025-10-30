package nl.rotterdam.nl_design_system.wicket.components.code_block.utrecht;

import static nl.rotterdam.nl_design_system.wicket.components.component_state.Community.UTRECHT;
import static nl.rotterdam.nl_design_system.wicket.components.component_state.EstafetteState.COMMUNITY;
import static nl.rotterdam.nl_design_system.wicket.components.component_state.WicketState.NEEDS_REFACTORING;

import nl.rotterdam.nl_design_system.wicket.components.component_state.NlComponentState;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.IModel;

@NlComponentState(wicketState = NEEDS_REFACTORING, estafetteState = COMMUNITY, htmlCssImplementedBy = UTRECHT)
public class UtrechtCodeBlock extends Panel {

    public static final String SLOT_ID = "slot";

    public UtrechtCodeBlock(String id, IModel<String> textContent) {
        super(id);
        add(new Label(SLOT_ID, textContent));
        add(new UtrechtCodeBlockBehavior());
    }
}
