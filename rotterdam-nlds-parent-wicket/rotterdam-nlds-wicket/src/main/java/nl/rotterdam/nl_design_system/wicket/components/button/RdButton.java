package nl.rotterdam.nl_design_system.wicket.components.button;

import static nl.rotterdam.nl_design_system.wicket.components.component_state.Community.UTRECHT;
import static nl.rotterdam.nl_design_system.wicket.components.component_state.EstafetteState.COMMUNITY;
import static nl.rotterdam.nl_design_system.wicket.components.component_state.WicketState.NEEDS_REFACTORING;

import nl.rotterdam.nl_design_system.wicket.components.component_state.NlComponentState;
import nl.rotterdam.nl_design_system.wicket.html.TokenSetBuilder;
import org.apache.wicket.markup.ComponentTag;
import org.apache.wicket.markup.html.form.Button;
import org.apache.wicket.model.IModel;

@NlComponentState(wicketState = NEEDS_REFACTORING, estafetteState = COMMUNITY, htmlCssImplementedBy = UTRECHT)
public class RdButton extends Button {

    public boolean busy = false;
    public RdButtonAppearance appearance = null;
    public RdButtonHint hint = null;

    public RdButton(String id) {
        this(id, null);
    }

    public RdButton(final String id, final IModel<String> model) {
        super(id, model);
    }

    public void setAppearance(RdButtonAppearance appearance) {
        this.appearance = appearance;
    }

    public void setHint(RdButtonHint hint) {
        this.hint = hint;
    }

    public void setBusy(boolean busy) {
        this.busy = busy;
    }

    @Override
    public void onInitialize() {
        super.onInitialize();

        add(RdButtonBehavior.INSTANCE);
    }

    @Override
    protected void onComponentTag(ComponentTag tag) {
        super.onComponentTag(tag);

        new TokenSetBuilder()
            .append("utrecht-button")
            .append(appearance != null, () -> "utrecht-button--" + appearance.appearance)
            .append(hint != null, () -> "utrecht-button--" + hint.hint)
            .append(!isEnabledInHierarchy(), "utrecht-button--disabled")
            .append(busy, "utrecht-button--busy")
            .use(classes -> tag.append("class", classes, " "));
    }
}
