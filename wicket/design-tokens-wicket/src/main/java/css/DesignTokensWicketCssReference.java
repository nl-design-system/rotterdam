package css;

import org.apache.wicket.markup.head.CssHeaderItem;
import org.apache.wicket.markup.head.HeaderItem;
import org.apache.wicket.request.resource.CssResourceReference;

public class DesignTokensWicketCssReference {

    public static final HeaderItem THEME_ROTTERDAM_RODS_CSS_HEADER_ITEM = makeHeaderItemForCss("@gemeente-rotterdam/design-tokens/dist/theme.css");

    private static HeaderItem makeHeaderItemForCss(String cssName) {
        return CssHeaderItem.forReference(makeReference(cssName));
    }

    private static CssResourceReference makeReference(String file) {
        return new CssResourceReference(DesignTokensWicketCssReference.class, file);
    }

}
