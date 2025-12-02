package nl.rotterdam.nl_design_system.wicket.components.form_fieldset;

import nl.rotterdam.nl_design_system.wicket.components.base.TagNameClassComponentBehavior;
import nl.rotterdam.nl_design_system.wicket.components.css_class_names.CssClassNames;
import org.apache.wicket.Component;
import org.apache.wicket.markup.ComponentTag;

import java.util.List;

import static nl.rotterdam.nl_design_system.wicket.components.form_fieldset.RdFormFieldsetCss.FIELDSET_ELEMENT;
import static nl.rotterdam.nl_design_system.wicket.components.form_fieldset.RdFormFieldsetCss.HTML_FIELDSET;

class RdFormFieldsetFieldsetBehavior extends TagNameClassComponentBehavior<Component> {
    
    static final RdFormFieldsetFieldsetBehavior INSTANCE = new RdFormFieldsetFieldsetBehavior();

    private RdFormFieldsetFieldsetBehavior() {
        super("fieldset", FIELDSET_ELEMENT, HTML_FIELDSET);
    }

    @Override
    protected List<CssClassNames> customizeComponentAndReturnClasses(Component component, ComponentTag tag) {
        if (!component.isEnabledInHierarchy()) {
            tag.put("disabled", "");
        }
        return super.customizeComponentAndReturnClasses(component, tag);
    }
}
