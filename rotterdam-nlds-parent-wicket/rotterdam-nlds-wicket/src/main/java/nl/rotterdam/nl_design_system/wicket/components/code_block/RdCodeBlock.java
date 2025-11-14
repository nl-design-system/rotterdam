package nl.rotterdam.nl_design_system.wicket.components.code_block;

import static nl.rotterdam.nl_design_system.wicket.components.component_state.Community.UTRECHT;
import static nl.rotterdam.nl_design_system.wicket.components.component_state.EstafetteState.COMMUNITY;
import static nl.rotterdam.nl_design_system.wicket.components.component_state.WicketState.NEEDS_REFACTORING;

import nl.rotterdam.nl_design_system.wicket.components.component_state.NlComponentState;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.IModel;

/**
 * Code block.
 * @deprecated no apps we have need this.
 */
@NlComponentState(wicketState = NEEDS_REFACTORING, estafetteState = COMMUNITY, htmlCssImplementedBy = UTRECHT)
@Deprecated(forRemoval = true)
public class RdCodeBlock extends Panel {

    private static final String SLOT_ID = "slot";

    /**
     * Create code block with given code.
     * @param id the Wicket ID
     * @param codeContent the code to show
     */
    public RdCodeBlock(String id, IModel<String> codeContent) {
        super(id);
        add(new Label(SLOT_ID, codeContent));
        add(new RdCodeBlockBehavior());
    }
}
