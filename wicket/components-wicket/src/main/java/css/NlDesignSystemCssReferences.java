package css;

import org.apache.wicket.markup.head.CssHeaderItem;
import org.apache.wicket.markup.head.HeaderItem;
import org.apache.wicket.request.resource.CssResourceReference;

public class NlDesignSystemCssReferences {

    public static final HeaderItem UTRECHT_HEADING_1_HEADER_ITEM = makeUtrechtHeadingCss(1);
    public static final HeaderItem UTRECHT_HEADING_2_HEADER_ITEM = makeUtrechtHeadingCss(2);
    public static final HeaderItem UTRECHT_HEADING_3_HEADER_ITEM = makeUtrechtHeadingCss(3);
    public static final HeaderItem UTRECHT_HEADING_4_HEADER_ITEM = makeUtrechtHeadingCss(4);
    public static final HeaderItem UTRECHT_HEADING_5_HEADER_ITEM = makeUtrechtHeadingCss(5);
    public static final HeaderItem UTRECHT_HEADING_6_HEADER_ITEM = makeUtrechtHeadingCss(6);

    public static final HeaderItem THEME_CSS_HEADER_ITEM = makeHeaderItemForCss("theme.css");

    public static final HeaderItem PAGE_LAYOUT_HEADER_ITEM = makeHeaderItemForCss(
        "@utrecht/page-layout-css/dist/index.css"
    );

    // TODO: support dependencies, and know which dependencies are there
    private static CssResourceReference makeReference(String file) {
        return new CssResourceReference(NlDesignSystemCssReferences.class, file);
    }

    private static HeaderItem makeUtrechtHeadingCss(int level) {
        return makeHeaderItemForCss("@utrecht/heading-" + level + "-css/dist/index.css");
    }

    private static HeaderItem makeHeaderItemForCss(String cssName) {
        return CssHeaderItem.forReference(makeReference(cssName));
    }
}
