package nl.rotterdam.nl_design_system.docs.wicket.css;

import org.apache.wicket.markup.head.CssReferenceHeaderItem;

import static nl.rotterdam.nl_design_system.wicket.components.CssReferenceHeaderItems.cssReferenceHeaderItem;

public class NldsVoorbeeldGemeenteThemeCssReference {

    /**
     * Use this theme if your organization doesn't have its own theme yet (based on Design System tokens).
     *
     * <p>Check <a href="https://nldesignsystem.nl/handboek/developer/thema-maken/">the manual</a> for details</p>
     */
    public static final CssReferenceHeaderItem THEME_VOORBEELD_GEMEENTE_CSS_HEADER_ITEM = makeHeaderItemForCss();

    private static CssReferenceHeaderItem makeHeaderItemForCss() {
        return cssReferenceHeaderItem(NldsVoorbeeldGemeenteThemeCssReference.class,
            "@nl-design-system-unstable/voorbeeld-design-tokens/dist/theme.css");
    }
}
