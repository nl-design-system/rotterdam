package nl.rotterdam.nl_design_system.wicket.components.textarea;

import nl.rotterdam.nl_design_system.wicket.components.component_state.NlComponentState;
import org.apache.wicket.markup.html.form.TextArea;
import org.apache.wicket.model.IModel;
import org.jspecify.annotations.Nullable;

import static nl.rotterdam.nl_design_system.wicket.components.component_state.Community.UTRECHT;
import static nl.rotterdam.nl_design_system.wicket.components.component_state.EstafetteState.COMMUNITY;
import static nl.rotterdam.nl_design_system.wicket.components.component_state.WicketState.BETA;

/**
 * <a href="https://nldesignsystem.nl/text-area/">NL Design System Text Area component</a>.
 * @param <T> the model object type.
 */
@NlComponentState(wicketState = BETA, estafetteState = COMMUNITY, htmlCssImplementedBy = UTRECHT)
public class RdTextArea<T extends @Nullable Object> extends TextArea<T> {

    public RdTextArea(String id, IModel<T> model) {
        super(id, model);
    }

    @Override
    protected void onInitialize() {
        super.onInitialize();

        add(RdTextAreaBehavior.INSTANCE);
    }
}
