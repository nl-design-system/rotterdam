package nl.rotterdam.design_system.wicket.components.button;

import css.HTMLUtil;
import nl.rotterdam.design_system.wicket.components.component_state.NlComponentState;
import org.apache.wicket.markup.ComponentTag;
import org.apache.wicket.markup.html.form.Button;
import org.apache.wicket.model.IModel;

import static nl.rotterdam.design_system.wicket.components.component_state.Community.UTRECHT;
import static nl.rotterdam.design_system.wicket.components.component_state.EstafetteState.COMMUNITY;
import static nl.rotterdam.design_system.wicket.components.component_state.WicketState.NEEDS_REFACTORING;

@NlComponentState(wicketState = NEEDS_REFACTORING, estafetteState = COMMUNITY, htmlCssImplementedBy = UTRECHT)
public class RdButton extends Button {

    public boolean busy = false;
    public RdButtonAppearance appearance = null;
    public RdButtonHint hint = null;

    // Pressed is a nullable boolean
    public Boolean pressed = null;

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

    public void setPressed(Boolean pressed) {
        this.pressed = pressed;
    }

    @Override
    public void onInitialize() {
        super.onInitialize();

        add(RdButtonBehavior.INSTANCE);
    }

    @Override
    protected void onComponentTag(ComponentTag tag) {
        super.onComponentTag(tag);

        tag.append("class",
            HTMLUtil.className(
                "utrecht-button",
                appearance != null ? "utrecht-button--" + appearance.appearance : "",
                hint != null ? "utrecht-button--" + hint.hint : "",
                isEnabledInHierarchy() ? "" : "utrecht-button--disabled",
                pressed != null && pressed ? "utrecht-button--pressed" : "",
                this.busy ? "utrecht-button--busy" : ""
            ),
            " "
        );

        if (pressed != null) {
            tag.put("aria-pressed", pressed ? "true" : "false");
        }
    }


}
