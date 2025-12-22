package nl.rotterdam.nl_design_system.wicket.components.code;

import nl.rotterdam.nl_design_system.wicket.components.base.TagNameClassComponentBehavior;
import nl.rotterdam.nl_design_system.wicket.components.css_class_names.CssClassNames;
import org.apache.wicket.markup.ComponentTag;

import java.util.List;

import static nl.rotterdam.nl_design_system.wicket.components.CssReferenceHeaderItems.cssReferenceHeaderItem;

class RdCodeBehavior extends TagNameClassComponentBehavior<RdCodeBorder> {
    static final RdCodeBehavior INSTANCE = new RdCodeBehavior();

    private RdCodeBehavior() {
        super("code", RdCodeCss.BASE);
        addHeaderItem(cssReferenceHeaderItem(RdCodeBehavior.class, "@nl-design-system-candidate/code-css/dist/code.css"));
    }

    @Override
    protected List<CssClassNames> customizeComponentAndReturnClasses(RdCodeBorder component, ComponentTag tag) {
        if (!tag.isClose()) {
            tag.put("translate", "no");
        }

        return super.customizeComponentAndReturnClasses(component, tag);
    }
}
