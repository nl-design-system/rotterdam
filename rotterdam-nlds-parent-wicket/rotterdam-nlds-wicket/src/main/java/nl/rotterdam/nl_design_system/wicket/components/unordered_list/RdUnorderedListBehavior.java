package nl.rotterdam.nl_design_system.wicket.components.unordered_list;

import static nl.rotterdam.nl_design_system.wicket.components.CssReferenceHeaderItems.cssReferenceHeaderItem;

import org.apache.wicket.Component;
import org.apache.wicket.behavior.Behavior;
import org.apache.wicket.markup.ComponentTag;
import org.apache.wicket.markup.head.CssReferenceHeaderItem;
import org.apache.wicket.markup.head.IHeaderResponse;

/**
 * Utrecht onordered list as behavior
 * @see RdUnorderedList
 *
 * TODO: can we make this package private?
 * TODO: extend TagNameClassComponentBehavior
 */
public class RdUnorderedListBehavior extends Behavior {

    private static final CssReferenceHeaderItem CSS = cssReferenceHeaderItem(
        RdUnorderedListBehavior.class,
        "@utrecht/unordered-list-css/dist/index.min.css"
    );

    /**
     * Singleton instance.
     */
    public static final Behavior INSTANCE = new RdUnorderedListBehavior();

    private final String expectedTagName;
    private final String className;

    private RdUnorderedListBehavior() {
        this.expectedTagName = "ul";
        this.className = "utrecht-unordered-list";
    }

    @Override
    public void onComponentTag(Component component, ComponentTag tag) {
        super.onComponentTag(component, tag);

        if (!expectedTagName.equals(tag.getName())) {
            tag.setName(expectedTagName);
        }

        if (!tag.isClose()) {
            tag.put("role", "list");
            tag.append("class", className, " ");
        }
    }

    @Override
    public void renderHead(Component component, IHeaderResponse response) {
        super.renderHead(component, response);
        response.render(CSS);
    }
}
