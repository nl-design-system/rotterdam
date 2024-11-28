package css;

import org.apache.wicket.markup.head.CssHeaderItem;
import org.apache.wicket.markup.head.HeaderItem;
import org.apache.wicket.request.resource.CssResourceReference;

public class WicketComponentsCssReferences {

    public static final HeaderItem UTRECHT_HEADING_1_HEADER_ITEM = makeUtrechtHeadingCss(1);
    public static final HeaderItem UTRECHT_HEADING_2_HEADER_ITEM = makeUtrechtHeadingCss(2);
    public static final HeaderItem UTRECHT_HEADING_3_HEADER_ITEM = makeUtrechtHeadingCss(3);
    public static final HeaderItem UTRECHT_HEADING_4_HEADER_ITEM = makeUtrechtHeadingCss(4);
    public static final HeaderItem UTRECHT_HEADING_5_HEADER_ITEM = makeUtrechtHeadingCss(5);
    public static final HeaderItem UTRECHT_HEADING_6_HEADER_ITEM = makeUtrechtHeadingCss(6);

    /**
     * Use this theme if your organization doesn't have its own theme yet (based on Design System tokens).
     *
     * <p>Check <a href="https://nldesignsystem.nl/handboek/developer/thema-maken/">the manual</a> for details</p>
     */
    public static final HeaderItem THEME_VOORBEELD_GEMEENTE_CSS_HEADER_ITEM = makeHeaderItemForCss(
        "@nl-design-system-unstable/voorbeeld-design-tokens/dist/theme.css"
    );
    public static final HeaderItem THEME_CSS_HEADER_ITEM = makeHeaderItemForCss("theme.css");
    public static final HeaderItem ROOT_HEADER_ITEM = makeHeaderItemForCss("@utrecht/root-css/dist/index.css");
    public static final HeaderItem BODY_HEADER_ITEM = makeHeaderItemForCss("@utrecht/body-css/dist/index.css");
    public static final HeaderItem CHECKBOX_HEADER_ITEM = makeHeaderItemForCss("@utrecht/checkbox-css/dist/index.css");
    public static final HeaderItem CUSTOM_CHECKBOX_HEADER_ITEM = makeHeaderItemForCss(
        "@utrecht/custom-checkbox-css/dist/index.css"
    );
    public static final HeaderItem FORM_FIELD_ERROR_MESSAGE_HEADER_ITEM = makeHeaderItemForCss(
        "@utrecht/form-field-error-message-css/dist/index.css"
    );
    public static final HeaderItem FORM_FIELD_DESCRIPTION_HEADER_ITEM = makeHeaderItemForCss(
        "@utrecht/form-description-css/dist/index.css"
    );
    public static final HeaderItem FORM_FIELD_HEADER_ITEM = makeHeaderItemForCss(
        "@utrecht/form-field-css/dist/index.css"
    );
    public static final HeaderItem FORM_LABEL_HEADER_ITEM = makeHeaderItemForCss(
        "@utrecht/form-label-css/dist/index.css"
    );
    public static final HeaderItem PAGE_HEADER_HEADER_ITEM = makeHeaderItemForCss(
        "@utrecht/page-header-css/dist/index.css"
    );
    public static final HeaderItem PAGE_BODY_HEADER_ITEM = makeHeaderItemForCss(
        "@utrecht/page-body-css/dist/index.css"
    );
    public static final HeaderItem PAGE_FOOTER_HEADER_ITEM = makeHeaderItemForCss(
        "@utrecht/page-footer-css/dist/index.css"
    );
    public static final HeaderItem PAGE_LAYOUT_HEADER_ITEM = makeHeaderItemForCss(
        "@utrecht/page-layout-css/dist/index.css"
    );
    public static final HeaderItem HTML_CONTENT_HEADER_ITEM = makeHeaderItemForCss(
        "@utrecht/html-content-css/dist/index.css"
    );
    public static final HeaderItem NUMBER_BADGE_HEADER_ITEM = makeHeaderItemForCss(
        "@utrecht/number-badge-css/dist/index.css"
    );
    public static final HeaderItem SEPARATOR_HEADER_ITEM = makeHeaderItemForCss(
        "@utrecht/separator-css/dist/index.css"
    );
    public static final HeaderItem BUTTON_GROUP_HEADER_ITEM = makeHeaderItemForCss(
        "@utrecht/button-group-css/dist/index.css"
    );
    public static final HeaderItem ORDERED_LIST_HEADER_ITEM = makeHeaderItemForCss(
        "@utrecht/ordered-list-css/dist/index.css"
    );
    public static final HeaderItem UNORDERED_LIST_HEADER_ITEM = makeHeaderItemForCss(
        "@utrecht/unordered-list-css/dist/index.css"
    );
    public static final HeaderItem ALERT_HEADER_ITEM = makeHeaderItemForCss("@utrecht/alert-css/dist/index.css");

    public static final HeaderItem BADGE_LIST_HEADER_ITEM = makeHeaderItemForCss(
        "@utrecht/badge-list-css/dist/index.css"
    );
    public static final HeaderItem COLUMN_LAYOUT_HEADER_ITEM = makeHeaderItemForCss(
        "@utrecht/column-layout-css/dist/index.css"
    );
    public static final HeaderItem HEADING_GROUP_HEADER_ITEM = makeHeaderItemForCss(
        "@utrecht/heading-group-css/dist/index.css"
    );
    public static final HeaderItem LOGO_HEADER_ITEM = makeHeaderItemForCss("@utrecht/logo-css/dist/index.css");
    public static final HeaderItem ICON_HEADER_ITEM = makeHeaderItemForCss("@utrecht/icon/dist/index.css");

    // TODO: support dependencies, and know which dependencies are there
    private static CssResourceReference makeReference(String file) {
        return new CssResourceReference(WicketComponentsCssReferences.class, file);
    }

    private static HeaderItem makeUtrechtHeadingCss(int level) {
        return makeHeaderItemForCss("@utrecht/heading-" + level + "-css/dist/index.css");
    }

    private static HeaderItem makeHeaderItemForCss(String cssName) {
        return CssHeaderItem.forReference(makeReference(cssName));
    }
}
