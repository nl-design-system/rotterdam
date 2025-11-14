package nl.rotterdam.nl_design_system.wicket.components.link;

import nl.rotterdam.nl_design_system.wicket.components.component_state.NlComponentState;
import org.apache.wicket.markup.ComponentTag;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.model.IModel;
import org.apache.wicket.request.component.IRequestablePage;
import org.jspecify.annotations.Nullable;

import static nl.rotterdam.nl_design_system.wicket.components.component_state.Community.UTRECHT;
import static nl.rotterdam.nl_design_system.wicket.components.component_state.EstafetteState.COMMUNITY;
import static nl.rotterdam.nl_design_system.wicket.components.component_state.WicketState.NEEDS_REFACTORING;

/**
 * @deprecated overlaps with {@link RdBookmarkableLink}, merge or remove
 * @param <T> modle type
 * @param <C> page class type
 */
@Deprecated(forRemoval = true)
@NlComponentState(wicketState = NEEDS_REFACTORING, estafetteState = COMMUNITY, htmlCssImplementedBy = UTRECHT)
@SuppressWarnings("doclint:missing")
public class RdLink<T, C extends IRequestablePage> extends Link<T> {

    private @Nullable Class<C> webPage = null;
    private boolean placeholder = false;

    public RdLink(final String id) {
        super(id);
    }

    public RdLink(final String id, IModel<T> model) {
        super(id, model);
    }

    public RdLink(final String id, IModel<T> model, Class<C> webPage) {
        super(id, model);
        this.webPage = webPage;
    }

    @Override
    public void onClick() {
        if (this.webPage != null) {
            setResponsePage(this.webPage);
        }
    }

    @Override
    public void onInitialize() {
        super.onInitialize();
        add(RdLinkBehavior.INSTANCE);
    }

    @Override
    public void onComponentTag(ComponentTag tag) {
        super.onComponentTag(tag);

        if (this.placeholder) {
            tag.append("class", "utrecht-link--placeholder", " ");
            tag.put("role", "link");
            tag.put("aria-disabled", "true");
        }
    }

    @Override
    public boolean isEnabled() {
        // Use the `isEnabled()` from `Link` to add an extra condition to disable
        // the link: when it is a placeholder.
        return super.isEnabled() && !this.placeholder;
    }

    public void setPlaceholder(boolean enabled) {
        this.placeholder = enabled;
    }
}
