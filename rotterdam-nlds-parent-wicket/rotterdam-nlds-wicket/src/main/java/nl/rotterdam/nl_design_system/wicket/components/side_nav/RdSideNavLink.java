package nl.rotterdam.nl_design_system.wicket.components.side_nav;

import nl.rotterdam.nl_design_system.wicket.components.component_state.NlComponentState;
import org.apache.wicket.Page;
import org.apache.wicket.markup.ComponentTag;
import org.apache.wicket.markup.html.link.BookmarkablePageLink;
import org.apache.wicket.request.mapper.parameter.PageParameters;
import org.jspecify.annotations.Nullable;

import static nl.rotterdam.nl_design_system.wicket.components.component_state.Community.UTRECHT;
import static nl.rotterdam.nl_design_system.wicket.components.component_state.EstafetteState.COMMUNITY;
import static nl.rotterdam.nl_design_system.wicket.components.component_state.WicketState.PROPOSED_TO_REMOVE;

/**
 * <p>
 * Why proposed to remove? This is a component for an element of a block. Elements must get their markup either from
 * their block or from another block that is a child of their block.
 * </p>
 * @param <T>
 * @deprecated Use a link component instead and add a behavior to set the element CSS class.
 */
@NlComponentState(wicketState = PROPOSED_TO_REMOVE, estafetteState = COMMUNITY, htmlCssImplementedBy = UTRECHT)
@Deprecated(forRemoval = true)
public class RdSideNavLink<T> extends BookmarkablePageLink<T> {

    public boolean placeholder = false;

    public <C extends Page> RdSideNavLink(String id, Class<C> pageClass, @Nullable PageParameters pageParameters) {
        super(id, pageClass, pageParameters);
        setAutoEnable(true);
    }

    @Override
    public boolean linksTo(Page page) {
        return super.linksTo(page) && getPageParameters().equals(page.getPageParameters());
    }

    @Override
    public void onInitialize() {
        super.onInitialize();
        add(new RdSideNavLinkBehavior());
    }

    @Override
    public void onComponentTag(ComponentTag tag) {
        super.onComponentTag(tag);

        if (this.placeholder) {
            String placeholderClassName = "denhaag-sidenav__link--placeholder";
            tag.append("class", placeholderClassName, " ");
            tag.put("role", "link");
            tag.put("aria-disabled", "true");
        }

        if (linksTo(getPage())) {
            tag.put("role", "link");
            tag.put("aria-disabled", "true");
            tag.put("aria-current", "page");
            RdSideNavLinkCss.ACTIVE.appendTo(tag);
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
