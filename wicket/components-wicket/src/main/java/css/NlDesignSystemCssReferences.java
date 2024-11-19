package css;

import org.apache.wicket.markup.head.CssHeaderItem;
import org.apache.wicket.markup.head.HeaderItem;
import org.apache.wicket.request.resource.CssResourceReference;

public class NlDesignSystemCssReferences {

    private static final CssResourceReference INDEX = makeReference("index.css");
    private static final CssResourceReference PARAGRAPH = makeReference("paragraph.css");
    private static final CssResourceReference THEME = makeReference("theme.css");

    public static final HeaderItem PARAGRAPH_CSS_HEADER_ITEM = CssHeaderItem.forReference(PARAGRAPH);
    public static final HeaderItem COMPONENT_LIBRARY_INDEX_CSS_HEADER_ITEM = CssHeaderItem.forReference(INDEX);

    // TODO: will all components in the end have their own CSS file or are we going to create 'one big css' file for
    // components created by Utrecht?
    public static final HeaderItem UTRECHT_HEADING_CSS_HEADER_ITEM = COMPONENT_LIBRARY_INDEX_CSS_HEADER_ITEM;
    public static final HeaderItem THEME_CSS_HEADER_ITEM = CssHeaderItem.forReference(THEME);

    // TODO: support dependencies, and know which dependencies are there
    private static CssResourceReference makeReference(String file) {
        return new CssResourceReference(NlDesignSystemCssReferences.class, file);
    }
}
