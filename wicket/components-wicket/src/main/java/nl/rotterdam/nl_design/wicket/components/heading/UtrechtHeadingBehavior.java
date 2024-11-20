package nl.rotterdam.nl_design.wicket.components.heading;

import org.apache.wicket.Component;
import org.apache.wicket.behavior.Behavior;
import org.apache.wicket.markup.ComponentTag;
import org.apache.wicket.markup.head.IHeaderResponse;

import java.util.Map;

import static css.NlDesignSystemCssReferences.UTRECHT_HEADING_CSS_HEADER_ITEM;

public class UtrechtHeadingBehavior extends Behavior {

    public static Behavior heading(int level) {
        Behavior behavior = behaviors.get(level);

        if (behavior == null) {
            throw new IllegalArgumentException("No heading level " + level);
        }

        return behavior;
    }

    private static final Map<Integer, Behavior> behaviors
            = Map.of(
            1, new UtrechtHeadingBehavior(1),
            2, new UtrechtHeadingBehavior(2),
            3, new UtrechtHeadingBehavior(3),
            4, new UtrechtHeadingBehavior(4),
            5, new UtrechtHeadingBehavior(5),
            6, new UtrechtHeadingBehavior(6)
    );

    private final String expectedTagName;

    private final String className;

    private UtrechtHeadingBehavior(int level) {
        this.expectedTagName = "h" + level;
        this.className = "utrecht-heading-" + level;
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
        response.render(UTRECHT_HEADING_CSS_HEADER_ITEM);
    }

}
