package nl.rotterdam.nl_design_system.wicket.components.link;

import static nl.rotterdam.nl_design_system.wicket.components.component_state.Community.UTRECHT;
import static nl.rotterdam.nl_design_system.wicket.components.component_state.EstafetteState.COMMUNITY;
import static nl.rotterdam.nl_design_system.wicket.components.component_state.WicketState.NEEDS_REFACTORING;

import nl.rotterdam.nl_design_system.wicket.components.component_state.NlComponentState;
import org.apache.wicket.markup.ComponentTag;
import org.apache.wicket.markup.html.link.ExternalLink;

/**
 * <a href="https://nldesignsystem.nl/link/">Link</a> component for links outside the current Wicket application.
 */
@NlComponentState(wicketState = NEEDS_REFACTORING, estafetteState = COMMUNITY, htmlCssImplementedBy = UTRECHT)
public class RdExternalLink extends ExternalLink {

    private boolean placeholder = false;
    private final RdLinkBehavior behavior;

    /**
     * External link
     * @param id the Wicket ID
     * @param href external link to open
     * @param label label
     */
    public RdExternalLink(final String id, final String href, final String label) {
        this(id, href, label, RdLinkBehavior.DEFAULT_INSTANCE);
    }

    public RdExternalLink(final String id, final String href, final String label, RdLinkBehavior behavior) {
        super(id, href, label);
        this.behavior = behavior;
    }

    @Override
    public void onInitialize() {
        super.onInitialize();
        add(behavior);
    }

    @Override
    public void onComponentTag(ComponentTag tag) {
        super.onComponentTag(tag);

        if (this.placeholder) {
            tag.append("class", "nl-link--placeholder", " ");
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

    /**
     * Sets placeholder if link should be rendered read-only.
     * @param placeholderEnabled if placeholder should be shown
     */
    public void setPlaceholder(boolean placeholderEnabled) {
        this.placeholder = placeholderEnabled;
    }
}
