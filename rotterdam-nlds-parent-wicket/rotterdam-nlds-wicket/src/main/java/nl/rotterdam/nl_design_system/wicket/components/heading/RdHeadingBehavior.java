package nl.rotterdam.nl_design_system.wicket.components.heading;

import org.apache.wicket.Component;
import org.apache.wicket.behavior.Behavior;
import org.apache.wicket.markup.ComponentTag;
import org.apache.wicket.markup.head.CssReferenceHeaderItem;
import org.apache.wicket.markup.head.IHeaderResponse;

import java.util.Map;

import static nl.rotterdam.nl_design_system.wicket.components.CssReferenceHeaderItems.cssReferenceHeaderItem;

/**
 * @see RdHeading
 */
@SuppressWarnings("doclint:missing")
public class RdHeadingBehavior extends Behavior {

    public static final CssReferenceHeaderItem HEADING_HEADER_ITEM = cssReferenceHeaderItem(
        RdHeadingBehavior.class,
        "@nl-design-system-candidate/heading-css/dist/heading.css"
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
        new RdHeadingBehavior(1),
        2,
        new RdHeadingBehavior(2),
        3,
        new RdHeadingBehavior(3),
        4,
        new RdHeadingBehavior(4),
        5,
        new RdHeadingBehavior(5),
        6,
        new RdHeadingBehavior(6)
    );

    private final String expectedTagName;
    
    private final String classNames;

    private RdHeadingBehavior(int level) {
        this.expectedTagName = "h" + level;
        this.classNames = "nl-heading nl-heading--level-" + level;
    }

    @Override
    public void onComponentTag(Component component, ComponentTag tag) {
        super.onComponentTag(component, tag);

        if (!expectedTagName.equals(tag.getName())) {
            tag.setName(expectedTagName);
        }

        if (!tag.isClose()) {
            tag.append("class", classNames, " ");
        }
    }

    @Override
    public void renderHead(Component component, IHeaderResponse response) {
        super.renderHead(component, response);
        response.render(HEADING_HEADER_ITEM);
    }
}
