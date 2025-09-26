package nl.rotterdam.design_system.wicket.components.page_layout.utrecht;

import nl.rotterdam.design_system.wicket.components.component_state.NlComponentState;
import org.apache.wicket.markup.html.border.Border;

import static nl.rotterdam.design_system.wicket.components.component_state.EstafetteState.HELP_WANTED;
import static nl.rotterdam.design_system.wicket.components.component_state.WicketState.NEEDS_REFACTORING;


@NlComponentState(wicketState = NEEDS_REFACTORING, estafetteState = HELP_WANTED)
public class UtrechtPageLayoutBorder extends Border {

    public UtrechtPageLayoutBorder(String id) {
        super(id);
        add(new UtrechtPageLayoutBehavior());
    }
}
