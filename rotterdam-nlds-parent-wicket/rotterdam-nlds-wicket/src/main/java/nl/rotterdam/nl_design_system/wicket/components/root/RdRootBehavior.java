package nl.rotterdam.nl_design_system.wicket.components.root;

import nl.rotterdam.nl_design_system.wicket.components.base.TagNameClassComponentBehavior;
import org.apache.wicket.markup.head.CssReferenceHeaderItem;
import org.apache.wicket.markup.html.TransparentWebMarkupContainer;

import static nl.rotterdam.nl_design_system.wicket.components.CssReferenceHeaderItems.cssReferenceHeaderItem;

/**
 * <a href="https://nl-design-system.github.io/utrecht/storybook/?path=/docs/css_css-root--docs">Top component of page</a>.
 */
public class RdRootBehavior extends TagNameClassComponentBehavior<TransparentWebMarkupContainer> {

    /**
     * Reference to CSS
     */
    private static final CssReferenceHeaderItem CSS = cssReferenceHeaderItem(
        RdRootBehavior.class,
        "@utrecht/root-css/dist/index.min.css"
    );

    public static final RdRootBehavior INSTANCE = new RdRootBehavior();

    private RdRootBehavior() {
        super("html", RdRootCss.DEFAULT);
        addHeaderItem(CSS);
    }
}
