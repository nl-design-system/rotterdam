package nl.rotterdam.nl_design_system.rotterdam_css.wicket;

import org.apache.wicket.markup.head.CssReferenceHeaderItem;

import static nl.rotterdam.nl_design_system.wicket.components.CssReferenceHeaderItems.cssReferenceHeaderItem;

class NldsRotterdamDesignSystemThemeCssReference {

    private static final String THEMES_CSS_RESOURCE_PATH = "@gemeente-rotterdam/design-tokens/dist/theme.css";

    static final CssReferenceHeaderItem THEME_ROTTERDAM_RODS_CSS_HEADER_ITEM = makeHeaderItemForCss();

    private static CssReferenceHeaderItem makeHeaderItemForCss() {
        return cssReferenceHeaderItem(NldsRotterdamDesignSystemThemeCssReference.class, THEMES_CSS_RESOURCE_PATH);
    }

}
