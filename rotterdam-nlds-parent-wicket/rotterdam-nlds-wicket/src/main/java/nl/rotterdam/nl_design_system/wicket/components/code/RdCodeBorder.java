package nl.rotterdam.nl_design_system.wicket.components.code;

import nl.rotterdam.nl_design_system.wicket.components.component_state.NlComponentState;
import org.apache.wicket.markup.html.border.Border;
import org.apache.wicket.model.IModel;
import org.jspecify.annotations.Nullable;

import static nl.rotterdam.nl_design_system.wicket.components.component_state.Community.KERNTEAM;
import static nl.rotterdam.nl_design_system.wicket.components.component_state.EstafetteState.CANDIDATE;
import static nl.rotterdam.nl_design_system.wicket.components.component_state.WicketState.BETA;

 /**
 * Border component for rendering <a href="https://nl-design-system.nl/code">NL Design System code</a>.
 *
 */@NlComponentState(wicketState = BETA, estafetteState = CANDIDATE, htmlCssImplementedBy = KERNTEAM)
public class RdCodeBorder extends Border {

    /**
     * Creates a new {@link RdCodeBorder} with the given component id.
     *
     * @param id the Wicket component id
     */
    public RdCodeBorder(String id) {
        super(id);
    }

    /**
     * Creates a new {@link RdCodeBorder} with the given component id and model.
     *
     * @param id    the Wicket component id
     * @param model the model providing the content or value for this border; may be {@code null}
     */
    public RdCodeBorder(String id, @Nullable IModel<?> model) {
        super(id, model);
    }

    @Override
    protected void onInitialize() {
        super.onInitialize();
        
        add(RdCodeBehavior.INSTANCE);
    }
}
