package nl.rotterdam.nl_design_system.wicket.components.select;

import nl.rotterdam.nl_design_system.wicket.components.base.TagNameClassComponentBehavior;
import nl.rotterdam.nl_design_system.wicket.components.css_class_names.CssClassNames;
import org.apache.wicket.markup.ComponentTag;
import org.apache.wicket.markup.head.CssReferenceHeaderItem;

import java.util.ArrayList;
import java.util.List;

import static nl.rotterdam.nl_design_system.wicket.components.CssReferenceHeaderItems.cssReferenceHeaderItem;

class RdSelectBehavior extends TagNameClassComponentBehavior<RdSelect<?>> {
    private static final CssReferenceHeaderItem CSS_HEADER_ITEM = cssReferenceHeaderItem(
        RdSelectBehavior.class,
        "@utrecht/select-css/dist/index.min.css"
    );
    
    static final RdSelectBehavior INSTANCE = new RdSelectBehavior();

    private RdSelectBehavior() {
        super("select", RdSelectCss.BASE, RdSelectCss.HTML_SELECT);
        addHeaderItem(CSS_HEADER_ITEM);
    }

    @Override
    protected List<CssClassNames> customizeComponentAndReturnClasses(RdSelect<?> component, ComponentTag tag) {
        var classNames = new ArrayList<CssClassNames>(1);
        
        if (component.isRequired()) {
            classNames.add(RdSelectCss.REQUIRED);
        }
        
        if (component.hasErrorMessage()) {
            tag.put("aria-invalid", "true");
            classNames.add(RdSelectCss.INVALID);
        }
        
        return classNames;
    }
}
