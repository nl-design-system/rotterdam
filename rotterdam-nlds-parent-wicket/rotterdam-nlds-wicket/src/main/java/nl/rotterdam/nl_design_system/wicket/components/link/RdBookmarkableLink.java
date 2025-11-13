package nl.rotterdam.nl_design_system.wicket.components.link;

import static nl.rotterdam.nl_design_system.wicket.components.component_state.Community.UTRECHT;
import static nl.rotterdam.nl_design_system.wicket.components.component_state.EstafetteState.COMMUNITY;
import static nl.rotterdam.nl_design_system.wicket.components.component_state.WicketState.NEEDS_REFACTORING;

import nl.rotterdam.nl_design_system.wicket.components.component_state.NlComponentState;
import org.apache.wicket.Page;
import org.apache.wicket.markup.ComponentTag;
import org.apache.wicket.markup.html.link.BookmarkablePageLink;

/**
 * <a href="https://nldesignsystem.nl/link/">Link</a>for bookmarkable pages.
 * @param <T> the page class.
 */
@NlComponentState(wicketState = NEEDS_REFACTORING, estafetteState = COMMUNITY, htmlCssImplementedBy = UTRECHT)
public class RdBookmarkableLink<T> extends BookmarkablePageLink<T> {

    private boolean placeholder = false;

    public <C extends Page> RdBookmarkableLink(String id, Class<C> pageClass) {
        super(id, pageClass);
        this.setAutoEnable(true);
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

        if (linksTo(getPage())) {
            tag.put("role", "link");
            tag.put("aria-disabled", "true");
            tag.put("aria-current", "page");
        }
    }

    @Override
    public boolean isEnabled() {
        // Use the `isEnabled()` from `Link` to add an extra condition to disable
        // the link: when it is a placeholder.
        return super.isEnabled() && !this.placeholder;
    }

    /**
     * Should a placeholder be rendered instead of a link?
     * @param placeholderEnabled true if placeholder should be enabled.
     */
    public void setPlaceholder(boolean placeholderEnabled) {
        this.placeholder = placeholderEnabled;
    }
}
