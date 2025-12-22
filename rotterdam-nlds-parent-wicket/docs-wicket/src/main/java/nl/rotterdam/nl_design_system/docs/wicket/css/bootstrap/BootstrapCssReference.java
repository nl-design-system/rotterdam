package nl.rotterdam.nl_design_system.docs.wicket.css.bootstrap;

import org.apache.wicket.markup.head.CssReferenceHeaderItem;

import static nl.rotterdam.nl_design_system.wicket.components.CssReferenceHeaderItems.cssReferenceHeaderItem;

public class BootstrapCssReference {

    private BootstrapCssReference() {}

    /**
     * Reference to Bootstrap Grid CSS.
     *
     * <p>Bootstrap Grid is intentionally not added to the library, but is used in the examples as a way to
     * layout pages.</p>
     */
    public static final CssReferenceHeaderItem BOOTSTRAP_GRID_CSS = makeHeaderItemForCss("grid");
    public static final CssReferenceHeaderItem BOOTSTRAP_UTILITIES_CSS = makeHeaderItemForCss("utilities");

    private static CssReferenceHeaderItem makeHeaderItemForCss(String bootstrapComponent) {
        return cssReferenceHeaderItem(BootstrapCssReference.class,
            "bootstrap-" + bootstrapComponent + ".min.css");
    }
}
