package nl.rotterdam.nl_design_system.wicket.components.text_input;

import nl.rotterdam.nl_design_system.wicket.components.component_state.NlComponentState;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.model.IModel;
import org.jspecify.annotations.Nullable;

import static nl.rotterdam.nl_design_system.wicket.components.component_state.Community.UTRECHT;
import static nl.rotterdam.nl_design_system.wicket.components.component_state.EstafetteState.COMMUNITY;
import static nl.rotterdam.nl_design_system.wicket.components.component_state.WicketState.BETA;

/**
 * <a href="https://nldesignsystem.nl/text-input/">NL Design System Text Input component</a>.
 * @param <T> the model object type.
 */
@NlComponentState(wicketState = BETA, estafetteState = COMMUNITY, htmlCssImplementedBy = UTRECHT)
public class RdTextInput<T extends @Nullable Object> extends TextField<T> {

    public RdTextInput(String id, IModel<T> model) {
        super(id, model);
    }

    @Override
    protected void onInitialize() {
        super.onInitialize();

        add(RdTextInputBehavior.INSTANCE);
    }
}
