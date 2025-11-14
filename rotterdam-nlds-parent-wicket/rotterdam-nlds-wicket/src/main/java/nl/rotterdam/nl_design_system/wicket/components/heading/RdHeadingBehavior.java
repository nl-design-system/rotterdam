package nl.rotterdam.nl_design_system.wicket.components.heading;

import static nl.rotterdam.nl_design_system.wicket.components.CssReferenceHeaderItems.cssReferenceHeaderItem;

import java.util.Map;
import org.apache.wicket.Component;
import org.apache.wicket.behavior.Behavior;
import org.apache.wicket.markup.ComponentTag;
import org.apache.wicket.markup.head.CssReferenceHeaderItem;
import org.apache.wicket.markup.head.HeaderItem;
import org.apache.wicket.markup.head.IHeaderResponse;

/**
 * @see RdHeading
 */
@SuppressWarnings("doclint:missing")
public class RdHeadingBehavior extends Behavior {

    public static final CssReferenceHeaderItem HEADING_1_HEADER_ITEM = cssReferenceHeaderItem(
        RdHeadingBehavior.class,
        "@utrecht/heading-1-css/dist/index.css"
    );
    public static final CssReferenceHeaderItem HEADING_2_HEADER_ITEM = cssReferenceHeaderItem(
        RdHeadingBehavior.class,
        "@utrecht/heading-2-css/dist/index.css"
    );
    public static final CssReferenceHeaderItem HEADING_3_HEADER_ITEM = cssReferenceHeaderItem(
        RdHeadingBehavior.class,
        "@utrecht/heading-3-css/dist/index.css"
    );
    public static final CssReferenceHeaderItem HEADING_4_HEADER_ITEM = cssReferenceHeaderItem(
        RdHeadingBehavior.class,
        "@utrecht/heading-4-css/dist/index.css"
    );
    public static final CssReferenceHeaderItem HEADING_5_HEADER_ITEM = cssReferenceHeaderItem(
        RdHeadingBehavior.class,
        "@utrecht/heading-5-css/dist/index.css"
    );
    public static final CssReferenceHeaderItem HEADING_6_HEADER_ITEM = cssReferenceHeaderItem(
        RdHeadingBehavior.class,
        "@utrecht/heading-6-css/dist/index.css"
    );

    public static Behavior heading(int level) {
        Behavior behavior = behaviors.get(level);

        if (behavior == null) {
            throw new IllegalArgumentException("No heading level " + level);
        }

        return behavior;
    }

    private static final Map<Integer, Behavior> behaviors = Map.of(
        1,
        new RdHeadingBehavior(1, HEADING_1_HEADER_ITEM),
        2,
        new RdHeadingBehavior(2, HEADING_2_HEADER_ITEM),
        3,
        new RdHeadingBehavior(3, HEADING_3_HEADER_ITEM),
        4,
        new RdHeadingBehavior(4, HEADING_4_HEADER_ITEM),
        5,
        new RdHeadingBehavior(5, HEADING_5_HEADER_ITEM),
        6,
        new RdHeadingBehavior(6, HEADING_6_HEADER_ITEM)
    );

    private final String expectedTagName;

    private final String className;
    private final HeaderItem cssHeaderItem;

    private RdHeadingBehavior(int level, HeaderItem cssHeaderItem) {
        this.expectedTagName = "h" + level;
        this.className = "utrecht-heading-" + level;
        this.cssHeaderItem = cssHeaderItem;
    }

    @Override
    public void onComponentTag(Component component, ComponentTag tag) {
        super.onComponentTag(component, tag);

        if (!expectedTagName.equals(tag.getName())) {
            tag.setName(expectedTagName);
        }

        if (!tag.isClose()) {
            tag.append("class", className, " ");
        }
    }

    @Override
    public void renderHead(Component component, IHeaderResponse response) {
        super.renderHead(component, response);
        response.render(cssHeaderItem);
    }
}
