package nl.rotterdam.nl_design_system.wicket.components.fieldset;

import nl.rotterdam.nl_design_system.wicket.components.base.TagNameClassComponentBehavior;
import nl.rotterdam.nl_design_system.wicket.components.css_class_names.CssClassNames;
import org.apache.wicket.Component;
import org.apache.wicket.markup.ComponentTag;

import java.util.List;

import static nl.rotterdam.nl_design_system.wicket.components.fieldset.RdFieldsetCss.FIELDSET_ELEMENT;
import static nl.rotterdam.nl_design_system.wicket.components.fieldset.RdFieldsetCss.HTML_FIELDSET;

class RdFieldsetFieldsetBehavior extends TagNameClassComponentBehavior<Component> {
    
    static final RdFieldsetFieldsetBehavior INSTANCE = new RdFieldsetFieldsetBehavior();

    private RdFieldsetFieldsetBehavior() {
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
