package nl.rotterdam.design_system.wicket.components.code_block.utrecht;

import nl.rotterdam.design_system.wicket.components.component_state.NlComponentState;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.IModel;

import static nl.rotterdam.design_system.wicket.components.component_state.Community.UTRECHT;
import static nl.rotterdam.design_system.wicket.components.component_state.EstafetteState.COMMUNITY;
import static nl.rotterdam.design_system.wicket.components.component_state.WicketState.BETA;
import static nl.rotterdam.design_system.wicket.components.component_state.WicketState.NEEDS_REFACTORING;


@NlComponentState(wicketState = NEEDS_REFACTORING, estafetteState = COMMUNITY, htmlCssImplementedBy = UTRECHT)
public class UtrechtCodeBlock extends Panel {

    public static final String SLOT_ID = "slot";

    public UtrechtCodeBlock(String id, IModel<String> textContent) {
        super(id);
        add(new Label(SLOT_ID, textContent));
        add(new UtrechtCodeBlockBehavior());
    }
}
