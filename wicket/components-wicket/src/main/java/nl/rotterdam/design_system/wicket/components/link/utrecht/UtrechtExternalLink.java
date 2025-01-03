package nl.rotterdam.design_system.wicket.components.link.utrecht;

import org.apache.wicket.markup.ComponentTag;
import org.apache.wicket.markup.html.link.ExternalLink;

public class UtrechtExternalLink extends ExternalLink {

    public boolean placeholder = false;

    public UtrechtExternalLink(final String id, final String href, final String label) {
        super(id, href, label);
    }

    @Override
    public void onInitialize() {
        super.onInitialize();
        add(new UtrechtLinkBehavior());
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
