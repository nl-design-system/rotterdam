package nl.rotterdam.nl_design_system.wicket.components.preserve_data;

import nl.rotterdam.nl_design_system.wicket.components.component_state.NlComponentState;
import org.apache.wicket.AttributeModifier;
import org.apache.wicket.markup.ComponentTag;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.model.IModel;

import static nl.rotterdam.nl_design_system.wicket.components.component_state.Community.UTRECHT;
import static nl.rotterdam.nl_design_system.wicket.components.component_state.EstafetteState.COMMUNITY;
import static nl.rotterdam.nl_design_system.wicket.components.component_state.WicketState.NEEDS_REFACTORING;
import static nl.rotterdam.nl_design_system.wicket.components.preserve_data.RdPreserveDataCss.BASE;

/**
 *  Mark the given model to be preserved and show it 'as is'.
 *  Example:
 * {@code <bdi translate="no" class="utrecht-preserve-data" wicket:id="name">Van Bergenhenegouwen</bdi>}
 */

@NlComponentState(wicketState = NEEDS_REFACTORING, estafetteState = COMMUNITY, htmlCssImplementedBy = UTRECHT)
public class RdPreserveDataLabel extends Label {

    public RdPreserveDataLabel(String id, IModel<?> model) {
        super(id, model);
        add(new RdPreserveDataBehavior());
    }

    @Override
    protected void onComponentTag(ComponentTag tag) {
        super.onComponentTag(tag);
        tag.setName("bdi");
    }

    @Override
    protected void onInitialize() {
        super.onInitialize();
        add(AttributeModifier.replace("translate", "no"));
        add(BASE.asBehavior());
    }
}
