package nl.rotterdam.nl_design_system.wicket.components.separator.utrecht;

import static nl.rotterdam.nl_design_system.wicket.components.component_state.Community.UTRECHT;
import static nl.rotterdam.nl_design_system.wicket.components.component_state.EstafetteState.COMMUNITY;
import static nl.rotterdam.nl_design_system.wicket.components.component_state.WicketState.NEEDS_REFACTORING;

import nl.rotterdam.nl_design_system.wicket.components.component_state.NlComponentState;
import org.apache.wicket.markup.ComponentTag;
import org.apache.wicket.markup.html.WebComponent;

@NlComponentState(wicketState = NEEDS_REFACTORING, estafetteState = COMMUNITY, htmlCssImplementedBy = UTRECHT)
public class UtrechtSeparator extends WebComponent {

    public UtrechtSeparator(String id) {
        super(id);
        add(new UtrechtSeparatorBehavior());
    }

    @Override
    protected void onComponentTag(ComponentTag tag) {
        super.onComponentTag(tag);
        tag.setName("hr");
        tag.append("class", "utrecht-separator", " ");
    }
}
