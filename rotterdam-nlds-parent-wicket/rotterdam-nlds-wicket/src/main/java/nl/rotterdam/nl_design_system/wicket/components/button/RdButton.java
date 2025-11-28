package nl.rotterdam.nl_design_system.wicket.components.button;

import nl.rotterdam.nl_design_system.wicket.components.component_state.NlComponentState;
import nl.rotterdam.nl_design_system.wicket.html.TokenSetBuilder;
import org.apache.wicket.markup.ComponentTag;
import org.apache.wicket.markup.html.form.Button;
import org.apache.wicket.model.IModel;
import org.jspecify.annotations.Nullable;

import static nl.rotterdam.nl_design_system.wicket.components.component_state.Community.UTRECHT;
import static nl.rotterdam.nl_design_system.wicket.components.component_state.EstafetteState.COMMUNITY;
import static nl.rotterdam.nl_design_system.wicket.components.component_state.WicketState.NEEDS_REFACTORING;

/**
 * <a  href="https://nldesignsystem.nl/button/">NL Design System button component</a>.
 * @see RdAjaxButton
 */
@NlComponentState(wicketState = NEEDS_REFACTORING, estafetteState = COMMUNITY, htmlCssImplementedBy = UTRECHT)
public class RdButton extends Button {

    private boolean busy = false;
    private @Nullable RdButtonAppearance appearance = null;
    private @Nullable RdButtonHint hint = null;

    /**
     * Create instance without label; label to be set separately in markup or with {@link #setModel(IModel)}.
     * @param id the Wicket ID
     */
    public RdButton(String id) {
        this(id, null);
    }

    /**
     * Create instance with label.
     * @param id the Wicket ID
     * @param model the label
     */
    public RdButton(final String id, @Nullable final IModel<String> model) {
        super(id, model);
    }

    /**
     * Sets {@link RdButtonAppearance}.
     * @param appearance new appearance
     */
    public void setAppearance(@Nullable RdButtonAppearance appearance) {
        this.appearance = appearance;
    }

    /**
     * Sets {@link RdButtonHint}.
     * @param hint new hint
     */
    public void setHint(@Nullable RdButtonHint hint) {
        this.hint = hint;
    }

    /**
     * Markeer dat de actie voor deze knop bezig is.
     * @param busy true als de actie nu bezig is
     */
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
            .append(appearance != null, () -> "utrecht-button--" + appearance.appearance)
            .append(hint != null, () -> "utrecht-button--" + hint.hint)
            .append(!isEnabledInHierarchy(), "utrecht-button--disabled")
            .append(busy, "utrecht-button--busy")
            .use(classes -> tag.append("class", classes, " "));
    }
}
