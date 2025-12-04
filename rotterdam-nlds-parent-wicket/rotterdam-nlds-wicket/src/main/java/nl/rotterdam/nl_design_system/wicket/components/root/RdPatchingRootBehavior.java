package nl.rotterdam.nl_design_system.wicket.components.root;

import nl.rotterdam.nl_design_system.wicket.components.base.HeaderItemRenderingBehavior;
import nl.rotterdam.nl_design_system.wicket.html.AfterJqueryJavaScriptContentHeaderItem;
import org.apache.wicket.markup.head.CssReferenceHeaderItem;

import static nl.rotterdam.nl_design_system.wicket.components.CssReferenceHeaderItems.cssReferenceHeaderItem;

/**
 * <p>
 * A 'patching' version of {@link RdRootBehavior}. Attach this to a page or the top-level panel of a page, if you cannot
 * attach {@link RdRootTransparentContainer} or another component that uses <code>RdRootBehavior</code>, to
 * <code>&lt;html&gt;</code>. This behavior will add the header item for the required CSS and a JavaScript header item
 * to add the required CSS class to <code>&lt;html&gt;</code>.
 * </p>
 * <p>
 * Only a single instance is needed. See {@link #INSTANCE}.
 * </p>
 * <p>
 * Based on the
 * <a href="https://nl-design-system.github.io/utrecht/storybook/?path=/docs/css_css-root--docs">CSS implementation of</a>.
 * </p>
 */
public class RdPatchingRootBehavior extends HeaderItemRenderingBehavior {

    private static final CssReferenceHeaderItem CSS = cssReferenceHeaderItem(
        RdPatchingRootBehavior.class,
        "@utrecht/root-css/dist/index.min.css"
    );

    /**
     * <p>
     * The only instance of this behavior.
     * </p>
     */
    public static final RdPatchingRootBehavior INSTANCE = new RdPatchingRootBehavior();

    private RdPatchingRootBehavior() {
        addHeaderItem(CSS);
        addHeaderItem(new AfterJqueryJavaScriptContentHeaderItem(
            "document.addEventListener('DOMContentLoaded', (event) => { $('html').addClass('"
                + RdRootCss.BASE.getClassNames()
                + "'); })",
            "patchingRoot"));
    }
}
