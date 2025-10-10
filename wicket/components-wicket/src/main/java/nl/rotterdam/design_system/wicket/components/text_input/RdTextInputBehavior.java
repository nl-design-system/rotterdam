package nl.rotterdam.design_system.wicket.components.text_input;

import nl.rotterdam.design_system.wicket.components.base.TagNameClassComponentBehavior;
import nl.rotterdam.design_system.wicket.components.css_class_names.CssClassNames;
import org.apache.wicket.markup.ComponentTag;
import org.apache.wicket.markup.head.CssReferenceHeaderItem;
import org.apache.wicket.markup.html.form.TextField;

import java.util.ArrayList;
import java.util.List;

import static nl.rotterdam.design_system.wicket.components.CssReferenceHeaderItems.cssReferenceHeaderItem;

class RdTextInputBehavior extends TagNameClassComponentBehavior<TextField<?>> {

    static final CssReferenceHeaderItem CSS_HEADER_ITEM = cssReferenceHeaderItem(RdTextInputBehavior.class, "@utrecht/textbox-css/dist/index.css");


    public static final RdTextInputBehavior INSTANCE = new RdTextInputBehavior();

    private RdTextInputBehavior() {
        super("input", RdTextInputCss.DEFAULT);
        addHeaderItem(CSS_HEADER_ITEM);
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
