package nl.rotterdam.nl_design_system.wicket.components.page_layout.utrecht;

import static nl.rotterdam.nl_design_system.wicket.components.component_state.Community.UTRECHT;
import static nl.rotterdam.nl_design_system.wicket.components.component_state.EstafetteState.HELP_WANTED;
import static nl.rotterdam.nl_design_system.wicket.components.component_state.WicketState.NEEDS_REFACTORING;

import nl.rotterdam.nl_design_system.wicket.components.component_state.NlComponentState;
import org.apache.wicket.markup.head.IHeaderResponse;
import org.apache.wicket.markup.html.panel.Panel;

@NlComponentState(wicketState = NEEDS_REFACTORING, estafetteState = HELP_WANTED, htmlCssImplementedBy = UTRECHT)
public class UtrechtPageLayout extends Panel {

    public static final String SLOT_ID = "pageLayoutSlot";

    public UtrechtPageLayout(String id) {
        super(id);
    }

    @Override
    public void renderHead(IHeaderResponse response) {
        super.renderHead(response);
        add(new UtrechtPageLayoutBehavior());
    }
}
