
package nl.rotterdam.design_system.wicket.components.textbox.utrecht;

import nl.rotterdam.design_system.wicket.components.component_state.NlComponentState;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.model.IModel;

import static nl.rotterdam.design_system.wicket.components.component_state.EstafetteState.COMMUNITY;
import static nl.rotterdam.design_system.wicket.components.component_state.WicketState.BETA;

@NlComponentState(wicketState = BETA, estafetteState = COMMUNITY)
public class UtrechtTextbox<T> extends TextField<T> {

    public UtrechtTextbox(String id, IModel<T> model) {
        super(id, model);
    }

    @Override
    protected void onInitialize() {
        super.onInitialize();

        add(UtrechtTextboxBehavior.INSTANCE);
    }

}
