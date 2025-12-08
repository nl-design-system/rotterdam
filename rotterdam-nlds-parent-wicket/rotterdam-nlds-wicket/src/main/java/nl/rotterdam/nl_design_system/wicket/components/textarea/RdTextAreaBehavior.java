package nl.rotterdam.nl_design_system.wicket.components.textarea;

import nl.rotterdam.nl_design_system.wicket.components.base.TagNameClassComponentBehavior;
import nl.rotterdam.nl_design_system.wicket.components.css_class_names.CssClassNames;
import org.apache.wicket.markup.ComponentTag;
import org.apache.wicket.markup.html.form.TextArea;

import java.util.ArrayList;
import java.util.List;

import static nl.rotterdam.nl_design_system.wicket.components.CssReferenceHeaderItems.cssReferenceHeaderItem;

class RdTextAreaBehavior extends TagNameClassComponentBehavior<TextArea<?>> {

    static final RdTextAreaBehavior INSTANCE = new RdTextAreaBehavior();

    private RdTextAreaBehavior() {
        super("textarea", RdTextAreaCss.BASE);
        addHeaderItem(cssReferenceHeaderItem(RdTextAreaBehavior.class, "@utrecht/textarea-css/dist/index.min.css"));
    }

    @Override
    protected List<CssClassNames> customizeComponentAndReturnClasses(TextArea<?> component, ComponentTag tag) {
        List<CssClassNames> classes = new ArrayList<>();
        if (!component.isEnabledInHierarchy()) {
            classes.add(RdTextAreaCss.DISABLED);
        }

        if (component.hasErrorMessage()) {
            classes.add(RdTextAreaCss.INVALID);
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
