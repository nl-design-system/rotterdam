package nl.rotterdam.design_system.wicket.components.alert.utrecht;

import css.HTMLUtil;
import org.apache.wicket.Component;
import org.apache.wicket.behavior.Behavior;
import org.apache.wicket.markup.ComponentTag;
import org.apache.wicket.markup.head.CssReferenceHeaderItem;
import org.apache.wicket.markup.head.IHeaderResponse;

import java.util.Map;

import static nl.rotterdam.design_system.wicket.components.CssReferenceHeaderItems.cssReferenceHeaderItem;

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

    public static final CssReferenceHeaderItem CSS = cssReferenceHeaderItem(UtrechtAlertBehavior.class, "@utrecht/alert-css/dist/index.css");


    private final String expectedTagName;
    private final String className;
    private final UtrechtAlertType type;

    private UtrechtAlertBehavior(UtrechtAlertType type) {
        this.expectedTagName = "div";
        this.className = "utrecht-alert";
        this.type = type;
    }

    @Override
    public void onComponentTag(Component component, ComponentTag tag) {
        super.onComponentTag(component, tag);

        if (!expectedTagName.equals(tag.getName())) {
            tag.setName(expectedTagName);
        }

        if (!tag.isClose()) {
            tag.put("class", HTMLUtil.className(this.className, "utrecht-alert utrecht-alert--" + type.type));
        }
    }

    @Override
    public void renderHead(Component component, IHeaderResponse response) {
        super.renderHead(component, response);
        response.render(CSS);
    }
}
