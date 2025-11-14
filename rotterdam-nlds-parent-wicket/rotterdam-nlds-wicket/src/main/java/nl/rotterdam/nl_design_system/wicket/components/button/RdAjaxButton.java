package nl.rotterdam.nl_design_system.wicket.components.button;

import nl.rotterdam.nl_design_system.wicket.components.component_state.NlComponentState;
import nl.rotterdam.nl_design_system.wicket.html.TokenSetBuilder;
import org.apache.wicket.ajax.markup.html.form.AjaxButton;
import org.apache.wicket.markup.ComponentTag;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.model.IModel;
import org.jspecify.annotations.Nullable;

import static nl.rotterdam.nl_design_system.wicket.components.component_state.Community.UTRECHT;
import static nl.rotterdam.nl_design_system.wicket.components.component_state.EstafetteState.COMMUNITY;
import static nl.rotterdam.nl_design_system.wicket.components.component_state.WicketState.NEEDS_REFACTORING;

/**
 * Ajax Button with NL Design System appearance (primary/secondary) and hint (such as danger and ready).
 *
 * @see RdButton for non-ajax usecase.
 */
@NlComponentState(wicketState = NEEDS_REFACTORING, estafetteState = COMMUNITY, htmlCssImplementedBy = UTRECHT)
public class RdAjaxButton extends AjaxButton {

    private boolean busy = false;
    private @Nullable RdButtonAppearance appearance = null;
    private @Nullable RdButtonHint hint = null;

    /**
     * New instance with label to be added later.
     */
    public RdAjaxButton(String id) {
        super(id);
    }

    /**
     * New instance with label specified.
     */
    public RdAjaxButton(String id, IModel<String> model) {
        super(id, model);
    }

    /**
     * New ajax button with form it belongs to.
     */
    public RdAjaxButton(String id, Form<?> form) {
        super(id, form);
    }

    /**
     * New ajax button with label and form it belongs to.
     */
    public RdAjaxButton(String id, IModel<String> model, Form<?> form) {
        super(id, model, form);
    }

    /**
     * Sets the {@link RdButtonAppearance}.
     */
    public void setAppearance(RdButtonAppearance appearance) {
        this.appearance = appearance;
    }

    /**
     * Sets the {@link RdButtonHint}.
     */
    public void setHint(RdButtonHint hint) {
        this.hint = hint;
    }

    /**
     * Sets whether action behind this button is being executed now.
     * @param busy true if currently busy
     * @deprecated not used as of now
     * TODO: determine what it means, if we want to keep it.
     */
    @Deprecated(forRemoval = true)
    public void setBusy(boolean busy) {
        this.busy = busy;
    }

    @Override
    protected void onInitialize() {
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
