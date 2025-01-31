package nl.rotterdam.design_system.wicket.components.breadcrumb_nav.utrecht;

import org.apache.wicket.Page;
import org.apache.wicket.markup.ComponentTag;
import org.apache.wicket.markup.html.link.BookmarkablePageLink;

public class UtrechtBreadcrumbNavLink<T> extends BookmarkablePageLink<T> {

    public boolean placeholder = false;
    private String placeholderClassName = "utrecht-breadcrumb-nav__link--placeholder";

    public <C extends Page> UtrechtBreadcrumbNavLink(String id, Class<C> pageClass) {
        super(id, pageClass);
        this.setAutoEnable(true);
    }

    @Override
    public void onInitialize() {
        super.onInitialize();
        add(new UtrechtBreadcrumbNavLinkBehavior());
    }

    @Override
    public void onComponentTag(ComponentTag tag) {
        super.onComponentTag(tag);

        if (this.placeholder) {
            tag.append("class", this.placeholderClassName, " ");
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
