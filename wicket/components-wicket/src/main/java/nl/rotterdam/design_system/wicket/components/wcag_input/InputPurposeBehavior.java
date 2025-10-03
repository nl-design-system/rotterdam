package nl.rotterdam.design_system.wicket.components.wcag_input;

import nl.rotterdam.design_system.wicket.components.base.TagNameClassComponentBehavior;
import nl.rotterdam.design_system.wicket.components.css_class_names.CssClassNames;
import org.apache.wicket.Component;
import org.apache.wicket.markup.ComponentTag;

import java.util.List;

public class InputPurposeBehavior extends TagNameClassComponentBehavior<Component> {

    private final WcagInputPurpose wcagInputPurpose;

    public InputPurposeBehavior(WcagInputPurpose wcagInputPurpose) {
        super("input", new CssClassNames[0]);
        this.wcagInputPurpose = wcagInputPurpose;
    }

    @Override
    protected List<CssClassNames> customizeComponentAndReturnClasses(Component component, ComponentTag tag) {

        tag.put("autocomplete", wcagInputPurpose.getInputPurpose());
        tag.put("spellcheck", "false");

        return super.customizeComponentAndReturnClasses(component, tag);
    }
}
