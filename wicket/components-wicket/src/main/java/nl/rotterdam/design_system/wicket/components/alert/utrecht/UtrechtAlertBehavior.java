package nl.rotterdam.design_system.wicket.components.alert.utrecht;

import nl.rotterdam.design_system.wicket.components.base.TagNameClassComponentBehavior;
import org.apache.wicket.Component;
import org.apache.wicket.behavior.Behavior;
import org.apache.wicket.markup.head.CssReferenceHeaderItem;

import java.util.Map;

import static nl.rotterdam.design_system.wicket.components.CssReferenceHeaderItems.cssReferenceHeaderItem;

public class UtrechtAlertBehavior extends TagNameClassComponentBehavior<Component> {

    private static final CssReferenceHeaderItem CSS = cssReferenceHeaderItem(UtrechtAlertBehavior.class, "@utrecht/alert-css/dist/index.css");

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


    private UtrechtAlertBehavior(UtrechtAlertType type) {
        super("div", "utrecht-alert", "utrecht-alert--" + type.type);
        addHeaderItem(CSS);
    }
}
