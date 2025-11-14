package nl.rotterdam.nl_design_system.wicket.components.alert;

import static nl.rotterdam.nl_design_system.wicket.components.CssReferenceHeaderItems.cssReferenceHeaderItem;

import java.util.Map;

import nl.rotterdam.nl_design_system.wicket.components.base.TagNameClassComponentBehavior;
import org.apache.wicket.Component;
import org.apache.wicket.behavior.Behavior;
import org.apache.wicket.markup.head.CssReferenceHeaderItem;

class RdAlertBehavior extends TagNameClassComponentBehavior<Component> {

    private static final CssReferenceHeaderItem CSS = cssReferenceHeaderItem(
        RdAlertBehavior.class,
        "@utrecht/alert-css/dist/index.css"
    );

    static Behavior alert(RdAlertType type) {
        Behavior behavior = types.get(type);

        if (behavior == null) {
            throw new IllegalArgumentException("No alert type: " + type);
        }

        return behavior;
    }

    static final RdAlertBehavior ALERT_WARNING = new RdAlertBehavior(RdAlertType.WARNING);
    static final RdAlertBehavior ALERT_OK = new RdAlertBehavior(RdAlertType.OK);
    static final RdAlertBehavior ALERT_ERROR = new RdAlertBehavior(RdAlertType.ERROR);
    static final RdAlertBehavior ALERT_INFO = new RdAlertBehavior(RdAlertType.INFO);

    private static final Map<RdAlertType, Behavior> types = Map.of(
        RdAlertType.WARNING,
        ALERT_WARNING,
        RdAlertType.INFO,
        ALERT_INFO,
        RdAlertType.ERROR,
        ALERT_ERROR,
        RdAlertType.OK,
        ALERT_OK
    );

    private RdAlertBehavior(RdAlertType type) {
        super("div", toCss(type));
        addHeaderItem(CSS);
    }

    private static RdAlertCss toCss(RdAlertType type) {
        return switch (type) {
            case OK -> RdAlertCss.OK;
            case WARNING -> RdAlertCss.WARNING;
            case ERROR -> RdAlertCss.ERROR;
            case INFO -> RdAlertCss.INFO;
        };
    }
}
