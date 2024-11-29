package nl.rotterdam.design_system.wicket.components.alert.utrecht;

import static css.WicketComponentsCssReferences.ALERT_HEADER_ITEM;

import css.HTMLUtil;
import java.util.Map;
import org.apache.wicket.Component;
import org.apache.wicket.behavior.Behavior;
import org.apache.wicket.markup.ComponentTag;
import org.apache.wicket.markup.head.HeaderItem;
import org.apache.wicket.markup.head.IHeaderResponse;

public class UtrechtAlertBehavior extends Behavior {

    public static Behavior utrechtAlert(UtrechtAlertType type) {
        Behavior behavior = types.get(type);

        if (behavior == null) {
            throw new IllegalArgumentException("No alert type: " + type);
        }

        return behavior;
    }

    public static final UtrechtAlertBehavior UTRECHT_ALERT_WARNING = new UtrechtAlertBehavior(UtrechtAlertType.WARNING);
    public static final UtrechtAlertBehavior UTRECHT_ALERT_OK = new UtrechtAlertBehavior(UtrechtAlertType.OK);
    public static final UtrechtAlertBehavior UTRECHT_ALERT_ERROR = new UtrechtAlertBehavior(UtrechtAlertType.ERROR);
    public static final UtrechtAlertBehavior UTRECHT_ALERT_INFO = new UtrechtAlertBehavior(UtrechtAlertType.INFO);

    private static final Map<UtrechtAlertType, Behavior> types = Map.of(
        UtrechtAlertType.WARNING,
        UTRECHT_ALERT_WARNING,
        UtrechtAlertType.INFO,
        UTRECHT_ALERT_INFO,
        UtrechtAlertType.ERROR,
        UTRECHT_ALERT_ERROR,
        UtrechtAlertType.OK,
        UTRECHT_ALERT_OK
    );

    private final String expectedTagName;
    private final String className;
    private final HeaderItem cssHeaderItem;
    private final UtrechtAlertType type;

    private UtrechtAlertBehavior(UtrechtAlertType type) {
        this.expectedTagName = "div";
        this.className = "utrecht-alert";
        this.cssHeaderItem = ALERT_HEADER_ITEM;
        this.type = type;
    }

    @Override
    public void onComponentTag(Component component, ComponentTag tag) {
        super.onComponentTag(component, tag);

        if (!expectedTagName.equals(tag.getName())) {
            tag.setName(expectedTagName);
        }

        if (!tag.isClose()) {
            tag.put("class", HTMLUtil.className(this.className, "utrecht-alert--" + type.type));
        }
    }

    @Override
    public void renderHead(Component component, IHeaderResponse response) {
        super.renderHead(component, response);
        response.render(cssHeaderItem);
    }
}
