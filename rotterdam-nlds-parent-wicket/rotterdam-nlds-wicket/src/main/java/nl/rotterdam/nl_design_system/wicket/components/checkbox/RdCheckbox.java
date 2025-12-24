package nl.rotterdam.nl_design_system.wicket.components.checkbox;

import static nl.rotterdam.nl_design_system.wicket.components.component_state.Community.UTRECHT;
import static nl.rotterdam.nl_design_system.wicket.components.component_state.EstafetteState.COMMUNITY;
import static nl.rotterdam.nl_design_system.wicket.components.component_state.WicketState.BETA;

import nl.rotterdam.nl_design_system.wicket.components.component_state.NlComponentState;
import org.apache.wicket.markup.html.form.CheckBox;
import org.apache.wicket.model.IModel;

/**
 * <p>
 * A <a href="https://nldesignsystem.nl/checkbox/">Checkbox</a>.
 * </p>
 * <p>
 * This is a subclass of {@link CheckBox}. If you want to convert a {@link org.apache.wicket.markup.html.form.Check} or
 * {@link org.apache.wicket.markup.html.form.CheckGroupSelector} to an NLDS Checkbox, see {@link RdCheckboxBehavior}.
 * </p>
 *
 * <p>Based on <a href="https://nl-design-system.github.io/utrecht/storybook/?path=/docs/css_css-checkbox--docs">
 *     implementation of Utrecht
 *  </a>.</p>
 */
@NlComponentState(wicketState = BETA, estafetteState = COMMUNITY, htmlCssImplementedBy = UTRECHT)
public class RdCheckbox extends CheckBox {

    /**
     * Create checkbox with given read and write model.
     * @param id the Wicket ID
     * @param model writable model
     */
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
