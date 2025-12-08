package nl.rotterdam.nl_design_system.docs.wicket.css;

import org.apache.wicket.markup.head.CssReferenceHeaderItem;

import static nl.rotterdam.nl_design_system.wicket.components.CssReferenceHeaderItems.cssReferenceHeaderItem;

public class BootstrapGridCssReference {

    private BootstrapGridCssReference() {}

    /**
     * Reference to Bootstrap Grid CSS.
     *
     * <p>Bootstrap Grid is intentionally not added to the library, but is used in the examples as a way to
     * layout pages.</p>
     */
    public static final CssReferenceHeaderItem BOOTSTRAP_GRID_CSS = makeHeaderItemForCss();

    private static CssReferenceHeaderItem makeHeaderItemForCss() {
        return cssReferenceHeaderItem(BootstrapGridCssReference.class,
            "bootstrap/dist/css/bootstrap-grid.min.css");
    }
}
