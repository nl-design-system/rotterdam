package nl.rotterdam.nl_design_system.wicket.components.link;

import nl.rotterdam.nl_design_system.wicket.components.component_state.NlComponentState;
import org.apache.wicket.Page;
import org.apache.wicket.markup.ComponentTag;
import org.apache.wicket.markup.html.link.BookmarkablePageLink;
import org.apache.wicket.request.mapper.parameter.PageParameters;
import org.jspecify.annotations.Nullable;

import static nl.rotterdam.nl_design_system.wicket.components.component_state.Community.KERNTEAM;
import static nl.rotterdam.nl_design_system.wicket.components.component_state.EstafetteState.CANDIDATE;
import static nl.rotterdam.nl_design_system.wicket.components.component_state.WicketState.NEEDS_REFACTORING;

/**
 * <a href="https://nldesignsystem.nl/link/">Link</a>for bookmarkable pages.
 * @param <T> the page class.
 */
@NlComponentState(wicketState = NEEDS_REFACTORING, estafetteState = CANDIDATE, htmlCssImplementedBy = KERNTEAM)
public class RdBookmarkableLink<T> extends BookmarkablePageLink<T> {

    private boolean isPlaceholder = false;
    @Nullable
    private RdLinkContentType contentType;

    public <C extends Page> RdBookmarkableLink(String id, Class<C> pageClass) {
        super(id, pageClass);
    }

    public <C extends Page> RdBookmarkableLink(String id, Class<C> pageClass, PageParameters parameters) {
        super(id, pageClass, parameters);
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

            if (linksTo(getPage())) {
                tag.put("role", "link");
                tag.put("aria-disabled", "true");
                tag.put("aria-current", "page");
            }
        }
    }

    @Override
    public boolean isEnabled() {
        // Use the `isEnabled()` from `Link` to add an extra condition to disable
        // the link: when it is a placeholder.
        return super.isEnabled() && !isPlaceholder;
    }

    /**
     * Should a placeholder be rendered instead of a link?
     * @param isPlaceHolder true if placeholder should be enabled.
     */
    public void setPlaceholder(boolean isPlaceHolder) {
        this.isPlaceholder = isPlaceHolder;
    }

    public void setContentType(@Nullable RdLinkContentType contentType) {
        this.contentType = contentType;
    }
}
