package nl.rotterdam.nl_design_system.wicket.components.body;

import nl.rotterdam.nl_design_system.wicket.components.base.HeaderItemRenderingBehavior;
import nl.rotterdam.nl_design_system.wicket.html.AfterJqueryJavaScriptContentHeaderItem;
import org.apache.wicket.markup.head.CssReferenceHeaderItem;

import static nl.rotterdam.nl_design_system.wicket.components.CssReferenceHeaderItems.cssReferenceHeaderItem;

/**
 * <p>
 * A 'patching' version of {@link RdBodyBehavior}. Attach this to a page or the top-level panel of a page, if you cannot
 * attach {@link RdBodyTransparentContainer} or another component that uses <code>RdBodyBehavior</code>, to
 * <code>&lt;html&gt;</code>. This behavior will add the header item for the required CSS and a JavaScript header item
 * to add the required CSS class to <code>&lt;html&gt;</code>.
 * </p>
 * <p>
 * Only a single instance is needed. See {@link #INSTANCE}.
 * </p>
 * <p>
 * Based on the
 * <a href="https://nl-design-system.github.io/utrecht/storybook/?path=/docs/css_css-body--docs">CSS implementation of Utrecht</a>.
 * </p>
 */
public class RdPatchingBodyBehavior extends HeaderItemRenderingBehavior {

    private static final CssReferenceHeaderItem CSS = cssReferenceHeaderItem(
        RdPatchingBodyBehavior.class,
        "@utrecht/body-css/dist/index.min.css"
    );

    /**
     * <p>
     * The only instance of this behavior.
     * </p>
     */
    public static final RdPatchingBodyBehavior INSTANCE = new RdPatchingBodyBehavior();

    private RdPatchingBodyBehavior() {
        addHeaderItem(CSS);
        addHeaderItem(new AfterJqueryJavaScriptContentHeaderItem(
            "document.addEventListener('DOMContentLoaded', (event) => { $('body').addClass('"
                + RdBodyCss.BASE.getClassNames()
                + "'); })",
            "patchingBody"));
    }

}
