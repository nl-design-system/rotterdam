package nl.rotterdam.design_system.wicket.components.heading.utrecht;

import static css.WicketComponentsCssReferences.*;

import java.util.Map;
import org.apache.wicket.Component;
import org.apache.wicket.behavior.Behavior;
import org.apache.wicket.markup.ComponentTag;
import org.apache.wicket.markup.head.HeaderItem;
import org.apache.wicket.markup.head.IHeaderResponse;

public class UtrechtHeadingBehavior extends Behavior {

    public static Behavior heading(int level) {
        Behavior behavior = behaviors.get(level);

        if (behavior == null) {
            throw new IllegalArgumentException("No heading level " + level);
        }

        return behavior;
    }

    private static final Map<Integer, Behavior> behaviors = Map.of(
        1,
        new UtrechtHeadingBehavior(1, UTRECHT_HEADING_1_HEADER_ITEM),
        2,
        new UtrechtHeadingBehavior(2, UTRECHT_HEADING_2_HEADER_ITEM),
        3,
        new UtrechtHeadingBehavior(3, UTRECHT_HEADING_3_HEADER_ITEM),
        4,
        new UtrechtHeadingBehavior(4, UTRECHT_HEADING_4_HEADER_ITEM),
        5,
        new UtrechtHeadingBehavior(5, UTRECHT_HEADING_5_HEADER_ITEM),
        6,
        new UtrechtHeadingBehavior(6, UTRECHT_HEADING_6_HEADER_ITEM)
    );

    private final String expectedTagName;

    private final String className;
    private final HeaderItem cssHeaderItem;

    private UtrechtHeadingBehavior(int level, HeaderItem cssHeaderItem) {
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
