package nl.rotterdam.nl_design_system.wicket.components.button;

import static nl.rotterdam.nl_design_system.wicket.components.component_state.Community.UTRECHT;
import static nl.rotterdam.nl_design_system.wicket.components.component_state.EstafetteState.COMMUNITY;
import static nl.rotterdam.nl_design_system.wicket.components.component_state.WicketState.NEEDS_REFACTORING;

import nl.rotterdam.nl_design_system.wicket.components.component_state.NlComponentState;
import org.apache.wicket.ajax.markup.html.form.AjaxButton;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.model.IModel;

@NlComponentState(wicketState = NEEDS_REFACTORING, estafetteState = COMMUNITY, htmlCssImplementedBy = UTRECHT)
public class RdAjaxButton extends AjaxButton {

    public RdAjaxButton(String id) {
        super(id);
    }

    public RdAjaxButton(String id, IModel<String> model) {
        super(id, model);
    }

    public RdAjaxButton(String id, Form<?> form) {
        super(id, form);
    }

    public RdAjaxButton(String id, IModel<String> model, Form<?> form) {
        super(id, model, form);
    }

    @Override
    protected void onInitialize() {
        super.onInitialize();
        add(RdButtonBehavior.INSTANCE);
    }
}
