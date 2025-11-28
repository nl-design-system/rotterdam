package nl.rotterdam.nl_design_system.wicket.components.link;

import nl.rotterdam.nl_design_system.wicket.components.component_state.NlComponentState;
import org.apache.wicket.markup.ComponentTag;
import org.apache.wicket.markup.html.link.ExternalLink;
import org.apache.wicket.model.IModel;
import org.jspecify.annotations.Nullable;

import static nl.rotterdam.nl_design_system.wicket.components.component_state.Community.KERNTEAM;
import static nl.rotterdam.nl_design_system.wicket.components.component_state.EstafetteState.CANDIDATE;
import static nl.rotterdam.nl_design_system.wicket.components.component_state.WicketState.NEEDS_REFACTORING;

/**
 * <a href="https://nldesignsystem.nl/link/">Link</a> component for links outside the current Wicket application.
 */
@NlComponentState(wicketState = NEEDS_REFACTORING, estafetteState = CANDIDATE, htmlCssImplementedBy = KERNTEAM)
public class RdExternalLink extends ExternalLink {

    private boolean isPlaceholder = false;
    @Nullable
    private RdLinkContentType contentType;

    public RdExternalLink(String id, String href) {
        super(id, href);
    }

    /**
     * External link
     * @param id the Wicket ID
     * @param href external link to open
     * @param label label
     */
    public RdExternalLink(final String id, final String href, final String label) {
        super(id, href, label);
    }

    public RdExternalLink(String id, IModel<String> href) {
        super(id, href);
    }

    public RdExternalLink(String id, IModel<String> href, IModel<?> label) {
        super(id, href, label);
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

    /**
     * Sets placeholder if link should be rendered read-only.
     * @param isPlaceholder if placeholder should be shown
     */
    public void setIsPlaceholder(boolean isPlaceholder) {
        this.isPlaceholder = isPlaceholder;
    }

    public void setContentType(@Nullable RdLinkContentType contentType) {
        this.contentType = contentType;
    }
}
