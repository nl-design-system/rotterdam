package nl.rotterdam.nl_design_system.wicket.components.text_input;

import static nl.rotterdam.nl_design_system.wicket.components.CssReferenceHeaderItems.cssReferenceHeaderItem;

import java.util.ArrayList;
import java.util.List;
import nl.rotterdam.nl_design_system.wicket.components.base.TagNameClassComponentBehavior;
import nl.rotterdam.nl_design_system.wicket.components.css_class_names.CssClassNames;
import org.apache.wicket.markup.ComponentTag;
import org.apache.wicket.markup.html.form.TextField;

class RdTextInputBehavior extends TagNameClassComponentBehavior<TextField<?>> {

    static final RdTextInputBehavior INSTANCE = new RdTextInputBehavior();

    private RdTextInputBehavior() {
        super("input", RdTextInputCss.DEFAULT);
        addHeaderItem(cssReferenceHeaderItem(RdTextInputBehavior.class, "@utrecht/textbox-css/dist/index.css"));
    }

    @Override
    protected List<CssClassNames> customizeComponentAndReturnClasses(TextField<?> component, ComponentTag tag) {
        List<CssClassNames> classes = new ArrayList<>();
        if (!component.isEnabledInHierarchy()) {
            classes.add(RdTextInputCss.DISABLED);
        }

        if (component.hasErrorMessage()) {
            classes.add(RdTextInputCss.INVALID);
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
