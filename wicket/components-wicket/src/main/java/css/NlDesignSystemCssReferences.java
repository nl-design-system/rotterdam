package css;

import org.apache.wicket.markup.head.CssHeaderItem;
import org.apache.wicket.markup.head.HeaderItem;
import org.apache.wicket.request.resource.CssResourceReference;

public class NlDesignSystemCssReferences {

    private static final CssResourceReference HEADING_1 = makeReference("@utrecht/heading-1-css/dist/index.css");
    public static final HeaderItem UTRECHT_HEADING_1_HEADER_ITEM = CssHeaderItem.forReference(HEADING_1);
    private static final CssResourceReference HEADING_2 = makeReference("@utrecht/heading-2-css/dist/index.css");
    public static final HeaderItem UTRECHT_HEADING_2_HEADER_ITEM = CssHeaderItem.forReference(HEADING_2);
    private static final CssResourceReference HEADING_3 = makeReference("@utrecht/heading-3-css/dist/index.css");
    public static final HeaderItem UTRECHT_HEADING_3_HEADER_ITEM = CssHeaderItem.forReference(HEADING_3);
    private static final CssResourceReference THEME = makeReference("theme.css");
    private static final CssResourceReference HEADING_4 = makeReference("@utrecht/heading-4-css/dist/index.css");
    public static final HeaderItem UTRECHT_HEADING_4_HEADER_ITEM = CssHeaderItem.forReference(HEADING_4);
    private static final CssResourceReference HEADING_5 = makeReference("@utrecht/heading-5-css/dist/index.css");
    public static final HeaderItem UTRECHT_HEADING_5_HEADER_ITEM = CssHeaderItem.forReference(HEADING_5);
    private static final CssResourceReference HEADING_6 = makeReference("@utrecht/heading-6-css/dist/index.css");
    public static final HeaderItem UTRECHT_HEADING_6_HEADER_ITEM = CssHeaderItem.forReference(HEADING_6);

    public static final HeaderItem THEME_CSS_HEADER_ITEM = CssHeaderItem.forReference(THEME);

    // TODO: support dependencies, and know which dependencies are there
    private static CssResourceReference makeReference(String file) {
        return new CssResourceReference(NlDesignSystemCssReferences.class, file);
    }
}
