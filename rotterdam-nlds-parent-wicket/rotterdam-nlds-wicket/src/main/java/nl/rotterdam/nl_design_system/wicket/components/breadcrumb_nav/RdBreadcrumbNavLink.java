package nl.rotterdam.nl_design_system.wicket.components.breadcrumb_nav;

import static nl.rotterdam.nl_design_system.wicket.components.component_state.Community.UTRECHT;
import static nl.rotterdam.nl_design_system.wicket.components.component_state.EstafetteState.COMMUNITY;
import static nl.rotterdam.nl_design_system.wicket.components.component_state.WicketState.NEEDS_REFACTORING;

import nl.rotterdam.nl_design_system.wicket.components.component_state.NlComponentState;
import org.apache.wicket.Page;
import org.apache.wicket.markup.ComponentTag;
import org.apache.wicket.markup.html.link.BookmarkablePageLink;

@NlComponentState(wicketState = NEEDS_REFACTORING, estafetteState = COMMUNITY, htmlCssImplementedBy = UTRECHT)
public class RdBreadcrumbNavLink<T> extends BookmarkablePageLink<T> {

    public boolean placeholder = false;

    public <C extends Page> RdBreadcrumbNavLink(String id, Class<C> pageClass) {
        super(id, pageClass);
        this.setAutoEnable(true);
    }

    @Override
    public void onInitialize() {
        super.onInitialize();
        add(new RdBreadcrumbNavLinkBehavior());
    }

    @Override
    public void onComponentTag(ComponentTag tag) {
        super.onComponentTag(tag);

        if (this.placeholder) {
            String placeholderClassName = "utrecht-breadcrumb-nav__link--placeholder";
            tag.append("class", placeholderClassName, " ");
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

    public void setPlaceholder(boolean enabled) {
        this.placeholder = enabled;
    }
}
