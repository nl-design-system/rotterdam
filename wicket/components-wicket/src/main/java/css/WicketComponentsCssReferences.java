package css;

import org.apache.wicket.markup.head.CssHeaderItem;
import org.apache.wicket.markup.head.HeaderItem;
import org.apache.wicket.request.resource.CssResourceReference;

public class WicketComponentsCssReferences {

    /**
     * Use this theme if your organization doesn't have its own theme yet (based on Design System tokens).
     *
     * <p>Check <a href="https://nldesignsystem.nl/handboek/developer/thema-maken/">the manual</a> for details</p>
     */
    public static final HeaderItem THEME_VOORBEELD_GEMEENTE_CSS_HEADER_ITEM = makeHeaderItemForCss(
        "@nl-design-system-unstable/voorbeeld-design-tokens/dist/theme.css"
    );

    private static CssResourceReference makeReference(String file) {
        return new CssResourceReference(WicketComponentsCssReferences.class, file);
    }

    private static HeaderItem makeHeaderItemForCss(String cssName) {
        return CssHeaderItem.forReference(makeReference(cssName));
    }
}
