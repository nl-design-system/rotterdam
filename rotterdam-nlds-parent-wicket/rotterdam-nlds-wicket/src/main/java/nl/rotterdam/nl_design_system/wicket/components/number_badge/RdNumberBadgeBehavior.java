package nl.rotterdam.nl_design_system.wicket.components.number_badge;

import static nl.rotterdam.nl_design_system.wicket.components.CssReferenceHeaderItems.cssReferenceHeaderItem;

import org.apache.wicket.Component;
import org.apache.wicket.behavior.Behavior;
import org.apache.wicket.markup.ComponentTag;
import org.apache.wicket.markup.head.CssReferenceHeaderItem;
import org.apache.wicket.markup.head.IHeaderResponse;

/**
 * @see RdNumberBadge
 * TODO refactor to extend {@link nl.rotterdam.nl_design_system.wicket.components.base.TagNameClassComponentBehavior}
 */
class RdNumberBadgeBehavior extends Behavior {

    private static final CssReferenceHeaderItem CSS = cssReferenceHeaderItem(
        RdNumberBadgeBehavior.class,
        "@utrecht/number-badge-css/dist/index.min.css"
    );

    private final String expectedTagName;
    private final String className;

    public RdNumberBadgeBehavior() {
        this.expectedTagName = "data";
        this.className = "utrecht-number-badge";
    }

    @Override
    public void onComponentTag(Component component, ComponentTag tag) {
        super.onComponentTag(component, tag);

        if (!expectedTagName.equals(tag.getName())) {
            tag.setName(expectedTagName);
        }

        if (!tag.isClose()) {
            tag.append("class", className, " ");
        }
    }

    @Override
    public void renderHead(Component component, IHeaderResponse response) {
        super.renderHead(component, response);
        response.render(CSS);
    }
}
