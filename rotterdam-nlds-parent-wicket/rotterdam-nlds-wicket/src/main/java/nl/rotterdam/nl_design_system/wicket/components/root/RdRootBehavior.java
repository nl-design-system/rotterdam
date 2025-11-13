package nl.rotterdam.nl_design_system.wicket.components.root;

import static nl.rotterdam.nl_design_system.wicket.components.CssReferenceHeaderItems.cssReferenceHeaderItem;

import org.apache.wicket.Component;
import org.apache.wicket.behavior.Behavior;
import org.apache.wicket.markup.head.CssReferenceHeaderItem;
import org.apache.wicket.markup.head.IHeaderResponse;

/**
 * <a href="https://nl-design-system.github.io/utrecht/storybook/?path=/docs/css_css-root--docs">Top component of page</a>.
 */
public class RdRootBehavior extends Behavior {

    /**
     * Reference to CSS
     */
    private static final CssReferenceHeaderItem CSS = cssReferenceHeaderItem(
        RdRootBehavior.class,
        "@utrecht/root-css/dist/index.css"
    );

    public static final RdRootBehavior INSTANCE = new RdRootBehavior();

    private RdRootBehavior() {
    }

    @Override
    public void renderHead(Component component, IHeaderResponse response) {
        super.renderHead(component, response);

        response.render(CSS);
    }
}
