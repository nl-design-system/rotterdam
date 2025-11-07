package nl.rotterdam.nl_design_system.wicket.components.icon_button;

import nl.rotterdam.nl_design_system.wicket.components.css_class_names.CssClassNames;
import org.jspecify.annotations.NonNull;

/**
 * <p>
 * The (optional) size of the button.
 * </p>
 *
 * @see RdIconAjaxButtonBorder
 */
public enum RdIconButtonSize implements CssClassNames {
    HEADING_1("ams-icon--heading-1"),
    HEADING_2("ams-icon--heading-2"),
    HEADING_3("ams-icon--heading-3"),
    HEADING_4("ams-icon--heading-4"),
    HEADING_5("ams-icon--heading-5"),
    HEADING_6("ams-icon--heading-6"),
    LARGE("ams-icon--large"),
    SMALL("ams-icon--small");

    @NonNull
    private final String classNames;

    RdIconButtonSize(@NonNull String classNames) {
        this.classNames = classNames;
    }


    @Override
    public @NonNull String getClassNames() {
        return classNames;
    }
}
