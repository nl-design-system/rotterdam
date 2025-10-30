package nl.rotterdam.wicket.docs.css;

import org.apache.wicket.markup.head.CssHeaderItem;
import org.apache.wicket.markup.head.CssReferenceHeaderItem;
import org.apache.wicket.request.resource.CssResourceReference;

public class NldsVoorbeeldGemeenteThemeCssReference {

    private static final String THEME_CSS_RESOURCE_PATH =
        "@nl-design-system-unstable/voorbeeld-design-tokens/dist/theme.css";

    /**
     * Use this theme if your organization doesn't have its own theme yet (based on Design System tokens).
     *
     * <p>Check <a href="https://nldesignsystem.nl/handboek/developer/thema-maken/">the manual</a> for details</p>
     */
    public static final CssReferenceHeaderItem THEME_VOORBEELD_GEMEENTE_CSS_HEADER_ITEM = makeHeaderItemForCss();

    private static CssReferenceHeaderItem makeHeaderItemForCss() {
        return CssHeaderItem.forReference(makeReference());
    }

    private static CssResourceReference makeReference() {
        return new CssResourceReference(NldsVoorbeeldGemeenteThemeCssReference.class, THEME_CSS_RESOURCE_PATH);
    }
}
