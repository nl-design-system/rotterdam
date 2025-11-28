package nl.rotterdam.nl_design_system.wicket.components.link;

import nl.rotterdam.nl_design_system.wicket.components.component_state.NlComponentState;
import org.apache.wicket.markup.ComponentTag;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.model.IModel;
import org.jspecify.annotations.Nullable;

import static nl.rotterdam.nl_design_system.wicket.components.component_state.Community.KERNTEAM;
import static nl.rotterdam.nl_design_system.wicket.components.component_state.EstafetteState.CANDIDATE;
import static nl.rotterdam.nl_design_system.wicket.components.component_state.WicketState.NEEDS_REFACTORING;

/**
 * @param <T> modle type
 */
@NlComponentState(wicketState = NEEDS_REFACTORING, estafetteState = CANDIDATE, htmlCssImplementedBy = KERNTEAM)
@SuppressWarnings("doclint:missing")
public abstract class RdLink<T> extends Link<T> {
    private boolean isPlaceholder = false;
    @Nullable
    private RdLinkContentType contentType;

    public RdLink(final String id) {
        super(id);
    }

    public RdLink(final String id, IModel<T> model) {
        super(id, model);
    }

    @Override
    public void onInitialize() {
        super.onInitialize();
        add(RdLinkBehavior.INSTANCE);
    }

    @Override
    public void onComponentTag(ComponentTag tag) {
        super.onComponentTag(tag);

        if (!tag.isClose()) {
            RdLinkCommonTagAttributes.addAttributes(tag, isPlaceholder, contentType);
        }
    }

    @Override
    public boolean isEnabled() {
        // Use the `isEnabled()` from `Link` to add an extra condition to disable
        // the link: when it is a placeholder.
        return super.isEnabled() && !isPlaceholder;
    }

    public void setIsPlaceholder(boolean isPlaceholder) {
        this.isPlaceholder = isPlaceholder;
    }

    public void setContentType(@Nullable RdLinkContentType contentType) {
        this.contentType = contentType;
    }
}
