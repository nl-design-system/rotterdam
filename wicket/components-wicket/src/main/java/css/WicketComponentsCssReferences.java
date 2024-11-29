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
    public static final HeaderItem THEME_VOORBEELD_GEMEENTE_CSS_HEADER_ITEM = makeHeaderItemForCss("@nl-design-system-unstable/voorbeeld-design-tokens/dist/theme.css");

    private static HeaderItem makeUtrechtHeadingCss(int level) {
        return makeHeaderItemForCss("@utrecht/heading-" + level + "-css/dist/index.css");
    }

    private static HeaderItem makeHeaderItemForCss(String cssName) {
        return CssHeaderItem.forReference(makeReference(cssName));
    }

    private static CssResourceReference makeReference(String file) {
        return new CssResourceReference(WicketComponentsCssReferences.class, file);
    }

}
