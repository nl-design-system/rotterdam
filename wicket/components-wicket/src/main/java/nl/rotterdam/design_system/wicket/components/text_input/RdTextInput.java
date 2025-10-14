
package nl.rotterdam.design_system.wicket.components.text_input;

import nl.rotterdam.design_system.wicket.components.component_state.NlComponentState;
import nl.rotterdam.design_system.wicket.components.read_only.ReadOnlyModelHolder;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;

import static nl.rotterdam.design_system.wicket.components.component_state.Community.UTRECHT;
import static nl.rotterdam.design_system.wicket.components.component_state.EstafetteState.COMMUNITY;
import static nl.rotterdam.design_system.wicket.components.component_state.WicketState.BETA;


@NlComponentState(wicketState = BETA, estafetteState = COMMUNITY, htmlCssImplementedBy = UTRECHT)
public class RdTextInput<T> extends TextField<T> implements ReadOnlyModelHolder {

    private IModel<Boolean> readOnlyModel = Model.of(false);

    public RdTextInput(String id, IModel<T> model) {
        super(id, model);
    }

    @Override
    protected void onInitialize() {
        super.onInitialize();

        add(RdTextInputBehavior.INSTANCE);
    }

    public void setReadOnlyModel(IModel<Boolean> readOnlyModel) {
        this.readOnlyModel = readOnlyModel;
    }

    @Override
    public IModel<Boolean> getReadOnlyModel() {
        return readOnlyModel;
    }
}
