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
 */
@NlComponentState(wicketState = NEEDS_REFACTORING, estafetteState = COMMUNITY, htmlCssImplementedBy = UTRECHT)
public class RdCodeBlock extends Panel {

    private static final String CODE_ID = "code";

    private final Label codeComponent;

    /**
     * Create code block with given code.
     * @param id the Wicket ID
     * @param codeModel the code to show
     */
    public RdCodeBlock(String id, IModel<String> codeModel) {
        super(id);
        codeComponent = newCodeLabel(CODE_ID, codeModel);
    }

    @Override
    protected void onInitialize() {
        super.onInitialize();

        add(codeComponent);
        add(new RdCodeBlockBehavior());
    }

    public Label getCodeComponent() {
        return codeComponent;
    }

    private Label newCodeLabel(String wicketId, IModel<String> codeModel) {
        return new Label(wicketId, codeModel);
    }
}
