package nl.rotterdam.design_system.wicket.components.textbox;

import nl.rotterdam.design_system.wicket.components.base.TagNameClassComponentBehavior;
import nl.rotterdam.design_system.wicket.components.css_class_names.CssClassNames;
import org.apache.wicket.markup.ComponentTag;
import org.apache.wicket.markup.html.form.TextField;

import java.util.ArrayList;
import java.util.List;

import static nl.rotterdam.design_system.wicket.components.CssReferenceHeaderItems.cssReferenceHeaderItem;

class NlTextboxBehavior extends TagNameClassComponentBehavior<TextField<?>> {

    public static final NlTextboxBehavior INSTANCE = new NlTextboxBehavior();

    private NlTextboxBehavior() {
        super("input", NlTextboxCss.DEFAULT);
        addHeaderItem(cssReferenceHeaderItem(NlTextboxBehavior.class, "@utrecht/textbox-css/dist/index.css"));
    }

    @Override
    protected List<CssClassNames> customizeComponentAndReturnClasses(TextField<?> component, ComponentTag tag) {

        List<CssClassNames> classes = new ArrayList<>();
        if (!component.isEnabledInHierarchy()) {
            classes.add(NlTextboxCss.DISABLED);
        }

        if (component.hasErrorMessage()) {
            classes.add(NlTextboxCss.INVALID);
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
