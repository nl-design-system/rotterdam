package nl.rotterdam.design_system.wicket.components.textbox.utrecht;

import nl.rotterdam.design_system.wicket.components.CssReferenceHeaderItems;
import nl.rotterdam.design_system.wicket.components.base.TagNameClassComponentBehavior;
import org.apache.wicket.markup.ComponentTag;
import org.apache.wicket.markup.head.CssReferenceHeaderItem;
import org.apache.wicket.markup.html.form.TextField;

import java.util.ArrayList;
import java.util.List;

public class UtrechtTextboxBehavior extends TagNameClassComponentBehavior<TextField<?>> {

    private static final CssReferenceHeaderItem CSS_REFERENCE = CssReferenceHeaderItems.cssReferenceHeaderItem(UtrechtTextboxBehavior.class, "@utrecht/textbox-css/dist/index.css");

    public static final UtrechtTextboxBehavior INSTANCE = new UtrechtTextboxBehavior();

    private UtrechtTextboxBehavior() {
        super("input", UtrechtTextboxClasses.DEFAULT_CLASS_NAMES);
        addHeaderItem(CSS_REFERENCE);
    }

    @Override
    protected List<String> customizeComponentAndReturnClasses(TextField<?> component, ComponentTag tag) {

        List<String> classes = new ArrayList<>();
        if (!component.isEnabledInHierarchy()) {
            classes.add(UtrechtTextboxClasses.DISABLED_CLASS_NAME);
        }

        if (component.hasErrorMessage()) {
            classes.add(UtrechtTextboxClasses.INVALID_CLASS_NAME);
        }

        if (component.isRequired()) {
            tag.put("aria-required", "true");
        }
        if (component.hasErrorMessage()) {
            tag.put("aria-invalid", "true");
        }

        return classes;
    }
}
