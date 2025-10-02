package nl.rotterdam.design_system.wicket.components.separator.utrecht;

import nl.rotterdam.design_system.wicket.components.component_state.NlComponentState;
import org.apache.wicket.markup.ComponentTag;
import org.apache.wicket.markup.html.WebComponent;

import static nl.rotterdam.design_system.wicket.components.component_state.Community.UTRECHT;
import static nl.rotterdam.design_system.wicket.components.component_state.EstafetteState.COMMUNITY;
import static nl.rotterdam.design_system.wicket.components.component_state.WicketState.NEEDS_REFACTORING;
import static nl.rotterdam.design_system.wicket.components.component_tag.ComponentTagUtils.appendCssClassesTo;

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
        appendCssClassesTo(tag, "utrecht-separator");
    }
}
