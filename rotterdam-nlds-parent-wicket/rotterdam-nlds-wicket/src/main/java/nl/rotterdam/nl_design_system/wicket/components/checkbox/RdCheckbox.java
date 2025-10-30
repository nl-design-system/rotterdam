package nl.rotterdam.nl_design_system.wicket.components.checkbox;

import static nl.rotterdam.nl_design_system.wicket.components.component_state.Community.UTRECHT;
import static nl.rotterdam.nl_design_system.wicket.components.component_state.EstafetteState.COMMUNITY;
import static nl.rotterdam.nl_design_system.wicket.components.component_state.WicketState.BETA;

import nl.rotterdam.nl_design_system.wicket.components.component_state.NlComponentState;
import org.apache.wicket.markup.html.form.CheckBox;
import org.apache.wicket.model.IModel;

/**
 * Implementation of <a href="https://nldesignsystem.nl/checkbox/">NL Design System Checkbox</a>.
 *
 * <p>Based on <a href="https://nl-design-system.github.io/utrecht/storybook/?path=/docs/css_css-checkbox--docs">
 *     implementation of Utrecht
 *  </a></p>
 */
@NlComponentState(wicketState = BETA, estafetteState = COMMUNITY, htmlCssImplementedBy = UTRECHT)
public class RdCheckbox extends CheckBox {

    public RdCheckbox(String id, IModel<Boolean> model) {
        super(id, model);
        setOutputMarkupId(true);
    }

    @Override
    protected void onInitialize() {
        super.onInitialize();
        add(RdCheckboxBehavior.INSTANCE);
    }
}
