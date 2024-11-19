package nl.rotterdam.nl_design.wicket.components.heading;

import org.apache.wicket.AttributeModifier;
import org.apache.wicket.Component;
import org.apache.wicket.MetaDataKey;
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

    private static final Map<Integer, Behavior> behaviors =
            Map.of(
                    1, createBehavior(1),
                    2, createBehavior(2),
                    3, createBehavior(3),
                    4, createBehavior(4),
                    5, createBehavior(5),
                    6, createBehavior(6)
            );

    private final int level;

    private final String expectedTagName;

    private static Behavior createBehavior(int level) {
        return new UtrechtHeadingBehavior(level);
    }

    private UtrechtHeadingBehavior(int level) {
        this.level = level;
        this.expectedTagName = "h" + level;
    }

    private static final MetaDataKey<Boolean> classAdded = new MetaDataKey<>() {
    };

    private static final MetaDataKey<Boolean> tagNameReplaced = new MetaDataKey<>() {
    };

    @Override
    public void onComponentTag(Component component, ComponentTag tag) {
        super.onComponentTag(component, tag);

        Boolean tagNameReplaceAlreadyApplied = component.getMetaData(tagNameReplaced);

        if (tagNameReplaceAlreadyApplied == null) {
            if (!expectedTagName.equals(tag.getName())) {
                tag.setName(expectedTagName);
            }
            component.setMetaData(tagNameReplaced, true);
        }
    }

    @Override
    public void renderHead(Component component, IHeaderResponse response) {
        super.renderHead(component, response);
        response.render(UTRECHT_HEADING_CSS_HEADER_ITEM);
    }

    @Override
    public void onConfigure(Component component) {
        super.onConfigure(component);

        Boolean classAddAlreadyApplied = component.getMetaData(classAdded);
        if (classAddAlreadyApplied == null) {
            component.add(AttributeModifier.append("class", "utrecht-heading-" + level));
            component.setMetaData(classAdded, true);
        }
    }
}
