package nl.rotterdam.nl_design_system.css.wicket;

import org.apache.wicket.markup.head.CssHeaderItem;
import org.apache.wicket.markup.head.CssReferenceHeaderItem;
import org.apache.wicket.request.resource.CssResourceReference;

public class NldsRotterdamDesignSystemThemeCssReference {

    private static final String THEMES_CSS_RESOURCE_PATH = "@gemeente-rotterdam/design-tokens/dist/theme.css";

    public static final CssReferenceHeaderItem THEME_ROTTERDAM_RODS_CSS_HEADER_ITEM = makeHeaderItemForCss();

    private static CssReferenceHeaderItem makeHeaderItemForCss() {
        return CssHeaderItem.forReference(makeReference());
    }

    private static CssResourceReference makeReference() {
        return new CssResourceReference(NldsRotterdamDesignSystemThemeCssReference.class, THEMES_CSS_RESOURCE_PATH);
    }
}
