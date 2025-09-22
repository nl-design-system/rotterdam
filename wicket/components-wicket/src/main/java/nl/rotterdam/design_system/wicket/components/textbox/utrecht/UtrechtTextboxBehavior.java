package nl.rotterdam.design_system.wicket.components.textbox.utrecht;

import nl.rotterdam.design_system.wicket.components.CssReferenceHeaderItems;
import nl.rotterdam.design_system.wicket.components.base.TagNameClassComponentBehavior;
import nl.rotterdam.design_system.wicket.components.css_class_names.CssClassNames;
import org.apache.wicket.markup.ComponentTag;
import org.apache.wicket.markup.head.CssReferenceHeaderItem;
import org.apache.wicket.markup.html.form.TextField;

import java.util.ArrayList;
import java.util.List;

public class UtrechtTextboxBehavior extends TagNameClassComponentBehavior<TextField<?>> {

    private static final CssReferenceHeaderItem CSS_REFERENCE = CssReferenceHeaderItems.cssReferenceHeaderItem(UtrechtTextboxBehavior.class, "@utrecht/textbox-css/dist/index.css");

    public static final UtrechtTextboxBehavior INSTANCE = new UtrechtTextboxBehavior();

    private UtrechtTextboxBehavior() {
        super("input", UtrechtTextboxCss.DEFAULT);
        addHeaderItem(CSS_REFERENCE);
    }

    @Override
    protected List<CssClassNames> customizeComponentAndReturnClasses(TextField<?> component, ComponentTag tag) {

        List<CssClassNames> classes = new ArrayList<>();
        if (!component.isEnabledInHierarchy()) {
            classes.add(UtrechtTextboxCss.DISABLED);
        }

        if (component.hasErrorMessage()) {
            classes.add(UtrechtTextboxCss.INVALID);
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
